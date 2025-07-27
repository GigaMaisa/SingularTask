package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequestDto {
    private String username;
    private String password;
    private String confirmPassword;
}
