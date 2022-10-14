package com.lxl.dao;

import com.lxl.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    //模拟数据库数据
    private static Map<Integer, Department> departments=null;
    static {
        departments=new HashMap<Integer, Department>();
        departments.put(1001,new Department(1001,"销售部"));
        departments.put(1002,new Department(1002,"运营部"));
        departments.put(1003,new Department(1003,"教研部"));
        departments.put(1004,new Department(1004,"后勤部"));
    }

    //获取所有部门信息
    public Collection<Department> getDepartments(){
        return departments.values();
    }

    //通过id获取部门信息
    public Department getDepartmentById(Integer id){
        Department department = departments.get(id);
        return departments.get(id);
    }
}
