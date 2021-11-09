package com.example.dao;

import com.example.pojo.Student1;
import com.example.pojo.Teacher;

import java.util.List;

/**
 * @author dzx
 * @data 2021/11/4 -15:59
 */
public interface StudentMapper {
    List<Student1> selectAll();
    List<Student1> selectSAndT();
    Teacher getTeacher();
}
