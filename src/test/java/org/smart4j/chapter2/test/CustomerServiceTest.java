package org.smart4j.chapter2.test;

import org.smart4j.chapter2.service.CustomerService;


/**
 * customerService 单元测试
 * Created by renyp on 2016/11/21.
 */
public class CustomerServiceTest {
    private final CustomerService customerService ;

    public CustomerServiceTest(CustomerService customerService) {
        this.customerService = customerService;
    }
    @Before
    public void init(){
        //// TODO: 2016/11/21
    }
}
