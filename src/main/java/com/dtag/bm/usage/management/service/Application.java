package com.dtag.bm.usage.management.service;

import static springfox.documentation.builders.PathSelectors.regex;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan("com.*")
@EnableAutoConfiguration(exclude = { HypermediaAutoConfiguration.class })
@EnableMongoRepositories(value = { "com.*" })
@EnableAsync
public class Application {

	@Value("${apiVersion}")
	private String apiVersion;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("usageManagement").apiInfo(apiInfo()).select()
				.paths(regex("/usageManagement.*")).build()
				.directModelSubstitute(XMLGregorianCalendar.class, MixIn.class);
	}
	

	public static interface MixIn {
		@JsonIgnore
		public void setYear(int year);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Usage Management Service APIs")
				.description("Usage Management Service APIs").termsOfServiceUrl("http://techmahindra.com")
				.contact("TechMahindra").license("Techamhindra Licensed").licenseUrl("http://techmahindra.com")
				.version(apiVersion).build();
	}

}
