package com.admin.application;
import java.util.List;

import com.admin.domain.modle.Data;
import com.admin.infrastructure.persistence.jpa.DataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.admin.domain.modle.User;
import com.admin.infrastructure.persistence.jpa.UserDao;

/**
 * Created by NewUser on 2017/11/13.
 */
@Service
@CacheConfig(cacheNames = "user")
public class DataService {
    @Autowired
    protected UserDao userDao;
    @Autowired
    protected DataDao dataDao;

    @Cacheable(value = "user-list", key = "'list'")
    public List<User> list() {
        return userDao.findAll();
    }
    public void save(Data data){
        dataDao.save(data);
    }
}
