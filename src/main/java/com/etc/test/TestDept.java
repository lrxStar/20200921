package com.etc.test;

import com.etc.dao.DeptDao;
import com.etc.dao.DeptDaoImpl;
import com.etc.domain.Dept;
import com.etc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestDept {
    public static void main(String[] args) throws SQLException {
        DeptDao deptDao = new DeptDaoImpl();
//        JDBCUtils jdbcUtils = new JDBCUtils() ;
//        Connection connection = jdbcUtils.getConnection();
//        System.out.println(connection);
//        List<Dept> deptList = deptDao.list();
//        for (Dept dept : deptList) {
//            System.out.println(dept);
//        }

        Dept dept = new Dept(50,"aaaaaaaaa","sss");
//        deptDao.update(dept);
        deptDao.delete(50);
        Dept dept1 = deptDao.findDeptByNO(40);
        System.out.println(dept1);
    }

}
