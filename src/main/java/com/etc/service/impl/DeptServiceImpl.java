package com.etc.service.impl;

import com.etc.dao.DeptDao;
import com.etc.dao.DeptDaoImpl;
import com.etc.domain.Dept;
import com.etc.service.DeptService;

import java.sql.SQLException;
import java.util.List;

public class DeptServiceImpl implements DeptService {

    @Override
    public List<Dept> list() {
        DeptDao deptDao = new DeptDaoImpl();
        List<Dept> deptList =null;
        try {
            deptList =  deptDao.list();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deptList;
    }

    @Override
    public void add(Dept dept) {
        DeptDao deptDao = new DeptDaoImpl();
        try {
            deptDao.add(dept);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Dept dept) {
        DeptDao deptDao = new DeptDaoImpl();
        try {
            deptDao.update(dept);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int deptNo) {
        DeptDao deptDao = new DeptDaoImpl();
        try {
            deptDao.delete(deptNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Dept findDeptByNO(int deptNo) {
        DeptDao deptDao = new DeptDaoImpl();
        Dept dept = null;
        try {
            dept = deptDao.findDeptByNO(deptNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dept;
    }
}
