package com.etc.dao;

import com.etc.domain.Dept;
import com.etc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {
    @Override
    public List<Dept> list() throws SQLException {
        JDBCUtils jdbcUtils = new JDBCUtils() ;
        Connection connection = jdbcUtils.getConnection();
        String sql = "select * from dept";
        PreparedStatement ps=connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Dept> deptList = new ArrayList<>();
        while (rs.next()){
            Dept dept = new Dept();
            dept.setDeptno(rs.getInt("deptno"));
            dept.setDname(rs.getString("dname"));
            dept.setLoc(rs.getString("loc"));
            deptList.add(dept);
        }
        jdbcUtils.release(rs,ps,connection);
        return deptList;
    }

    @Override
    public void add(Dept dept) throws SQLException {
        JDBCUtils jdbcUtils = new JDBCUtils() ;
        Connection connection = jdbcUtils.getConnection();
        String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,dept.getDeptno());
        ps.setString(2,dept.getDname());
        ps.setString(3,dept.getLoc());

        ps.executeUpdate();
        jdbcUtils.release(ps,connection);
    }

    @Override
    public void update(Dept dept) throws SQLException {
        JDBCUtils jdbcUtils = new JDBCUtils() ;
        Connection connection = jdbcUtils.getConnection();
        String sql = "update dept set dname=?,loc=? where  deptno=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,dept.getDname());
        ps.setString(2,dept.getLoc());
        ps.setInt(3,dept.getDeptno());

        ps.executeUpdate();
        jdbcUtils.release(ps,connection);
    }

    @Override
    public void delete(int deptNo) throws SQLException {
        JDBCUtils jdbcUtils = new JDBCUtils() ;
        Connection connection = jdbcUtils.getConnection();
        String sql = "delete from dept where deptno=? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,deptNo);
        ps.executeUpdate();
        jdbcUtils.release(ps,connection);

    }

    @Override
    public Dept findDeptByNO(int deptNo) throws SQLException {
        JDBCUtils jdbcUtils = new JDBCUtils() ;
        Connection connection = jdbcUtils.getConnection();
        String sql = "select * from dept where deptno = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,deptNo);
        ResultSet rs = ps.executeQuery();
        Dept dept = null;
        if (rs.next()){
            dept = new Dept();
            dept.setDeptno(rs.getInt("deptno"));
            dept.setDname(rs.getString("dname"));
            dept.setLoc(rs.getString("loc"));

        }
        jdbcUtils.release(rs,ps,connection);
        return dept;
    }
}
