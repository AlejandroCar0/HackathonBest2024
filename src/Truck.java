public class Truck {
    private int battery_capacity;
    private String[] charging_port;
    private int charging_speed;

    public Truck(int battery_capacity, String[] charging_port, int charging_speed) {
        this.battery_capacity = battery_capacity;
        this.charging_port = charging_port;
        this.charging_speed = charging_speed;
    }


    @Override
    public String toString() {
        return "Truck {" +
                "batteryCapacity=" + battery_capacity +
                ", chargingPort=" + charging_port +
                ", chargingSpeed=" + charging_speed +
                '}';
    }
    public int getBattery_capacity(){
        return this.battery_capacity;
    }
    public String[] getCharging_port(){
        return this.charging_port;
    }
    public int getCharging_speed(){
        return this.charging_speed;
    }
}
