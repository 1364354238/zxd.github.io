package com.example.springboot.springboottest.controller;

import com.example.springboot.springboottest.dao.DepartmentDao;
import com.example.springboot.springboottest.dao.EmployeeDao;
import com.example.springboot.springboottest.pojo.Department;
import com.example.springboot.springboottest.pojo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @author dzx
 * @data 2021/11/16 -10:48
 */
@Controller
public class EmployeeController {
    @Resource
    EmployeeDao employeeDao;
    @Resource
    DepartmentDao departmentDao;
    @RequestMapping("/emp/list")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getEmployee();
        model.addAttribute("emps", employees);
        return "emp/list";
    }
    @GetMapping("/emp/add")
    public String addPage(Model model){
        model.addAttribute("departments", departmentDao.getDepartment());
        return "emp/add";
    }
    @RequestMapping("/emp/addEmployee")
    public String addEmployee(Employee employee){
        System.out.println(employee);
        employeeDao.add(employee);
        return "redirect:/emp/list";
    }
    @RequestMapping("/emp/toUpdate/{id}")
    public String toUpdate( @PathVariable("id")Integer id, Model model){
        Employee employee = employeeDao.getEmployeeById(id);
        System.out.println(employee);
        model.addAttribute("employee", employee);
        Collection<Department> departments = departmentDao.getDepartment();
        model.addAttribute("departments",departments);
        return "emp/update";
    }
    @RequestMapping("/emp/updateUser")
    public String updateUser(Employee employee){
        System.out.println(employee);
        employeeDao.add(employee);
        return "redirect:/emp/list";
    }
    @RequestMapping("/delemp/{id}")
    public String deleteUser( @PathVariable("id")Integer id, Model model){
        employeeDao.delete(id);
        return "redirect:/emp/list";
    }

}
