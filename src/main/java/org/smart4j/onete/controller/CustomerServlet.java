package org.smart4j.onete.controller;

import org.smart4j.onete.model.Customer;
import org.smart4j.onete.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by wangcheng  on 2018/6/9.
 */
/*
   进入客户列表界面
 */
@WebServlet("/customer")
public class CustomerServlet extends HttpServlet{

    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customerList = customerService.getCustomerList();
        req.setAttribute("customerList",customerList);
        req.getRequestDispatcher("/WEB-INF/jsps/customer.jsp").forward(req,resp);
    }


}
