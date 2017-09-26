package name.shanelee.demo.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
class SwaggerConfiguration {
    private static final String DEMO_API = "demo-api";
    //    private static final String EXCLUDE_REGEX = "(\\/error|\\/_admin.*||\\/qac.*)";
    private static final String EXCLUDE_PACKAGE = "org.springframework.boot";
    private static final String DESCRIPTION = "This API greets you!";

    @Bean
    public Docket api(final ApiInfo apiInfo) {
        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName(DEMO_API)
                .apiInfo(apiInfo)
                .select()
                .apis(Predicates.not(RequestHandlerSelectors.basePackage(EXCLUDE_PACKAGE)))
//                .paths(Predicates.not(PathSelectors.regex(EXCLUDE_REGEX)))
                .build();
    }

    @Bean
    ApiInfo apiInfo(final Environment environment) {
        return new ApiInfoBuilder()
                .title("Sample greetings API")
                .description(DESCRIPTION)
                .version("1.0.0")
                .build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }
}