package team.huoguo.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.web.bind.annotation.*;
import team.huoguo.restful.bean.Contest;
import team.huoguo.restful.service.ContestService;

import java.util.List;

/**
 * @description: 接收和发送对contest类的请求
 * @author: GreenHatHG
 * @create: 2019-07-20 10:31
 **/

@RestController
@RequestMapping(value="/api")
public class ContestController {

    @Autowired
    private ContestService contestService;

    @RequestMapping(value="/contests", method= RequestMethod.GET)
    @ResponseBody
    public List<Contest> getContests() throws Exception{
        List<Contest> list = contestService.getCorrectInfo();
        System.out.println(list);
        return list;
    }

}
