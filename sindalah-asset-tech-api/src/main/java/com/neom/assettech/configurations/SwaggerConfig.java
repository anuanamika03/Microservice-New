package com.neom.assettech.configurations;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SwaggerConfig implements WebMvcConfigurer {

	
	/*@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.neom.assettech")).paths(PathSelectors.any()).build()
				.securitySchemes(Arrays.asList(apiKey(), clientKey()))
				.securityContexts(Arrays.asList(securityContext())).apiInfo(apiInfoMetaData());
		//.ignoredParameterTypes(UserDetails.class);
	}

	private ApiInfo apiInfoMetaData() {
		return new ApiInfoBuilder().title("Neom AssetTech APIs").description("API Endpoints for Neom AssetTech Application").version("1.0.0")
				.build();
	}*/

/*	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("Token", authorizationScopes),
				new SecurityReference("ClientKey", authorizationScopes));
	}*/

	/*@Bean
	SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.any()).build();
	}

	private ApiKey apiKey() {
		return new ApiKey("Token", "Authorization", "header");
	}

	private ApiKey clientKey() {
		return new ApiKey("ClientKey", "X-Auth-Client", "header");
	}
	
	@Override 
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }*/

}
