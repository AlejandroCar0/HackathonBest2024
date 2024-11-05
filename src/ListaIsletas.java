import java.util.ArrayList;
import java.util.List;

public class ListaIsletas {
    private final List<Isleta> listaIsleta;

    public ListaIsletas(){
        listaIsleta = new ArrayList<>();
        for(int i = 0; i < 5; i++)
            listaIsleta.add(new Isleta(new String[] {"right","left","top"},250));
        for(int i = 0;i < 7; i++)
            listaIsleta.add(new Isleta(new String[] {"right","top"},150));
        for(int i = 0;i < 3; i++)
            listaIsleta.add(new Isleta(new String[] {"top","inductive"},110));
        for(int i = 0; i < 5; i++)
            listaIsleta.add(new Isleta(new String[] {"left","top","inductive"},60));
    }

    public void asignarIsleta(Truck truck){
        double menorTiempo = Integer.MAX_VALUE;
        Isleta isletaoptima = null;
        for(int i = listaIsleta.size()-1; i >= 0; i--){
            Isleta isleta = listaIsleta.get(i);
            if(isleta.puedeCargar(truck)) {
                double instanteLiberacion = isleta.instanteLiberacionCamion(truck);
                if (instanteLiberacion < menorTiempo) {
                    menorTiempo = instanteLiberacion;
                    isletaoptima = isleta;
                }
            }
        }
        assert isletaoptima != null;
        isletaoptima.ocuparIsleta(truck, menorTiempo);
    }

    public double getMaxTiempoLiberacion(){
        double resultado = Double.MIN_VALUE;
        for(Isleta isleta:listaIsleta){
            resultado = Math.max(resultado,isleta.getInstanteLiberacion());
        }
        return resultado;
    }

    public double getTotalConsumido(){
        double resultado =0;
        for (Isleta isleta: listaIsleta){
            resultado+=isleta.getTotalConsumido();
        }
        return resultado;
    }
}
