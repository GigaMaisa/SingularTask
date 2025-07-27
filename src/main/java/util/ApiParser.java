package util;

import io.restassured.response.Response;

public class ApiParser {
    public static <T> ApiResult<T> parse(Response response, Class<T> clazz) {
        int statusCode = response.getStatusCode();

        try {
            if (statusCode == 200) {
                T data = response.as(clazz);
                return new ApiResult.Success<>(data);
            } else {
                var error = response.as(model.ErrorResponseDto.class);
                return new ApiResult.Error<>(statusCode, error.getMessage(), null);
            }
        } catch (Exception e) {
            return new ApiResult.Error<>(statusCode, "Deserialization failed: " + e.getMessage(), null);
        }
    }
}