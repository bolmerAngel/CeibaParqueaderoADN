package co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones;

public class ExcepcionLicenciaLugarFecha extends RuntimeException {
    private static final long serialVersionUID = 1L;


	    public ExcepcionLicenciaLugarFecha (String message) {
	        super(message);
	    }

}
