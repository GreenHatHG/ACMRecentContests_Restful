package team.huoguo.restful.dao;


import org.springframework.stereotype.Component;
import team.huoguo.restful.bean.Contest;

import java.util.List;

/**
 * @description: 对ContestInfo类数据库操作的接口
 * @author: GreenHatHG
 * @create: 2019-07-20 10:29
 **/

public interface ContestDao {

    /**
     * 获得数据库里面所有的数据
     * @return
     */
    List<Contest> getContests();


    /**
     * 从数据库删除指定的数据
     * @param contest
     */
    void deleteOne(Contest contest);
}
