package api;

import io.restassured.response.Response;
import model.RegisterRequestDto;
import model.RegisterResponseDto;
import util.ApiParser;
import util.ApiResult;

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