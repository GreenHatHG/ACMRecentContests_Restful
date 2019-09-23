package team.huoguo.restful.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: 跨域过滤器
 * @author: GreenHatHG
 * @create: 2019-08-02 11:28
 **/

/**
 * 让其他自定义拦截器生效，这里使用CorsFilter配置方式
 */
@Configuration
public class GlobalCorsConfig implements WebMvcConfigurer {

    @Bean
    public CorsFilter corsFilter() {
        //1. 添加 CORS配置信息
        CorsConfiguration config = new CorsConfiguration();
        //放行哪些原始域
        config.addAllowedOrigin("https://www.pistachiol.club:8084");
        config.addAllowedOrigin("https://localhost:8080");
        config.addAllowedOrigin("http://localhost:8080");
        config.addAllowedOrigin("https://localhost:8081");
        config.addAllowedOrigin("http://localhost:8081");
        //是否发送 Cookie
        config.setAllowCredentials(false);
        //放行哪些请求方式
        config.addAllowedMethod("GET");
        //2. 添加映射路径
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/api/contests",config);
        //3. 返回新的CorsFilter
        return new CorsFilter(corsConfigurationSource);
    }

}
