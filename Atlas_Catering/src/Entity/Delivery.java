package Entity;

import java.time.LocalDateTime;

/**
 * @author Tan Yi Hong
 */

public class Delivery {

    String addressLine1;
    String addressLine2;
    String city;
    String state;
    String zip;
    double deliveryFee;
    LocalDateTime estimatedDeliveryTime;

    public Delivery() {
        this("", "", "", "", "", 0.0, LocalDateTime.now());
    }

    public Delivery(
            String addressLine1,
            String addressLine2,
            String city,
            String state,
            String zip,
            double deliveryFee,
            LocalDateTime estimatedDeliveryTime
    ) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.deliveryFee = deliveryFee;
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public LocalDateTime getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public void setEstimatedDeliveryTime(LocalDateTime estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    public String toString() {
        return (
                "Delivery{" +
                        "addressLine1='" +
                        addressLine1 +
                        '\'' +
                        ", addressLine2='" +
                        addressLine2 +
                        '\'' +
                        ", city='" +
                        city +
                        '\'' +
                        ", state='" +
                        state +
                        '\'' +
                        ", zip='" +
                        zip +
                        '\'' +
                        ", deliveryFee=" +
                        deliveryFee +
                        ", estimatedDeliveryTime=" +
                        estimatedDeliveryTime +
                        '}'
        );
    }

    public String toInfoString(int i) {
        return (
                "Delivery No : " +
                        i +
                        '\n' +
                        addressLine1 +
                        '\n' +
                        addressLine2 +
                        '\n' +
                        zip +
                        '\t' +
                        city +
                        '\n' +
                        state +
                        '\n' +
                        "================================="
        );
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Delivery)) {
            return false;
        }
        Delivery delivery = (Delivery) o;

        boolean addressLine1Equals = addressLine1.equals(delivery.addressLine1);
        boolean addressLine2Equals = addressLine2.equals(delivery.addressLine2);
        boolean cityEquals = city.equals(delivery.city);
        boolean stateEquals = state.equals(delivery.state);
        boolean zipEquals = zip.equals(delivery.zip);
        boolean deliveryFeeEquals = deliveryFee == delivery.deliveryFee;
        boolean estimatedDeliveryTimeEquals = estimatedDeliveryTime.equals(delivery.estimatedDeliveryTime);
        boolean finalEquals = addressLine1Equals && addressLine2Equals && cityEquals && stateEquals && zipEquals && deliveryFeeEquals && estimatedDeliveryTimeEquals;

        return (finalEquals);
    }

}
