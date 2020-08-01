package club.wetech.cloud.common.util;

import club.wetech.cloud.common.dto.Result;

/**
 * @author leven.chen
 */
public class ResultBuilder {

    private static final String SUCCESS_CODE = "succ";


    public static <R> Result<R> success() {
        return new Result<>(null, SUCCESS_CODE, null, true);
    }

    public static <R> Result<R> success(String msg) {
        return new Result<>(null, SUCCESS_CODE, msg, true);
    }

    public static <R> Result<R> success(R data) {
        return new Result<>(data, SUCCESS_CODE, null, true);
    }

    public static <R> Result<R> success(R data, String code, String msg, boolean success) {
        return new Result<>(data, code, msg, success);
    }
}
