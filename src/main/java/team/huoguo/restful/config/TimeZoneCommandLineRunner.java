package team.huoguo.restful.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.TimeZone;

/**
 * @description: 设置JVM读取的时区为GMT+8,在项目启动时设置
 * @author: GreenHatHG
 * @create: 2019-07-29 15:20
 **/

@Component
public class TimeZoneCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        //获取中国时区
        final TimeZone zone = TimeZone.getTimeZone("GMT+8");
        //设置时区
        TimeZone.setDefault(zone);

        System.out.println("当前时区: " + TimeZone.getDefault());
    }
}
