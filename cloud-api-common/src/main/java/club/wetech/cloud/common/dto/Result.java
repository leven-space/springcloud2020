package club.wetech.cloud.common.dto;

/**
 * @author leven.chen
 */
public class Result<T> {

    private T data;

    private String code;

    private String msg;

    private boolean success;

    public Result() {
    }



    public Result(T data, String code, String msg, boolean success) {
        this.data = data;
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
