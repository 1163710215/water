package Entity;

import java.sql.Date;
import java.util.Objects;

public class Order {
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerID=" + customerID +
                ", orderType='" + orderType + '\'' +
                ", isPay='" + isPay + '\'' +
                ", onDelivery='" + onDelivery + '\'' +
                ", orderTime=" + orderTime +
                '}';
    }

    public Order(long customerID, String orderType, String isPay, String onDelivery, Date orderTime) {
        this.customerID = customerID;
        this.orderType = orderType;
        this.isPay = isPay;
        this.onDelivery = onDelivery;
        this.orderTime = orderTime;
    }

    public Order() {
    }

    long id,customerID;
    String orderType,isPay,onDelivery;
    Date orderTime;

    public Order(long id, long customerID, String orderType, String isPay, String onDelivery, Date orderTime) {
        this.id = id;
        this.customerID = customerID;
        this.orderType = orderType;
        this.isPay = isPay;
        this.onDelivery = onDelivery;
        this.orderTime = orderTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getIsPay() {
        return isPay;
    }

    public void setIsPay(String isPay) {
        this.isPay = isPay;
    }

    public String getOnDelivery() {
        return onDelivery;
    }

    public void setOnDelivery(String onDelivery) {
        this.onDelivery = onDelivery;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getId() == order.getId() &&
                getCustomerID() == order.getCustomerID() &&
                Objects.equals(getOrderType(), order.getOrderType()) &&
                Objects.equals(getIsPay(), order.getIsPay()) &&
                Objects.equals(getOnDelivery(), order.getOnDelivery()) &&
                Objects.equals(getOrderTime(), order.getOrderTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCustomerID(), getOrderType(), getIsPay(), getOnDelivery(), getOrderTime());
    }
}
