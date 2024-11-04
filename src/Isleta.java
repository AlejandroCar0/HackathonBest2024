public class Isleta {
    private String[] puertos;
    private int potencia;
    private double instanteLiberacion;
    private double totalConsumido;

    public Isleta(String[] puertos, int potencia){
        this.puertos = puertos;
        this.potencia = potencia;
        this.instanteLiberacion = 0;
        this.totalConsumido = 0;
    }

    public boolean puedeCargarDirecta(Truck t){
        for(String direccion: t.getCharginPort()){
            if(!direccion.equals("inductive") && contienePuerto(direccion))
                return true;
        }
        return false;
    }

    public boolean puedeCargar(Truck t){
        for(String direccion: t.getCharginPort()){
            if(contienePuerto(direccion))
                return true;
        }
        return false;
    }

    public double instanteLiberacionCamion(Truck t){
        return this.instanteLiberacion + tiempoCargaCamion(t);
    }

    private double tiempoCargaCamion(Truck t){
        double velocidadCarga = this.potencia;
        if(!puedeCargarDirecta(t))
            velocidadCarga *= 0.7;
        velocidadCarga = Math.min(velocidadCarga, t.getChargingSpeed());

        return t.getBatteryCapacity()/velocidadCarga;
    }

    public boolean contienePuerto(String puerto){
        for(String p: puertos){
            if(p.equals(puerto))
                return true;
        }
        return false;
    }

    public void ocuparIsleta(Truck t, double instanteLiberacion){
        setInstanteLiberacion(instanteLiberacion);
        setTotalConsumido(t);
    }

    private void setInstanteLiberacion(double instanteLiberacion){
        this.instanteLiberacion = instanteLiberacion;
    }

    private void setTotalConsumido(Truck t){
        double consumido = t.getBatteryCapacity();
        if(!puedeCargarDirecta(t))
            this.totalConsumido += consumido / 0.7;
        else
            this.totalConsumido += consumido;
    }

    public double getInstanteLiberacion(){
        return this.instanteLiberacion;
    }

    public double getTotalConsumido(){
        return this.totalConsumido;
    }
}
