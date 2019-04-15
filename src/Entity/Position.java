package Entity;

import java.util.Objects;

public class Position {
    public Position(long deliveryID, String school, String position) {
        this.deliveryID = deliveryID;
        this.school = school;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", deliveryID=" + deliveryID +
                ", school='" + school + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public Position() {
    }

    private long id, deliveryID;
    String school, position;

    public Position(long id, long deliveryID, String school, String position) {
        this.id = id;
        this.deliveryID = deliveryID;
        this.school = school;
        this.position = position;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(long deliveryID) {
        this.deliveryID = deliveryID;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position1 = (Position) o;
        return getId() == position1.getId() &&
                getDeliveryID() == position1.getDeliveryID() &&
                Objects.equals(getSchool(), position1.getSchool()) &&
                Objects.equals(getPosition(), position1.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDeliveryID(), getSchool(), getPosition());
    }
}
