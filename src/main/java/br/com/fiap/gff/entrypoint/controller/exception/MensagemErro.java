package br.com.fiap.gff.entrypoint.controller.exception;

import java.io.Serializable;

public class MensagemErro implements Serializable {
    private Integer status;
    private String msg;
    private long timeStamp;

    public MensagemErro(Integer status, String msg, long timeStamp) {
        this.status = status;
        this.msg = msg;
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}