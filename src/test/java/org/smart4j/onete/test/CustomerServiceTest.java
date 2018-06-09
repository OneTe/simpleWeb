package org.smart4j.onete.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.smart4j.onete.helper.DatabaseHelper;
import org.smart4j.onete.model.Customer;
import org.smart4j.onete.service.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangcheng  on 2018/6/7.
 */
/*
    CustomerService 单元测试
 */
public class CustomerServiceTest {
    private final CustomerService customerService;

    public CustomerServiceTest(){
        customerService = new CustomerService();
    }
    @Before
    public void init(){
        //初始化数据库，使用测试的数据库
        DatabaseHelper.executeSqlFile("sql/customer_init.sql");
    }
    @Test
    public void getCustomerListTest() throws Exception{
        List<Customer> customerList = customerService.getCustomerList();
        Assert.assertEquals(2,customerList.size());
    }
    @Test
    public void getCustomerTest() throws Exception{
        long id = 1;
        Customer customer = customerService.getCustomer(id);
        Assert.assertNotNull(customer);
    }
    @Test
    public void createCustomerTest() throws Exception{
        Map<String,Object> fieldMap = new HashMap<>();
        fieldMap.put("name","customer100");
        fieldMap.put("contact","John");
        fieldMap.put("telephone","13708229609");
        boolean result = customerService.createCustomer(fieldMap);
        Assert.assertTrue(result);
    }
    @Test
    public void updateCustomerTest() throws Exception{
        long id = 1;
        Map<String,Object> fieldMap = new HashMap<>();
        fieldMap.put("contact","Eric");
        boolean result = customerService.updateCustomer(id,fieldMap);
        Assert.assertTrue(result);
    }
    @Test
    public void deleteCustomerTest() throws Exception{
        long id = 1;
        boolean result = customerService.deleteCustomer(id);
        Assert.assertTrue(result);
    }
}

