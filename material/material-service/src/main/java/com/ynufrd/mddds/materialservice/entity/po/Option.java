package com.ynufrd.mddds.materialservice.entity.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by wjs on 2022/08/21
 */
@Data
@NoArgsConstructor
public class Option implements Serializable {

    private String option;

    private String score;
}
