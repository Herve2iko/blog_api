package com.example.crud1;

public class HelloBean {

    private String msg;
    private int nb;

    
    public HelloBean() {
    }

    public HelloBean(String msg, int nb) {
        this.msg = msg;
        this.nb = nb;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    @Override
    public String toString() {
        return "HelloBean [msg=" + msg + ", nb=" + nb + "]";
    }
    



}
