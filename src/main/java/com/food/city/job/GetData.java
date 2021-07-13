package com.food.city.job;

import com.food.city.dto.RestaurantDto;
import com.food.city.mapper.RestaurantFileRowMapper;
import com.food.city.processor.RestaurantProcessor;
import com.food.city.model.Restaurant;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import javax.sql.DataSource;

@Configuration
public class GetData {
    private JobBuilderFactory jobBuilderFactory;
    private StepBuilderFactory stepBuilderFactory;
    private RestaurantProcessor restaurantProcessor;
    private DataSource dataSource;

    @Autowired
    public GetData(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, RestaurantProcessor restaurantProcessor , DataSource dataSource){
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.restaurantProcessor = restaurantProcessor;
        this.dataSource = dataSource;
    }
    @Qualifier(value = "GetData")
    @Bean
    public Job getdataJob() throws Exception {
        return this.jobBuilderFactory.get("GetData")
                .start(step1getdata())
                .build();
    }
    @Bean
    public Step step1getdata() throws Exception {
        return this.stepBuilderFactory.get("step1")
                .<RestaurantDto, Restaurant>chunk(10)
                .reader(restaurantReader())
                .processor(restaurantProcessor)
                .writer(restaurantDBWriterDefault())
                .taskExecutor(taskExecutor())
                .build();
    }
    @Bean
    @StepScope
    Resource inputFileResource(@Value("#{jobParameters[fileName]}") final String fileName) throws Exception {
        return new ClassPathResource(fileName);
    }
    @Bean
    @StepScope
    public FlatFileItemReader<RestaurantDto> restaurantReader() throws Exception {
        FlatFileItemReader<RestaurantDto> reader = new FlatFileItemReader<>();
        reader.setResource(inputFileResource(null));
        reader.setLineMapper(new DefaultLineMapper<RestaurantDto>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames("name", "price", "cusine_category" , "city" , "region" , "url" , "pageno" , "cusine_type" , "time" , "rating_type" , "rating" , "votes");
                setDelimiter(",");
            }});
            setFieldSetMapper(new RestaurantFileRowMapper());
        }});
        System.out.println(reader);
        return reader;
    }

    @Bean
    public JdbcBatchItemWriter<Restaurant> restaurantDBWriterDefault() {
        JdbcBatchItemWriter<Restaurant> itemWriter = new JdbcBatchItemWriter<Restaurant>();
        itemWriter.setDataSource(dataSource);
        itemWriter.setSql("insert into restaurant (name, price, cusine_category, city, region,url, pageno, cusine_type,time,rating_type,rating,votes) values (:name, :price, :cusine_category, :city, :region, :url, :pageno, :cusine_type, :time, :rating_type, :rating, :votes)");
        itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Restaurant>());
        return itemWriter;
    }
    @Bean
    public TaskExecutor taskExecutor(){
        SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor();
        simpleAsyncTaskExecutor.setConcurrencyLimit(5);
        return simpleAsyncTaskExecutor;
    }
}
