package com.etc.dao;

import com.etc.domain.Dept;

import java.sql.SQLException;
import java.util.List;

public interface DeptDao {
    List<Dept> list() throws SQLException;

    void add(Dept dept) throws SQLException;
    void update(Dept dept) throws SQLException;
    void delete(int deptNo) throws SQLException;
    Dept findDeptByNO(int deptNo) throws SQLException;
}
