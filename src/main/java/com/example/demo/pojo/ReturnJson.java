package com.example.demo.pojo;

public class ReturnJson {
    String code="8200";
    Object content;
    String success="true";

    public ReturnJson(Object content) {
        this.content = content;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
