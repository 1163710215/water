package Entity;

import java.util.Objects;

public class Delivery {
    public Delivery(String name, String phone, String sex) {
        this.name = name;
        this.phone = phone;
        this.sex = sex;
    }

    public Delivery() {
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    private long id;
    private String name,phone,sex;

    public Delivery(long id, String name, String phone, String sex) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.sex = sex;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Delivery)) return false;
        Delivery delivery = (Delivery) o;
        return getId() == delivery.getId() &&
                Objects.equals(getName(), delivery.getName()) &&
                Objects.equals(getPhone(), delivery.getPhone()) &&
                Objects.equals(getSex(), delivery.getSex());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPhone(), getSex());
    }
}
