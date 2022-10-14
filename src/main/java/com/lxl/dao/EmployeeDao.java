package com.lxl.dao;

import com.lxl.pojo.Department;
import com.lxl.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees;
    @Autowired
    private DepartmentDao dd;

    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(01, new Employee(001, "name1", "1713098889@qq.com", 0, new Department(001, "销售部")));
        employees.put(02, new Employee(002, "name2", "2713098889@qq.com", 1, new Department(002, "运营部")));
        employees.put(03, new Employee(003, "name3", "3713098889@qq.com", 1, new Department(003, "教研部")));
        employees.put(04, new Employee(004, "name4", "4713098889@qq.com", 0, new Department(004, "后勤部")));
    }

    //主键自增
    private static Integer initId = 005;

    //添加员工
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(dd.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    //查询全部员工信息
    public Collection<Employee> getEmployees() {
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //通过id删除员工
    public void delEmployeeById(Integer id){
        employees.remove(id);
    }
}
