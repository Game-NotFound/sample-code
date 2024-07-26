package vn.hauhh.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ErrorResponse {

    private Date timestamp;
    private int status;
    private String path;
    private String error;
    private String message;

    public ErrorResponse(Date timestamp, int status, String path, String error, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.path = path;
        this.error = error;
        this.message = message;

    }

    public ErrorResponse() {

    }
}
