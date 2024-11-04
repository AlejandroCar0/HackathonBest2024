public class Isleta {
    private String[] direcciones;
    private int potencia;
    private double tiempoLiberacion;
    private double totalConsumido;
    public Isleta(String[]direcciones, int potencia){
        this.direcciones = direcciones;
        this.potencia = potencia;
        this.tiempoLiberacion = 0;
        this.totalConsumido = 0;
    }

    public boolean CamionCompatibleDirecta(Truck t){
        for(String direccion: t.getCharginPort()){
            if(!direccion.equals("inductive") && contienePuerto(direccion))
                return true;
        }
        return false;
    }
    public boolean camionCompatible(Truck t){
        for(String direccion: t.getCharginPort()){
            if(contienePuerto(direccion))
                return true;
        }
        return false;
    }
    public double instanteLiberacionCamion(Truck t){
        return this.tiempoLiberacion + tiempoCargaCamion(t);
    }
    private double tiempoCargaCamion(Truck t){
        if(CamionCompatibleDirecta(t))
            return t.getBatteryCapacity()/Math.min((double)this.potencia,t.getChargingSpeed());
        return t.getBatteryCapacity()/Math.min((double)this.potencia * 0.7,t.getChargingSpeed());
    }

    public boolean contienePuerto(String puerto){
        for(String p: direcciones){
            if(p.equals(puerto))
                return true;
        }
        return false;
    }
    public void setTiempoLiberacion(double tiempoLiberacion){
        this.tiempoLiberacion = tiempoLiberacion;
    }
    public void setTotalConsumido(Truck t){
        double consumido = t.getBatteryCapacity();
        if(!CamionCompatibleDirecta(t)) {
            this.totalConsumido += consumido / 0.7;
        }else{
            this.totalConsumido+=consumido;
        }
    }
    public double getTiempoLiberacion(){
        return  this.tiempoLiberacion;
    }
    public double getTotalConsumido(){
        return this.totalConsumido;
    }
}
