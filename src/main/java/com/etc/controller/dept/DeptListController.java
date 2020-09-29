package com.etc.controller.dept;

import com.etc.domain.Dept;
import com.etc.service.DeptService;
import com.etc.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeptListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        DeptService deptService = new DeptServiceImpl();
        List<Dept> deptList = deptService.list();

        req.setAttribute("deptList",deptList);
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }
}
