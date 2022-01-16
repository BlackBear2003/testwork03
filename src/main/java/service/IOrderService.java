package service;

import bean.Orders;

import java.time.LocalDateTime;
import java.util.Set;

public interface IOrderService {
    public int add(Orders odr);
    public int delete(int id);
    public int update(int id, int good_ID, int num, LocalDateTime ldt);
    public Orders find(int id);
    public Set<Orders> findAllOrders();
}
