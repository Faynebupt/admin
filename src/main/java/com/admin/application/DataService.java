package com.admin.application;
import java.io.*;
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
    public String start(String introduce){
        String script=dataDao.findbyintroducematch(introduce);

//        以下是将脚本存储到操作系统的代码
        FileOutputStream outxml = null;
        BufferedWriter bwxml = null;
        String path="E:\\";
        try {
            String fxml=path+"try.txt";
            System.out.println("f_xml==" + fxml);
            File filexml = new File(fxml);// workflow文件
            if (filexml.exists()) {
                filexml.delete();
            }
            outxml = new FileOutputStream(filexml);// 上传workflow文件
            bwxml = new BufferedWriter(new OutputStreamWriter(outxml));
            bwxml.write(script);
            bwxml.flush();
        } catch (Exception e) {
            System.out.println("try.txt  提交失败");
        } finally {
            if (bwxml != null) {
                try {
                    bwxml.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outxml != null) {
                try {
                    outxml.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        以下是运行的代码
//        try {
//            String fxml3=path+"try.txt";
//            String command1 = "chmod 777 " +" "+ fxml3  ;
//            Runtime.getRuntime().exec(command1).waitFor();
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        return script;
    }
    public List<Data> showScript(){
        List<Data>temp=dataDao.findAll();
        return temp;
    }



}
