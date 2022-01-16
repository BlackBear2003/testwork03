package service;

import bean.Orders;
import dao.Dao;

import java.time.LocalDateTime;
import java.util.Set;

public class OrderService implements IOrderService{

    Dao dao = new Dao();

    @Override
    public int add(Orders odr) {

        return this.dao.addOrder(odr);
    }

    @Override
    public int delete(int id) {
        return this.dao.deleteOrder(id);
    }

    @Override
    public int update(int id, int good_ID, int num, LocalDateTime ldt) {
        return this.dao.updateOrder(id,good_ID,num,ldt);
    }

    @Override
    public Orders find(int id) {
        return dao.findOrder(id);
    }

    @Override
    public Set<Orders> findAllOrders() {
        return dao.findAllOrders();
    }
}
