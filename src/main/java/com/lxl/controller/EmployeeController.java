package com.lxl.controller;

import com.lxl.dao.DepartmentDao;
import com.lxl.dao.EmployeeDao;
import com.lxl.pojo.Department;
import com.lxl.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;
import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao ed;
    @Autowired
    DepartmentDao dd;

    @RequestMapping("/emp")
    public String list(Model model) {
        Collection<Employee> employees = ed.getEmployees();
        model.addAttribute("emps", employees);
//        System.out.println("``````````"+employees);
        return "emp/list";
    }

    //查询所有部门信息
    @GetMapping("/add")
    public String add(Model model) {
        Collection<Department> departments = dd.getDepartments();
        model.addAttribute("deps", departments);
        return "emp/add";
    }

    @PostMapping("/add")
    public String addRe(Employee employee) {
        ed.save(employee);
        return "redirect:/emp";
    }

    @GetMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model) {
        Employee employee = ed.getEmployeeById(id);
//        System.out.println(id+"~~~~~~~: "+employee);
        model.addAttribute("emp",employee);
        Collection<Department> departments = dd.getDepartments();
        model.addAttribute("deps",departments);
        return "emp/update";
    }

    //修改员工信息
    @RequestMapping("/update")
    public String update(Employee employee){
        ed.save(employee);
//        System.out.println("employee:   "+employee);
        return "redirect:/emp";
    }

    //删除员工信息
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        System.out.println("id:  "+id);
        ed.delEmployeeById(id);
        return "redirect:/emp";
    }
}
