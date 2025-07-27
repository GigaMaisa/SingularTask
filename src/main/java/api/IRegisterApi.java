package api;

import model.RegisterRequestDto;
import model.RegisterResponseDto;
import util.ApiResult;

public interface IRegisterApi {
    ApiResult<RegisterResponseDto> sendRegisterRequest(RegisterRequestDto request, String endpoint);
}