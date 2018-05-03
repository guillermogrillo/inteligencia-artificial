package ar.edu.utn.frba.tsp.models;

public enum Ciudad {

    BUENOS_AIRES("Buenos Aires, Argentina",-34.603684,-58.381559),
    RIO_DE_JANEIRO("Rio de Janeiro, Brasil",-22.906847,-43.172896),
    LA_PAZ("La Paz, Bolivia",-16.489689,-68.119294),
    SANTIAGO("Santiago de Chile, Chile",-33.44889,-70.669265),
    BOGOTA("Bogota, Colombia",4.710989,-74.072092),
    GUAYAQUIL("Guayaquil, Ecuador",-2.170998,-79.922359),
    LIMA("Lima, Peru",-12.046373,-77.042754),
    ASUNCION("Asunsion, Paraguay",-25.26374,-57.575926),
    CARACAS("Caracas, Venezuela",10.480594,-66.903606),
    MONTEVIDEO("Montevideo, Uruguay",-34.901113,-56.164531),
    MEXICO_DF("Ciudad de Mexico, Mexico",19.432608,99.133208),
    NUEVA_YORK("Nueva York, EEUU",40.712775,-74.005973),
    MADRID("Madrid, España",40.416775,-3.70379),
    ROMA("Roma, Italia",41.902784,12.496366),
    PARIS("Paris, Francia",48.856614,2.352222),
    AMSTERDAM("Amsterdam, Holanda",52.370216,4.895168),
    TOKIO("Tokio, Japon",35.689488,139.691706),
    SIDNEY("Sidney, Australia",-33.86882,151.209296),
    JOHANNESBURG("Johannesburg, Sudafrica",-26.204103,28.047305),
    MOSCU("Moscu, Rusia",55.755826,37.6173);


    private String nombre;
    //Y
    private double latitud;
    //X
    private double longitud;


    Ciudad(String nombre, double latitud, double longitud) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double distancia(Ciudad otraCiudad){
        double distanciaX = Math.abs(getLongitud() - otraCiudad.getLongitud());
        double distanciaY = Math.abs(getLatitud() - otraCiudad.getLatitud());
        double distancia = Math.sqrt( (distanciaX*distanciaX) + (distanciaY*distanciaY) );
        return distancia;
    }

    /*
    Getters y Setters
     */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString(){
        return getNombre()+"["+getLatitud()+":"+getLongitud()+"]";
    }

}
