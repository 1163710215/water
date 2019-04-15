package Entity;

import java.util.Objects;

public class Water {
    @Override
    public String toString() {
        return "Water{" +
                "cost=" + cost +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Water)) return false;
        Water water = (Water) o;
        return getCost() == water.getCost() &&
                Objects.equals(getType(), water.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCost(), getType());
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Water(long cost, String type) {
        this.cost = cost;
        this.type = type;
    }

    public Water() {
    }

    long cost;
    String type;
}
