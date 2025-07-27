package task1.util;

public abstract class ApiResult<T> {

    public static final class Success<T> extends ApiResult<T> {
        public final T data;
        public Success(T data) {
            this.data = data;
        }
    }

    public static final class Error<T> extends ApiResult<T> {
        public final int statusCode;
        public final String errorMessage;
        public final T errorBody;

        public Error(int statusCode, String errorMessage, T errorBody) {
            this.statusCode = statusCode;
            this.errorMessage = errorMessage;
            this.errorBody = errorBody;
        }
    }
}