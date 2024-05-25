package com.example.demo.config;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.demo.batch.CustomProcessor;
import com.example.demo.migrated.data.MigratedDataModel;
import com.example.demo.old.data.OldDataModel;

@Configuration
public class BatchConfig {

	@Autowired
	DataSource dataSource;

	@Bean
	JdbcCursorItemReader<OldDataModel> reader() {
		// TODO Auto-generated method stub
		JdbcCursorItemReader<OldDataModel> jdbcCursorItemReader = new JdbcCursorItemReader<OldDataModel>();
		jdbcCursorItemReader.setDataSource(dataSource);
		jdbcCursorItemReader.setSql("SELECT id, email_id, name, updated_in_migrated_code FROM public.old_data");
		jdbcCursorItemReader.setRowMapper(new RowMapper<OldDataModel>() {

			@Override
			public OldDataModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				OldDataModel oldDataModel = new OldDataModel();
				oldDataModel.setId(rs.getInt("id"));
				oldDataModel.setEmailId(rs.getString("email_id"));
				oldDataModel.setName(rs.getString("name"));
				oldDataModel.setUpdatedInMigratedCode(rs.getBoolean("updated_in_migrated_code"));
				return oldDataModel;
			}
		});

		return jdbcCursorItemReader;
	}

	@Bean
	JdbcBatchItemWriter<MigratedDataModel> writer() {
		JdbcBatchItemWriter<MigratedDataModel> jdbcBatchItemWriter = new JdbcBatchItemWriter<MigratedDataModel>();
		jdbcBatchItemWriter.setDataSource(dataSource);
		jdbcBatchItemWriter.setSql(
				"INSERT INTO public.migrated_data (id, email_id, name, updated_in_migrated_code) VALUES (:id, :emailId, :name, :updatedInMigratedCode)");
		jdbcBatchItemWriter
				.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<MigratedDataModel>());
		return jdbcBatchItemWriter;
	}

	@Bean
	Job createJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new JobBuilder("job", jobRepository).flow(createStep(jobRepository, transactionManager)).end().build();
	}

	@Bean
	Step createStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new StepBuilder("step", jobRepository).<OldDataModel, MigratedDataModel>chunk(5, transactionManager)
				.allowStartIfComplete(true).faultTolerant().reader(reader()).processor(new CustomProcessor()).writer(writer()).build();

	}

}
