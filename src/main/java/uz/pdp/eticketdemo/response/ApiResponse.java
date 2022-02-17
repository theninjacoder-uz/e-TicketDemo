package uz.pdp.eticketdemo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.springframework.http.HttpEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({"message", "status_code", "data"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {
    private String message;
    @JsonProperty("status_code")
    private int statusCode;
    private Object data;

    public ApiResponse(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}