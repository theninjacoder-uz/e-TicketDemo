package uz.pdp.eticketdemo.response;

public abstract class BaseResponse{
    public static final ApiResponse SUCCESS
            = new ApiResponse("success", 1);

    public static final ApiResponse NOT_FOUND
            = new ApiResponse("not found", 0);
}
