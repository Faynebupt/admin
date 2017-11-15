package com.admin.domain.modle;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by NewUser on 2017/11/14.
 */
@Entity
@Table(name="data")
public class Data implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="num")
    private int num;
    @Column(name="introduce")
    private String introduce;
    @Column(name="content")
    private String content;
    public int getNum() {
        return num;
    }
    public void setNum(int  num) {
        this.num = num;
    }
    public String  getIntroduce() {
        return introduce;
    }
    public void setIntroduce(String  introduce) {
        this.introduce = introduce;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
