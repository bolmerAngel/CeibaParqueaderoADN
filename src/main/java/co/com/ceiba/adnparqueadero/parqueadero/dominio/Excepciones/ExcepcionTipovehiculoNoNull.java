package co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones;

public class ExcepcionTipovehiculoNoNull extends RuntimeException {
	
	private static final long serialVersionUID = 6759407566706191023L;
	
    public ExcepcionTipovehiculoNoNull (String message) {
        super(message);
    }
}
