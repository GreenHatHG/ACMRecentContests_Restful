package team.huoguo.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import team.huoguo.restful.bean.Contest;
import team.huoguo.restful.bean.Result;
import team.huoguo.restful.bean.ResultFactory;
import team.huoguo.restful.service.ContestService;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description: 接收和发送对contest类的请求
 * @author: GreenHatHG
 * @create: 2019-07-20 10:31
 **/

@RestController
@RequestMapping(value = "/api/v1")
public class ContestController {

    @Autowired
    private ContestService contestService;

    @GetMapping("/contests")
    public Result getContests(){
        List<Contest> list = null;
        try{
            list = contestService.getCorrectInfo();
        }catch (Exception e){
            e.printStackTrace();
            return ResultFactory.buildFailResult("获取数据异常-->" +e.getMessage());
        }
        return ResultFactory.buildSuccessResult(list);
    }

    @GetMapping("/contests/day")
    public Result getContestsDay(){
        MultiValueMap<String, Contest> multiValueMap = null;
        try{
            multiValueMap = contestService.getInfoByDay();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("获取数据异常-->" +e.getMessage());
        }
        return ResultFactory.buildSuccessResult(multiValueMap);
    }

    @GetMapping("/contests/name")
    public Result getContestByName(@RequestParam @NotNull String name){
         Contest contest = contestService.getContestByName(name);
         if(contest == null){
             return ResultFactory.buildFailResult("未找到相关比赛信息");
         }
         return ResultFactory.buildSuccessResult(contest);
    }

}
