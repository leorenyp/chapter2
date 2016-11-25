package org.smart4j.chapter2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter2.hleper.DatabaseHelper;
import org.smart4j.chapter2.model.Customer;

import java.util.List;
import java.util.Map;

/**
 * Created by renyp on 2016/11/21.
 */
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

//    private static final String DRIVER;
//    private static final String URL;
//    private static final String USERNAME;
//    private static final String PASSWORD;
//    static {
//        Properties conf = PropsUtil.loadProps("config.properties");
//        DRIVER = conf.getProperty("jdbc.driver");
//        URL = conf.getProperty("jdbc.url");
//        USERNAME = conf.getProperty("jdbc.username");
//        PASSWORD = conf.getProperty("jdbc.password");
//        try {
//            Class.forName(DRIVER);
//        } catch (ClassNotFoundException e) {
//            LOGGER.error("can not load jdbc driver",e);
//        }
//    }
    /**
     * 获取客户列表
     * @param
     * @return
     */
    public List<Customer> getCustomerList(){
       /* Connection conn = null;
        List<Customer> customerList = new ArrayList<Customer>();
        try {
            String sql = "select * from customer";
            conn = DatabaseHelper.getConnection();//DriverManager.getConnection(URL,USERNAME,PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customer.setContact(rs.getString("contact"));
                customer.setEmail(rs.getString("email"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setRemark(rs.getString("remark"));
                customerList.add(customer);
            }
        } catch (SQLException e) {
            LOGGER.error("execute sql failure",e);
        }finally {
           *//* try {
                conn.close();
            }catch (SQLException e){
                LOGGER.error("close connection failure",e);
            }*//*
           DatabaseHelper.closeConnection(conn);

        }
        return customerList;*/

        /*List<Customer> customerList = new ArrayList<Customer>();
        Connection conn = DatabaseHelper.getConnection();
        try {
            String sql = "select * from customer";
            customerList = DatabaseHelper.queryEntityList(Customer.class,sql,conn,null);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DatabaseHelper.closeConnection(conn);
        }
        return customerList;*/
        String sql = "select * from customer";
        return DatabaseHelper.queryEntityList(Customer.class,sql);
    }

    /**
     * 获取客户
     * @param id
     * @return
     */
    public Customer getCustomer(long id){
        String sql = "select * from customer where id =?";
        return DatabaseHelper.queryEntity(Customer.class,sql,id);
    }

    /**
     * 创建客户
     * @param fieldMap
     * @return
     */
    public boolean createCustomer(Map<String,Object> fieldMap){
        return DatabaseHelper.insertEntity(Customer.class,fieldMap);
    }

    /**
     * 修改客户
     * @param fieldMap
     * @return
     */
    public boolean updateCustomer(long id,Map<String,Object> fieldMap){
      return DatabaseHelper.updateEntity(Customer.class,id,fieldMap);
    }

    /**
     * 删除客户
     * @param id
     * @return
     */
    public boolean deleteCustomer(long id){
        return DatabaseHelper.deleteEntity(Customer.class,id);
    }
}
