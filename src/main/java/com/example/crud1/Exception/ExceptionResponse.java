package com.example.crud1.Exception;

import java.util.Date;

public class ExceptionResponse {
    private Date timeStamps;
    private String msg;
    private String details;
    
    public ExceptionResponse(Date timeStamps, String msg, String details) {
        this.timeStamps = timeStamps;
        this.msg = msg;
        this.details = details;
    }

    public Date gettimeStamps() {
        return timeStamps;
    }

    public void setTimeStamps(Date timeStamps) {
        this.timeStamps = timeStamps;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
   
}
