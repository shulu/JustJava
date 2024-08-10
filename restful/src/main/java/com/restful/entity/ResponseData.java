package com.restful.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class  ResponseData<T> {
    private String code;
    private String errorMsg;
    private Boolean result;
    private T data;
}
