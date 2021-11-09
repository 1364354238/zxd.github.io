package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dzx
 * @data 2021/11/4 -15:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student1 {
    private int id;
    private String name;
    private Teacher teacher;
}
