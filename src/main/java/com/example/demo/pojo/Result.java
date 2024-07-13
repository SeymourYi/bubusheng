package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private int code;
    private String msg;
    private T data;
public static <T> Result<T> success(T data) {
    return new Result<>(0, "操作成功", data);
}
public static <T> Result<T> success() {
    return success(null);
}
public static <T> Result<T> fail(String msg) {
    return new Result<>(1, msg, null);
}
}
