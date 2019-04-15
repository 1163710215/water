package Main;

import Entity.*;
import Utils.BuildConnection;
import Utils.Services;

import java.sql.Connection;
import java.util.Date;

public class Main {
    public static void main(String[] args){
        new Main();
    }
    public Main() {
        Connection connection = BuildConnection.BuildConnect();
        if(connection==null){
            return;
        }
        MainLogic(connection);

    }

    /**
     * public Delivery(String name, String phone, String sex)
     *
     *  public Customer(long totalTime, long cost, long locationNum, String name, String phone, String sex, String criticalLocation, Date date)
     *
     *  public Order(long customerID, String orderType, String isPay, String onDelivery, Date orderTime)
     *
     *  public Position(long deliveryID, String school, String position)
     *
     *    public Water(long cost, String type)
     *
     *
     * @param connection
     */
    private void MainLogic(Connection connection) {
//        Delivery d1 = new Delivery("dufu","10086","M");
//        Services.addDelivery(connection,d1);

        Date date =new Date();


//        Position p1 = new Position(2,"hit","A3");
//        Services.addPosition(connection,p1);
//
//        Customer c1 =new Customer(1,2,1,"chihuo","444444","M","tong",new java.sql.Date(date.getTime()));
//        Services.addCustomer(connection,c1);

//
//        Water w1 =new Water(5,"middle");
//        Services.addWater(connection,w1);

//        Order order=new Order(4,"middle","y","N",new java.sql.Date(date.getTime()));
//        Services.addOrder(connection,order);

//        Services.finishOrder(connection,order);


        // show values
        Services.showDelivery(connection);
        Services.showOrders(connection);
        Services.showCustomers(connection);
        Services.showPositions(connection);
        Services.showWaters(connection);


    }


}
