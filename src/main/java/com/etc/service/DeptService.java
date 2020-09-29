package com.etc.service;

import com.etc.domain.Dept;

import java.sql.SQLException;
import java.util.List;

public interface DeptService {

    List<Dept> list();

    void add(Dept dept);
    void update(Dept dept);
    void delete(int deptNo);
    Dept findDeptByNO(int deptNo);
    
}
