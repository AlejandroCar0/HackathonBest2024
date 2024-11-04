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

        Truck truck1 = new Truck(2000, new String[] {"top"}, 250);
        Truck truck2 = new Truck(1500, new String[] {"right", "left"}, 200);
        Truck truck3 = new Truck(1800, new String[] {"left", "top"}, 150);
        Truck truck4 = new Truck(1200, new String[] {"inductive"}, 100);
        Truck truck5 = new Truck(1000, new String[] {"right"}, 125);
        Truck truck6 = new Truck(2200, new String[] {"top", "inductive"}, 300);
        Truck truck7 = new Truck(1600, new String[] {"left", "top"}, 180);
        Truck truck8 = new Truck(900, new String[] {"right", "inductive"}, 75);
        Truck truck9 = new Truck(2500, new String[] {"top"}, 400);
        Truck truck10 = new Truck(800, new String[] {"left"}, 60);

        Truck truck11 = new Truck(1300, new String[] {"top", "right"}, 140);
        Truck truck12 = new Truck(1100, new String[] {"top", "left"}, 130);
        Truck truck13 = new Truck(2100, new String[] {"top", "inductive"}, 200);
        Truck truck14 = new Truck(1900, new String[] {"left"}, 120);
        Truck truck15 = new Truck(1000, new String[] {"right"}, 90);
        Truck truck16 = new Truck(2400, new String[] {"inductive"}, 150);
        Truck truck17 = new Truck(1700, new String[] {"left", "right"}, 220);
        Truck truck18 = new Truck(1400, new String[] {"right"}, 125);
        Truck truck19 = new Truck(1200, new String[] {"left", "inductive"}, 110);
        Truck truck20 = new Truck(2000, new String[] {"top"}, 300);

        Truck truck21 = new Truck(800, new String[] {"top", "left"}, 75);
        Truck truck22 = new Truck(2300, new String[] {"right"}, 280);
        Truck truck23 = new Truck(1600, new String[] {"inductive"}, 100);
        Truck truck24 = new Truck(2000, new String[] {"top", "left"}, 250);
        Truck truck25 = new Truck(1500, new String[] {"right"}, 175);
        Truck truck26 = new Truck(1800, new String[] {"left"}, 150);
        Truck truck27 = new Truck(900, new String[] {"top", "inductive"}, 95);
        Truck truck28 = new Truck(2400, new String[] {"right", "left"}, 320);
        Truck truck29 = new Truck(2100, new String[] {"top", "inductive"}, 300);
        Truck truck30 = new Truck(1300, new String[] {"right"}, 120);

        Truck truck31 = new Truck(1200, new String[] {"top", "left"}, 150);
        Truck truck32 = new Truck(2000, new String[] {"top", "right"}, 260);
        Truck truck33 = new Truck(900, new String[] {"inductive"}, 80);
        Truck truck34 = new Truck(2500, new String[] {"top"}, 400);
        Truck truck35 = new Truck(1700, new String[] {"left", "inductive"}, 180);
        Truck truck36 = new Truck(800, new String[] {"right"}, 70);
        Truck truck37 = new Truck(1100, new String[] {"top"}, 130);
        Truck truck38 = new Truck(2000, new String[] {"left"}, 240);
        Truck truck39 = new Truck(1600, new String[] {"top", "right"}, 200);
        Truck truck40 = new Truck(1000, new String[] {"inductive"}, 90);

        Truck truck41 = new Truck(2100, new String[] {"right"}, 300);
        Truck truck42 = new Truck(2200, new String[] {"left"}, 270);
        Truck truck43 = new Truck(1800, new String[] {"top", "inductive"}, 200);
        Truck truck44 = new Truck(1300, new String[] {"top", "left"}, 140);
        Truck truck45 = new Truck(1200, new String[] {"inductive"}, 110);
        Truck truck46 = new Truck(800, new String[] {"right"}, 60);
        Truck truck47 = new Truck(900, new String[] {"top", "left"}, 85);
        Truck truck48 = new Truck(1400, new String[] {"inductive"}, 95);
        Truck truck49 = new Truck(1600, new String[] {"left"}, 160);
        Truck truck50 = new Truck(1800, new String[] {"top"}, 190);

        Truck[] arrayTrucks = new Truck[] {
                truck1, truck2, truck3, truck4, truck5, truck6, truck7, truck8, truck9, truck10,
                truck11, truck12, truck13, truck14, truck15, truck16, truck17, truck18, truck19, truck20,
                truck21, truck22, truck23, truck24, truck25, truck26, truck27, truck28, truck29, truck30,
                truck31, truck32, truck33, truck34, truck35, truck36, truck37, truck38, truck39, truck40,
                truck41, truck42, truck43, truck44, truck45, truck46, truck47, truck48, truck49, truck50
        };
        Main.mejorOptimizacion(arrayTrucks,l);
    }
    public static void mejorOptimizacion(Truck[] trucks,ListaIsletas l){
        Arrays.sort(trucks, Comparator.comparingInt(Truck::getBatteryCapacity).reversed());
        for(Truck truck : trucks){
            l.asignarIsleta(truck);
        }
        System.out.println("\nCAMIONES CARGADOS: "+trucks.length);
        System.out.println("##################################");
        System.out.printf("TIEMPO DE CARGA: %.2f",l.getMaxTiempoLiberacion());
        System.out.println("\n##################################");
        System.out.printf("Kw CONSUMIDOS: %.2f\n",l.getTotalConsumido());
    }
}