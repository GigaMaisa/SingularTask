package task1.api;

import io.restassured.response.Response;
import task1.model.RegisterRequestDto;
import task1.model.RegisterResponseDto;
import task1.util.ApiParser;
import task1.util.ApiResult;

public class RegisterApi extends BaseApi implements IRegisterApi {
    @Override
    public ApiResult<RegisterResponseDto> sendRegisterRequest(RegisterRequestDto request, String endpoint) {
        var spec = baseRequest()
                .queryParam("username", request.getUsername())
                .queryParam("password", request.getPassword())
                .queryParam("confirm_password", request.getConfirmPassword());

        Response response = execute(spec, endpoint);
        return ApiParser.parse(response, RegisterResponseDto.class);
    }
}