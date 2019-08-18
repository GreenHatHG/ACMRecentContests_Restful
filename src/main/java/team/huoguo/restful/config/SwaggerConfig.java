package team.huoguo.restful.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description: Swagger的配置类
 * @author: GreenHatHG
 * @create: 2019-07-29 20:33
 **/

@Configuration
@EnableSwagger2
@Profile({"dev"})
public class SwaggerConfig {

    @Bean
    Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("team.huoguo.restful.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .description("获取所有符合条件的信息接口")
                        .contact(new Contact("GreenHatHG",
                                "https://greenhathg.github.io/",
                                "1239776759@qq.com"))
                        .build());
    }
}
