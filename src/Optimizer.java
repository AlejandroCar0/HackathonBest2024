import java.util.Arrays;

public class Optimizer {
    private final ListaIsletas listaIsletas;

    public Optimizer() {
        this.listaIsletas = new ListaIsletas();
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
        // Por tiempo mínimo necesario para cargarlo (DECRECIENTE)
        Arrays.sort(trucks, (t1, t2) ->      // es la más óptima, orden descendente de los tiempos mínimos de carga
                Integer.compare(
                        t2.getBattery_capacity() / t2.getCharging_speed(),
                        t1.getBattery_capacity() / t1.getCharging_speed()
                )
        );
    }
}
