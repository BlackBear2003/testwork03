package test;

import bean.Orders;
import dao.Dao;
import service.OrderService;
import utils.JBDCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


public class test {
    public static void main(String[] args) {

        /*
        -----》本作业使用了DAO的概念
        -----》没有进行分页查询的制作
        -----》实现了订单项目的增删查改功能，因为拔了智齿人晕了几天，就没有去完善商品信息的增删查改了T-T
        -----》
         */

        //创建服务层
        OrderService os = new OrderService();

        /*
        创建一个订单对象odr1，再通过服务层的增加订单功能在数据库中进行订单的增加
         */
        Orders odr1 = new Orders(1,3, LocalDateTime.now());
        int n=os.add(odr1);
        os.add(odr1);
        System.out.println(n);


        /*
        输入对应订单的id进行订单的删除
         */
        //os.delete(7);

        /*
        使用订单的更新功能进行数据更新，标签（订单id，对应货物id，购买数量，时间）
         */
        int u=os.update(1,3,2,LocalDateTime.now());
        System.out.println(u);

        /*
        使用查询功能将查到的订单放入新建的对象odr2中
         */
        Orders odr2 = os.find(1);
        System.out.println(odr2);

        /*
         *查询全表并打印
         */
        for (Orders odr:
             os.findAllOrders()) {
            System.out.println(odr);
        }

    }
}
