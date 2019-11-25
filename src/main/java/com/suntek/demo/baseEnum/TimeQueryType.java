package com.suntek.demo.baseEnum;

/**
 * @author txq
 */
public enum TimeQueryType {

    HOUR("小时") ,

    DAY("天") ;


    private String desc ;

    TimeQueryType(String desc){
        this.desc = desc ;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }}
