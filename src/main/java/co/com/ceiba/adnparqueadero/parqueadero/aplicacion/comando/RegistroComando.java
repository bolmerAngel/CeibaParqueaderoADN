package co.com.ceiba.adnparqueadero.parqueadero.aplicacion.comando;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegistroComando {
	private Integer idvehiculo;
	private String placa;
	private Date diallegada;
	private Date diasalida;
	private Integer cilindraje;
	private Integer valor;
	private String tipovehiculo;
	
	
	
	
}
