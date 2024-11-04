import java.util.List;

public class Truck {
    private int batteryCapacity;
    private String[] chargingPort;
    private int chargingSpeed;

    public Truck(int batteryCapacity, String[] chargingPort, int chargingSpeed) {
        this.batteryCapacity = batteryCapacity;
        this.chargingPort = chargingPort;
        this.chargingSpeed = chargingSpeed;
    }


    @Override
    public String toString() {
        return "Truck {" +
                "batteryCapacity=" + batteryCapacity +
                ", chargingPort=" + chargingPort +
                ", chargingSpeed=" + chargingSpeed +
                '}';
    }
    public int getBatteryCapacity(){
        return this.batteryCapacity;
    }
    public String[] getCharginPort(){
        return this.chargingPort;
    }
    public int getChargingSpeed(){
        return this.chargingSpeed;
    }
}
