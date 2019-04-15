package Entity;

import java.sql.Date;
import java.util.Objects;

public class Customer {
    public Customer(long totalTime, long cost, long locationNum, String name, String phone, String sex, String criticalLocation, Date date) {
        this.totalTime = totalTime;
        this.cost = cost;
        this.locationNum = locationNum;
        this.name = name;
        this.phone = phone;
        this.sex = sex;
        this.criticalLocation = criticalLocation;
        this.date = date;
    }

    public Customer() {
    }

    private long id, totalTime, cost, locationNum;
    private String name, phone, sex, criticalLocation;
    private Date date;

    public Customer(long id, long totalTime, long cost, long locationNum, String name, String phone, String sex, String criticalLocation, Date date) {
        this.id = id;
        this.totalTime = totalTime;
        this.cost = cost;
        this.locationNum = locationNum;
        this.name = name;
        this.phone = phone;
        this.sex = sex;
        this.criticalLocation = criticalLocation;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public long getLocationNum() {
        return locationNum;
    }

    public void setLocationNum(long locationNum) {
        this.locationNum = locationNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCriticalLocation() {
        return criticalLocation;
    }

    public void setCriticalLocation(String criticalLocation) {
        this.criticalLocation = criticalLocation;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getId() == customer.getId() &&
                getTotalTime() == customer.getTotalTime() &&
                getCost() == customer.getCost() &&
                getLocationNum() == customer.getLocationNum() &&
                Objects.equals(getName(), customer.getName()) &&
                Objects.equals(getPhone(), customer.getPhone()) &&
                Objects.equals(getSex(), customer.getSex()) &&
                Objects.equals(getCriticalLocation(), customer.getCriticalLocation()) &&
                Objects.equals(getDate(), customer.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTotalTime(), getCost(), getLocationNum(), getName(), getPhone(), getSex(), getCriticalLocation(), getDate());
    }

    @Override
    public String
    toString() {
        return "Customer{" +
                "id=" + id +
                ", totalTime=" + totalTime +
                ", cost=" + cost +
                ", locationNum=" + locationNum +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", criticalLocation='" + criticalLocation + '\'' +
                ", date=" + date +
                '}';
    }
}
