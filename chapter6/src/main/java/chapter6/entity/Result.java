package chapter6.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Result<T> {

    private String code;

    private String msg;

    private T data;

    public Result(T data) {
        this.data = data;
    }

    public static Result success() {
        Result result = new Result<>();
        result.setCode("0");
        result.setMsg("success");
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<T>(data);
        result.setCode("0");
        result.setMsg("success");
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result<>();
        result.setCode("-1");
        result.setMsg("error");
        return result;
    }
}
