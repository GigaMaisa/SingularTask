package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegisterResponseDto {
    @JsonProperty("code")
    private Integer code;
}
