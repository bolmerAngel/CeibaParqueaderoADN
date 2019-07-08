package co.com.ceiba.adnparqueadero.parqueadero.dominio.excepciones;

public class ExcepcionNoEspacioTipoVehiculo extends RuntimeException {
    private static final long serialVersionUID = 1L;

	
    public ExcepcionNoEspacioTipoVehiculo(String message) {
        super( message);
    }
}
