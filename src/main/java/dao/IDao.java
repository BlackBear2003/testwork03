package dao;

import bean.Orders;

import java.time.LocalDateTime;
import java.util.Set;

public interface IDao {
    public int updateOrder(int id, int good_ID, int number, LocalDateTime ldt);
    public int deleteOrder(int id);
    public int addOrder(Orders order);
    public Orders findOrder(int id);
    public Set<Orders> findAllOrders();

}
