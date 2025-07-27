package task1.api;

import task1.model.RegisterRequestDto;
import task1.model.RegisterResponseDto;
import task1.util.ApiResult;

public interface IRegisterApi {
    ApiResult<RegisterResponseDto> sendRegisterRequest(RegisterRequestDto request, String endpoint);
}