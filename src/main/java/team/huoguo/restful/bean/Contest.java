package team.huoguo.restful.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @description: 比赛信息规范定义类
 * @author: GreenHatHG
 * @create: 2019-07-20 10:30
 **/

@Data
@Document
public class Contest {

    private String oj;
    private String name;
    private String link;
    private String startTime;
    private String endTime;
    private String length;
    private String week;

}
