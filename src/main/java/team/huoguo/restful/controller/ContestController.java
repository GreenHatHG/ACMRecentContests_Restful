package team.huoguo.restful.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/api")
@Api(tags = "比赛信息接口")
public class ContestController {

    @Autowired
    private ContestService contestService;

    @GetMapping("/contests")
    @ApiOperation(value = "得到符合条件的比赛信息",
            notes = "得到的比赛信息有oj,比赛名称,开始时间,结束时间,时长,星期,链接")
    @ApiResponses({
            @ApiResponse(code = 200, message = "获取成功"),
            @ApiResponse(code = 400, message = "获取失败")
    })
    public List<Contest> getContests() throws Exception {
        List<Contest> list = contestService.getCorrectInfo();
        System.out.println(list);
        return list;
    }

}
