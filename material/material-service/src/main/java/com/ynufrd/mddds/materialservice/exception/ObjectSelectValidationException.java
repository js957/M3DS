package com.ynufrd.mddds.materialservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by wjs on 2022/12/03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjectSelectValidationException extends RuntimeException{
    private String entityName;
    private String message;
}
