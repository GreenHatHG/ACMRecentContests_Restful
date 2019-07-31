package team.huoguo.restful.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: CORS
 * @author: GreenHatHG
 * @create: 2019-07-20 20:21
 **/

@Configuration
class CORSConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/contests")
//                .allowedOrigins("https://www.pistachiol.club:8084")
//                .allowedOrigins("http://localhost:9090")
//                .allowedOrigins("https://localhost:9090")
                .allowedMethods("GET");
    }
}