package co.com.ceiba.adnparqueadero.parqueadero.dominio.excepciones;

public class ExcepcionTipoInformacion extends RuntimeException {
	
	private static final long serialVersionUID = 6759407566706191023L;
	
    public ExcepcionTipoInformacion (String message) {
        super(message);
    }
}