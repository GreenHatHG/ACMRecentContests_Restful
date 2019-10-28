package team.huoguo.restful.service;

import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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

    @Autowired
    private ContestDao contestDao;

    private  List<Contest> list = null;
    /**
     * 得到已经升序不过时的比赛信息,如果信息过时,则从数据库里面删除
     *
     * @return
     */
    public List<Contest> getCorrectInfo() throws Exception {
        list = new ArrayList<>();
        List<Contest> contests = contestDao.getContests();
        for (Contest contest : contests) {
            if (verifyTime(contest)) {
                list.add(contest);
            } else {
                contestDao.deleteOne(contest);
            }
        }
        sortContests(list);
        return list;
    }

    /**
     * 得到按天分类的数据
     * @return
     * @throws Exception
     */
    public MultiValueMap<String, Contest> getInfoByDay() throws Exception {
        if(list == null){
            list = getCorrectInfo();
        }
        String now = DateUtil.now().substring(0, 10);
        String tomorrow = DateUtil.tomorrow().toString().substring(0, 10);
        MultiValueMap<String, Contest> map = new LinkedMultiValueMap<>();
        for(Contest contest : list){
            String startTime = contest.getStartTime().substring(0, 10);
            if(now.equals(startTime)){
                map.add("今天", contest);
            }else if(tomorrow.equals(startTime)){
                map.add("明天", contest);
            }else{
                map.add(startTime, contest);
            }
        }
        return map;
    }

    /**
     * 对items按照开始时间进行排序
     */
    private void sortContests(List<Contest> list) {

        list.sort(new Comparator<Contest>() {

            @Override
            public int compare(Contest o1, Contest o2) {
                return o1.getStartTime().compareTo(o2.getStartTime());
            }
        });
    }

    /**
     * 判断当前信息是否已经过时
     *
     * @param contest
     * @return
     */
    private boolean verifyTime(Contest contest) {
        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        String startTime = contest.getStartTime();
        //startTime大于now
        return startTime != null && startTime.compareTo(now) > 0;
    }

}
