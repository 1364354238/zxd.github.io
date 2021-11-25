package com.example.springboot.springboottest.dao;

import com.example.springboot.springboottest.pojo.Department;
import com.example.springboot.springboottest.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dzx
 * @data 2021/11/15 -18:35
 */
@Repository
public class EmployeeDao {
    //    模拟数据库中的数据
    private static Map<Integer, Employee> employeeMap = null;
    @Resource
    private DepartmentDao departmentDao;
    static {
        employeeMap = new HashMap<>();
        employeeMap.put(0, new Employee(0,"AA","123@qq.com",0,new Department(0,"教学部")));
        employeeMap.put(1, new Employee(1,"BB","124@qq.com",1,new Department(1,"市场部")));
        employeeMap.put(2, new Employee(2,"CC","125@qq.com",0,new Department(2,"教研部")));
        employeeMap.put(3, new Employee(3,"DD","127@qq.com",1,new Department(3,"运营部")));
        employeeMap.put(4, new Employee(4,"EE","128@qq.com",0,new Department(4,"后勤部")));
    }

    private static Integer initId = 5;
    public void add(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(), employee);
    }
    public Collection<Employee> getEmployee(){
        return employeeMap.values();
    }
    public Employee getEmployeeById(Integer id){
        return employeeMap.get(id);
    }
    public void delete(Integer id){
        employeeMap.remove(id);
    }
}
