package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author dzx
 * @data 2021/11/4 -15:58
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Teacher {
    private int id;
    private String name;
    private List<Student1> student1s;
}
