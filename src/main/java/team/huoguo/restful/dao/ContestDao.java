package team.huoguo.restful.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import team.huoguo.restful.bean.Contest;

import java.util.List;

/**
 * @description:
 * @author: GreenHatHG
 * @create: 2019-07-20 10:29
 **/

@Component
public class ContestDao{

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Contest> getContests() {
        return mongoTemplate.findAll(Contest.class);
    }

    public void deleteOne(Contest contest) {
        Query query = Query.query(Criteria.where("name").is(contest.getName()));
        mongoTemplate.remove(query, Contest.class);
    }

    public Contest getContestByName(String name){
        return mongoTemplate.findOne(new
                Query(Criteria.where("name").is(name)), Contest.class);
    }

}
