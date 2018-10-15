package com.flexible.dao;

import com.flexible.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-10-12
 * Time: 23:30
 */
//通过Spring注解定义一个DAO
@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    private final static String MATCH_COUNT_SQL = " SELECT count(*) " +
            "FROM t_user  " +
            "WHERE user_name =? " +
            "AND password=? ";
    private final static String UPDATE_LOGIN_INFO_SQL = " UPDATE t_user " +
            "SET " +
            "last_visit=?," +
            "last_ip=?," +
            "credits=?"+
            " WHERE user_id =?";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 根据用户名查询
     *
     * @param userName
     * @return
     */
    public User getUserByUserName(String userName) {
        String searchSql = "SELECT user_id,user_name,credits " +
                "FROM t_user " +
                "WHERE user_name=?";
        final User user = new User();
        jdbcTemplate.query(searchSql, new Object[]{userName}, (resultSet) -> {
            user.setUserId(resultSet.getInt("user_id"));
            user.setUserName(userName);
            user.setCredits(resultSet.getInt("credits"));
        });
        return user == null ? new User() : user;
    }

    /**
     * 更新用户登陆日志
     *
     * @param user
     */
    public Boolean updateLoginInfo(User user) {
        System.out.println(user.toString());
         Integer flag = jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL, new Object[] { user.getLastVisit(),
                 user.getLastIp(),user.getCredits(),user.getUserId()});
        return flag > 0 ? true : false;
    }

    /**
     * 根据账号和密码查找匹配的数量
     *
     * @param userName
     * @param password
     * @return
     */
    public int getMatchCount(String userName, String password) {
        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[]{userName, password}, Integer.class);
    }
}
