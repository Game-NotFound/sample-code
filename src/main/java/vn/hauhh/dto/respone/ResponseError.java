package vn.hauhh.dto.respone;

public class ResponseError extends ResponseData{

    public ResponseError(int status, String message) {
        super(status, message);
    }
}
