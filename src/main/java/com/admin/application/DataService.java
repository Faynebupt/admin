package com.admin.application;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.admin.domain.modle.User;
import com.admin.infrastructure.persistence.jdbc.UserDao;

/**
 * Created by NewUser on 2017/11/13.
 */
@Service
@CacheConfig(cacheNames = "user")
public class DataService {
    @Autowired
    protected UserDao userDao;
    @Cacheable(value = "user-list", key = "'list'")
    public List<User> list() {
        return userDao.findAll();
    }
}
//    public List<User> list() {
//        return userRepository.list();
//
//    @Override
//    public List<User> list() {
//        return jdbcTemplate.query("select * from user where username <> 'root'", BeanPropertyRowMapper.newInstance(User.class));
//    }