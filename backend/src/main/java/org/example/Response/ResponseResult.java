package org.example.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ResponseResult {
    private boolean success;
    private int code;
    private String message;
    private Object data;

    public ResponseResult(ResponseState responseState){
        this.success = responseState.isSuccess();
        this.code = responseState.getCode();
        this.message = responseState.getMessage();
    }
    public ResponseResult setData(Object data){
        this.data = data;
        return this;
    }

    public static ResponseResult SUCCESS(){
        return new ResponseResult(ResponseState.SUCCESS);
    }

    public static ResponseResult LOGIN_SUCCESS(){
        return new ResponseResult(ResponseState.LOGIN_SUCCESS);
    }
    public static ResponseResult LOGIN_FAILED(){
        return new ResponseResult(ResponseState.LOGIN_FAILED);
    }
    public static ResponseResult GET_RESOURCE_FAILED(){
        return new ResponseResult(ResponseState.GET_RESOURCE_FAILED);
    }
    public static ResponseResult GET_RESOURCE_SUCCESS(){
        return new ResponseResult(ResponseState.GET_RESOURCE_SUCCESS);
    }

    public static ResponseResult SUCCESS(String message){
        ResponseResult responseResult = new ResponseResult(ResponseState.SUCCESS);
        responseResult.setMessage(message);
        return responseResult;
    }

    public static ResponseResult FAILED(){
        return new ResponseResult(ResponseState.FAILED);
    }
}
