package uz.pdp.eticketdemo.response;

import org.springframework.stereotype.Component;


public abstract class BaseResponse {
    protected static final ApiResponse SUCCESS
            = new ApiResponse("success", 1);

    protected static final ApiResponse NOT_FOUND
            = new ApiResponse("not found", 0);

    protected static final ApiResponse FAILED
            = new ApiResponse("user cannot be added", 0);

}
