package Utils;

import Entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Services {
    public static void showOrders(Connection connection) {
        String sql = "select * from myorder";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("orders:");
            while (resultSet.next()) {
                Order c = new Order();
                c.setId(resultSet.getLong("id"));
                c.setCustomerID(resultSet.getLong("customerId"));
                c.setOrderType(resultSet.getString("orderType"));
                c.setOrderTime(resultSet.getDate("orderTime"));
                c.setIsPay(resultSet.getString("isPay"));
                c.setOnDelivery(resultSet.getString("onDelivery"));
                System.out.println(c.toString());

            }

        } catch (SQLException e) {
            System.out.println("show orders has trouble");
            e.printStackTrace();
        }


    }

    public static void showCustomers(Connection connection) {
        String sql = "select * from customer natural join information";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("customers:");
            while (resultSet.next()) {
                Customer c = new Customer();
                c.setId(resultSet.getLong("id"));
                c.setDate(resultSet.getDate("startTime"));
                c.setName(resultSet.getString("name"));
                c.setPhone(resultSet.getString("phone"));
                c.setSex(resultSet.getString("sex"));
                c.setTotalTime(resultSet.getLong("totalTime"));
                c.setCriticalLocation(resultSet.getString("criticalLocation"));
                c.setLocationNum(resultSet.getLong("locationNum"));
                c.setCost(resultSet.getLong("cost"));
                System.out.println(c.toString());

            }

        } catch (SQLException e) {
            System.out.println("show customers has trouble");
            e.printStackTrace();
        }


    }

    public static void showDelivery(Connection connection) {
        String sql = "select * from delivery natural join information";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("deliveries:");
            while (resultSet.next()) {
                Delivery c = new Delivery();
                c.setId(resultSet.getLong("id"));

                c.setName(resultSet.getString("name"));
                c.setPhone(resultSet.getString("phone"));
                c.setSex(resultSet.getString("sex"));

                System.out.println(c.toString());

            }

        } catch (SQLException e) {
            System.out.println("show deliveries has trouble");
            e.printStackTrace();
        }

    }

    public static void addCustomer(Connection connection, Customer customer) {
        String sql1="insert into information(type,name,phone,sex) values (?,?,?,?)";
        String sql2="select id from information order by id desc";
        String sql3="insert into customer(id,startTime,totalTime,cost,locationNum,criticalLocation) values (?,?,?,?,?,?)";
        try {
            PreparedStatement p1 =connection.prepareStatement(sql1);
            PreparedStatement p2 =connection.prepareStatement(sql2);
            PreparedStatement p3 =connection.prepareStatement(sql3);
            p1.setString(1,"customer");
            p1.setString(2,customer.getName());
            p1.setString(3,customer.getPhone());
            p1.setString(4,customer.getSex());
            p1.executeUpdate();
            ResultSet resultSet =p2.executeQuery();
            if(resultSet.next()){
                long id = resultSet.getLong("id");
                p3.setLong(1,id);
                p3.setDate(2,customer.getDate());
                p3.setLong(3,customer.getTotalTime());
                p3.setLong(4,customer.getCost());
                p3.setLong(5,customer.getLocationNum());
                p3.setString(6,customer.getCriticalLocation());
                p3.executeUpdate();
                System.out.println("insert customer finish");

            }
            else {
                System.out.println("Insert customer failed");
                return;
            }


        } catch (SQLException e) {
            System.out.println("add customers has trouble");
            e.printStackTrace();
        }

    }

    public static void addDelivery(Connection connection, Delivery delivery) {
        String sql1="insert into information(type,name,phone,sex) values (?,?,?,?)";
        String sql2="select id from information order by id desc";
        String sql3="insert into delivery(id) values (?)";
        try {
            PreparedStatement p1 =connection.prepareStatement(sql1);
            PreparedStatement p2 =connection.prepareStatement(sql2);
            PreparedStatement p3 =connection.prepareStatement(sql3);
            p1.setString(1,"delivery");
            p1.setString(2,delivery.getName());
            p1.setString(3,delivery.getPhone());
            p1.setString(4,delivery.getSex());
            p1.executeUpdate();
            ResultSet resultSet =p2.executeQuery();
            if(resultSet.next()){
                long id = resultSet.getLong("id");
                p3.setLong(1,id);
                p3.executeUpdate();
                System.out.println("insert delivery finish");

            }
            else {
                System.out.println("Insert delivery failed");
                return;
            }

        } catch (SQLException e) {
            System.out.println("insert delivery has trouble");
            e.printStackTrace();
        }


    }

    public static void addOrder(Connection connection, Order order) {
        String sql1="insert into myorder(customerId,orderType,orderTime,isPay,onDelivery) values (?,?,?,?,?)";

        try {
            PreparedStatement p1 =connection.prepareStatement(sql1);
            p1.setLong(1,order.getCustomerID());
            p1.setString(2,order.getOrderType());
            p1.setDate(3,order.getOrderTime());
            p1.setString(4,order.getIsPay());
            p1.setString(5,"n");
            p1.executeUpdate();
            System.out.println("add order finish");

        } catch (SQLException e) {
            System.out.println("add order has trouble");
            e.printStackTrace();
        }

    }

    public static void finishOrder(Connection connection, Order order) {
        String sql1="update myorder set onDelivery='y',isPay='y' where customerId=?";

        try {
            PreparedStatement p1 =connection.prepareStatement(sql1);
            p1.setLong(1,order.getCustomerID());
            p1.executeUpdate();
            System.out.println("order finish");

        } catch (SQLException e) {
            System.out.println("finish order has trouble");
            e.printStackTrace();
        }

    }

    public static void addPosition(Connection connection, Position position) {
        String sql1="insert into location(school,position,deliveryId) values (?,?,?)";

        try {
            PreparedStatement p1 =connection.prepareStatement(sql1);
            p1.setString(1,position.getSchool());
            p1.setString(2,position.getPosition());
            p1.setLong(3,position.getDeliveryID());
            p1.executeUpdate();
            System.out.println("add position finish");

        } catch (SQLException e) {
            System.out.println("add position has trouble");
            e.printStackTrace();
        }

    }

    public static void showPositions(Connection connection) {
        String sql="select * from location";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("positions:");
            while(resultSet.next()){
                Position c=new Position();
                c.setId(resultSet.getLong("locationNum"));
                c.setSchool(resultSet.getString("school"));
                c.setPosition(resultSet.getString("position"));
                c.setDeliveryID(resultSet.getLong("deliveryId"));
                System.out.println(c.toString());

            }

        } catch (SQLException e) {
            System.out.println("show customers has trouble");
            e.printStackTrace();
        }

    }

    public static void addWater(Connection connection, Water water) {
        String sql1="insert into water(type,cost) values (?,?)";

        try {
            PreparedStatement p1 =connection.prepareStatement(sql1);
            p1.setString(1,water.getType());
            p1.setLong(2,water.getCost());
            p1.executeUpdate();
            System.out.println("add water finish");

        } catch (SQLException e) {
            System.out.println("add water has trouble");
            e.printStackTrace();
        }

    }

    public static void showWaters(Connection connection) {
        String sql="select * from water";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("waters:");
            while(resultSet.next()){
                Water c=new Water();
                c.setCost(resultSet.getLong("cost"));
                c.setType(resultSet.getString("type"));
                System.out.println(c.toString());

            }

        } catch (SQLException e) {
            System.out.println("show customers has trouble");
            e.printStackTrace();
        }

    }
}
