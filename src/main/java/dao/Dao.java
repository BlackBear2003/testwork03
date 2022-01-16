package dao;

import bean.Orders;
import utils.JBDCUtils;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import static utils.JBDCUtils.getConnection;

public class Dao implements IDao {


    private JBDCUtils JDBCUtils;

    /*
     *通过输入订单id及对应商品信息及时间，来实现更新对应id的订单信息。
     */
    @Override
    public int updateOrder(int id, int good_ID, int number, LocalDateTime ldt) {
        Connection con = null;
        PreparedStatement ps = null;
        int i = 0;
        try {
            con = getConnection();
            String sql = "update orders set good_ID=? ,number=? ,TIME=?  where id =?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, good_ID);
            ps.setInt(2, number);
            ps.setString(3, String.valueOf(ldt));
            ps.setInt(4, id);

            i = ps.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            JDBCUtils.free(null, ps, con);
        }

        return i;
    }

    /*
     *通过输入订单id，来实现删除对应id的订单信息。
     */
    @Override
    public int deleteOrder(int id) {

        Connection con = null;
        PreparedStatement ps = null;
        int i = 0;
        try {
            con = getConnection();
            String sql = "delete from orders where id =?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            i = ps.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            JDBCUtils.free(null, ps, con);
        }

        return i;
    }

    /*
     *通过输入实际订单，来实现增加订单信息。
     */
    @Override
    public int addOrder(Orders order) {
        Connection con = null ;
        PreparedStatement ps = null ;
        int i = 0 ;
        try
        {
            con = getConnection();
            String sql = "insert into orders(good_ID,number,time) values(?,?,?)";
            ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1,order.getGood_ID());
            ps.setInt(2,order.getNumber() );
            ps.setString(3, String.valueOf(order.getDateTime()));

            i = ps.executeUpdate() ;

        }
        catch(SQLException e)
        {
            throw new DAOException(e.getMessage(),e);
        }
        finally
        {
            JDBCUtils.free(null, ps, con);
        }
        return i;
    }

    @Override
    public Orders findOrder(int id) {
        Connection con = null ;
        PreparedStatement ps = null ;
        Orders odr = null;
        ResultSet rs = null;
        try
        {
            con = getConnection();
            String sql = "select id ,good_ID,number,time from orders where id =?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery() ;
            odr = new Orders();
            while(rs.next())
            {
                odr.setId(rs.getInt(1));
                odr.setGood_ID(rs.getInt(2));
                odr.setNumber(rs.getInt(3));

                //非常好用的找类型方法
                //System.out.println("string:"+rs.getString(4));
                //System.out.println("date:"+rs.getDate(4));
                //System.out.println("obejct:"+rs.getObject(4).getClass().getSimpleName());

                LocalDateTime  dt=((Timestamp)rs.getObject(4)).toLocalDateTime();
                odr.setDateTime(dt);
            }

        }
        catch(SQLException e)
        {
            throw new DAOException(e.getMessage(),e);
        }
        finally
        {
            JDBCUtils.free(rs, ps, con);
        }

        return odr;
    }

    @Override
    public Set<Orders> findAllOrders() {
        Connection con = null ;
        PreparedStatement ps = null ;
        Orders odr = null ;
        ResultSet rs = null;
        Set<Orders> set = null ;
        try
        {
            con = getConnection();
            String sql = "select id,good_ID,number,time from orders";
            ps = con.prepareStatement(sql);

            set = new HashSet<Orders>() ;
            rs = ps.executeQuery() ;

            while(rs.next())
            {
                odr = new Orders();
                odr.setId(rs.getInt(1));
                odr.setGood_ID(rs.getInt(2));
                odr.setNumber(rs.getInt(3));
                LocalDateTime  dt=((Timestamp)rs.getObject(4)).toLocalDateTime();
                odr.setDateTime(dt);

                set.add(odr);
            }

        }
        catch(SQLException e)
        {
            throw new DAOException(e.getMessage(),e);
        }
        finally
        {
            JDBCUtils.free(rs, ps, con);
        }

        return set;
    }
}
