package TaxiReservation;

public class Customer {
    public int customerId;
    public char pickUpPoint;
    public char dropPoint;
    public int time;
    public Customer(int customerId,char pickUpPoint,char dropPoint, int time){
        this.customerId = customerId;
        this.pickUpPoint = pickUpPoint;
        this.dropPoint = dropPoint;
        this.time = time;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public char getPickUpPoint() {
        return pickUpPoint;
    }

    public void setPickUpPoint(char pickUpPoint) {
        this.pickUpPoint = pickUpPoint;
    }

    public char getDropPoint() {
        return dropPoint;
    }

    public void setDropPoint(char dropPoint) {
        this.dropPoint = dropPoint;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
