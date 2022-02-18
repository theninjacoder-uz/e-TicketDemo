package uz.pdp.eticketdemo.response;

import org.springframework.http.HttpEntity;

import java.net.http.HttpResponse;

public abstract class BaseResponse{
    protected static final ApiResponse SUCCESS
            = new ApiResponse("success", 1);

    protected static final ApiResponse NOT_FOUND
            = new ApiResponse("not found", 0);

}
