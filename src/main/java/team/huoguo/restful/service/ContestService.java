package team.huoguo.restful.service;

import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.huoguo.restful.bean.Contest;
import team.huoguo.restful.dao.ContestDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @description: 获取符合条件的Contest
 * @author: GreenHatHG
 * @create: 2019-07-20 10:31
 **/

@Component
public class ContestService {

    private List<Contest> contests = null;
    @Autowired
    private ContestDao contestDao;

    /**
     * 得到已经升序不过时的比赛信息
     * @return
     */
    public List<Contest> getCorrectInfo() throws Exception{
        List<Contest> list = new ArrayList<Contest>();
        contests = contestDao.getContests();
        for(Contest contest : contests){
            if(verifyTime(contest)){
                list.add(contest);
            }
            else{
                contestDao.deleteOne(contest);
            }
        }
        sortContests(list);
        return list;
    }

    /**
     * 对items按照开始时间进行排序
     */
    public void sortContests(List<Contest> list){

        Collections.sort(list,new Comparator<Contest>() {

            @Override
            public int compare(Contest o1, Contest o2) {
                return o1.getStartTime().compareTo (o2.getStartTime());
            }
        });
    }

    /**
     * 判断当前信息是否已经过时
     * @param contest
     * @return
     */
    public boolean verifyTime(Contest contest) {
        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        String startTime = contest.getStartTime();
        if(startTime.compareTo(now) > 0){
            return true;
        }
        return false;
    }

}
