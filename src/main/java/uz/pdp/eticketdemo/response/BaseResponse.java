package uz.pdp.eticketdemo.response;

public abstract class BaseResponse {
    protected static final ApiResponse SUCCESS
            = new ApiResponse("success", 1);

    protected static final ApiResponse NOT_FOUND
            = new ApiResponse("not found", 0);

}
