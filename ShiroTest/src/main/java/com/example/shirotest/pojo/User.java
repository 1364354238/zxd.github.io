package com.example.shirotest.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dzx
 * @data 2021/11/22 -15:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private Integer id;
    private String psw;
    private String perms;
}
