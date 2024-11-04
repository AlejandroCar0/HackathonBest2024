import java.util.*;

public class Main {
    public static void main(String[] args) {
        ListaIsletas l = new ListaIsletas();
        /*Truck truck1 = new Truck(1250, new String[] {"top"},250);
        Truck truck2 = new Truck(1000, new String[] {"right","left","inductive"},125);
        Truck truck3 = new Truck(1250, new String[] {"top","left"},137);
        Truck truck4 = new Truck(1000, new String[] {"right"},210);
        Truck truck5 = new Truck(1250, new String[] {"inductive"},50);
        Truck truck6 = new Truck(1000, new String[] {"top","left"},500);
        Truck truck7 = new Truck(1250, new String[] {"right","left"},150);
        Truck truck8 = new Truck(1000, new String[] {"top","right","inductive"},60);
        Truck truck9 = new Truck(1250, new String[] {"top","inductive"},110);
        Truck truck10 = new Truck(1000, new String[] {"right"},109);
        Truck truck11 = new Truck(1250, new String[] {"top","right","left","inductive"},249);
        Truck truck12 = new Truck(1000, new String[] {"left"},251);

        Truck[] arrayTrucks = new Truck[] {truck1, truck2, truck3, truck4, truck5, truck6, truck7, truck8, truck9, truck10, truck11, truck12};*/
        Truck truck1 = new Truck(1250, new String[] {"inductive"},250);
        Truck truck2 = new Truck(1000, new String[] {"right","left","inductive"},125);
        Truck[] arrayTrucks = new Truck[] {truck1,truck2};
        Main.mejorOptimizacion(arrayTrucks,l);
    }
    public static void mejorOptimizacion(Truck[] trucks,ListaIsletas l){
        Arrays.sort(trucks, Comparator.comparingInt(Truck::getBatteryCapacity));
        for(Truck truck : trucks){
            l.asignarIsleta(truck);
        }
        System.out.println("\nCAMIONES CARGADOS: "+trucks.length);
        System.out.println("##################################");
        System.out.printf("\nTIEMPO DE CARGA: %.2f",l.getMaxTiempoLiberacion());
        System.out.println("##################################");
        System.out.printf("\nKw CONSUMIDOS: %.2f\n",l.getTotalConsumido());
    }
}