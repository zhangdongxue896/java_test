package com.example.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: Gyx
 * @Date: 2021/4/19 14:54
 * @Table(name = "tb_user") 当类名与表名不一致时，用来关联数据库中数据表的表名
 * @Id 标识该属性对应数据表中的主键列
 * @GeneratedValue(strategy = GenerationType.IDENTITY) 标识该主键列是自动增长
 * @Column(name = "user_name") 当属性名与表的列名不一致时，用来关联数据库中数据表的类名
 * 注意：如果整合的是MyBatis，该注解@Column(name = "user_name")必须得加，
 * 		但整合的是tk-mybatis，只要列名的格式是：user_name，那么属性名可以使用userName,
 * 		就是列名中下划线加小写字母的部分，属性名可以用对应的大写字母代替，这就是我把注解注释了的原因
 */
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "user_name")
    private String userName;

    private String password;

    private String name;

    private Integer age;

    private Integer sex;

    private Date birthday;

    private Date created;

    private Date updated;

    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", created=" + created +
                ", updated=" + updated +
                ", note='" + note + '\'' +
                '}';
    }
}

