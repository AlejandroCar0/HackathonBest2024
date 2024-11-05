import java.util.Arrays;
import java.util.Comparator;

public class Optimizer {
    private final ListaIsletas listaIsletas;
    private final int orden;

    public Optimizer(int orden) {
        this.listaIsletas = new ListaIsletas();
        this.orden = orden;
    }

    public void asignarTrucksOptimo(Truck[] trucks){
        sortTrucks(trucks);
        for(Truck truck : trucks){
            listaIsletas.asignarIsleta(truck);
        }

        printResults(trucks.length);
    }

    private void printResults(int numTrucks){
        System.out.println("\nCAMIONES CARGADOS: " + numTrucks);
        System.out.println("##################################");
        System.out.printf("TIEMPO DE CARGA: %.2f horas",this.listaIsletas.getMaxTiempoLiberacion());
        System.out.println("\n##################################");
        System.out.printf("kW CONSUMIDOS: %.2f kW\n",this.listaIsletas.getTotalConsumido());
    }

    private void sortTrucks(Truck[] trucks){
        switch(orden){
            case 1: // Por tiempo mínimo necesario para cargarlo (DECRECIENTE)
                Arrays.sort(trucks, (t1, t2) ->      // es la más óptima, orden descendente de los tiempos mínimos de carga
                        Integer.compare(
                                t2.getBattery_capacity() / t2.getCharging_speed(),
                                t1.getBattery_capacity() / t1.getCharging_speed()
                        )
                );
                break;
            case 2: // Por tiempo mínimo necesario para cargarlo (CRECIENTE)
                Arrays.sort(trucks, Comparator.comparingInt(t -> t.getBattery_capacity() / t.getCharging_speed()));
                break;
            case 3: // Por capacidad de la batería (DECRECIENTE)
                Arrays.sort(trucks, Comparator.comparingInt(Truck::getBattery_capacity).reversed());
                break;
            case 4: // Por capacidad de la batería (CRECIENTE)
                Arrays.sort(trucks, Comparator.comparingInt(Truck::getBattery_capacity));
                break;
            case 5: // Por velocidad de carga (DECRECIENTE)
                Arrays.sort(trucks, Comparator.comparingInt(Truck::getCharging_speed).reversed());
                break;
            case 6: // Por velocidad de carga (CRECIENTE)
                Arrays.sort(trucks, Comparator.comparingInt(Truck::getCharging_speed));
                break;
        }
    }
}
