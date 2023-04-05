package com.example.webservice.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("prospector")
public class Prospector {
    @TableId(value = "id")
    private Integer id;
    private String businesschoice;
    private String dataurl;
    private String detmodel;
    private String estmodel;
    private String protype;
    private String detdate;

    public Integer getId() {
        return id;
    }

    public void setUid(Integer id) {
        this.id = id;
    }

    public String getBusinesschoice() {
        return businesschoice;
    }

    public void setBusinesschoice(String businesschoice) {
        this.businesschoice = businesschoice;
    }

    public String getDataurl() {
        return dataurl;
    }

    public void setDataurl(String dataurl) {
        this.dataurl = dataurl;
    }

    public String getDetmodel() {
        return detmodel;
    }

    public void setDetmodel(String detmodel) {
        this.detmodel = detmodel;
    }

    public String getEstmodel() {
        return estmodel;
    }

    public void setEstmodel(String estmodel) {
        this.estmodel = estmodel;
    }

    public String getProtype() {
        return protype;
    }

    public void setProtype(String protype) {
        this.protype = protype;
    }

    public String getDetdate() {
        return detdate;
    }

    public void setDetdate(String detdate) {
        this.detdate = detdate;
    }

    @Override
    public String toString() {
        return "Prospector{" +
                "uid=" + id +
                ", businesschoice='" + businesschoice + '\'' +
                ", dataurl='" + dataurl + '\'' +
                ", detmodel='" + detmodel + '\'' +
                ", estmodel='" + estmodel + '\'' +
                ", protype='" + protype + '\'' +
                ", detdate='" + detdate + '\'' +
                '}';
    }
}