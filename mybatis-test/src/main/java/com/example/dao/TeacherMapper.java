package com.example.dao;

import com.example.pojo.Student1;
import com.example.pojo.Teacher;

import java.util.List;

/**
 * @author dzx
 * @data 2021/11/4 -15:59
 */
public interface TeacherMapper {
    List<Teacher> selectAll();

    List<Teacher> getStudents();

    List<Student1> getStudentsById();
}
