package br.com.udidrive.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date timeStamp;
    private String message;
    private String details;

    public ExceptionResponse(Date timeStamp, String details, String message) {
        this.timeStamp = timeStamp;
        this.details = details;
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}