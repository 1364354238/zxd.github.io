package com.example.springboot.springboottest.dao;

import com.example.springboot.springboottest.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dzx
 * @data 2021/11/15 -18:31
 */
@Repository
public class DepartmentDao {
    //模拟数据库中的数据
    private static Map<Integer, Department> departmentMap = null;
    static {
        departmentMap = new HashMap<>();
        departmentMap.put(0,new Department(0,"教学部"));
        departmentMap.put(1,new Department(1,"市场部"));
        departmentMap.put(2,new Department(2,"教研部"));
        departmentMap.put(3,new Department(3,"运营部"));
        departmentMap.put(4,new Department(4,"后勤部"));
    }
    public Collection<Department>getDepartment(){
        return departmentMap.values();
    }
    public Department getDepartmentById(Integer id){
        return departmentMap.get(id);
    }
}
