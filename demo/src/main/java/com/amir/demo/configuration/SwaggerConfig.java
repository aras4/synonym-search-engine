package com.amir.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket synonymApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("synonym-api").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.amir.demo.rest")).build()
				.tags(new Tag("synonyms", "Synonym APIs"));
	}

	private static ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Synonym Engine API").description("API").license("Amir API Licence Type")
				.build();
	}

}
