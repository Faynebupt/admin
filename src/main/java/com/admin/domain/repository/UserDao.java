package com.admin.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.admin.domain.modle.User;
/**
 * Created by NewUser on 2017/11/09.
 */

@Repository
public interface UserDao extends JpaRepository<User, Long> {
//    User findByName(String name);//select * from user where name = #name
//    User findByNameAndAge(String name, Integer age);
//    User getByAge(Integer age);
//    @Query(value = "select user from User user where user.name=?1")
//    List<User> findByNameMatch(String name);
//    @Query(value = "insert user (id,username,password,email,disabled,createTime,salt) VALUES (?,?,?,?,?,?,?)\",user.getId(),user.getUsername(),user.getPassword(),user.getEmail(),user.isDisabled()?1:0,new Date(),user.getSalt());")
//    void add(User user);
}

