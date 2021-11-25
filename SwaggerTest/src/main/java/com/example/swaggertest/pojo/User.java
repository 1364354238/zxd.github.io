package com.example.swaggertest.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dzx
 * @data 2021/11/23 -20:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("实体类注释")
public class User {
    @ApiModelProperty("实体类字段")
    private String name;
    private String password;
    private Integer id;
}
