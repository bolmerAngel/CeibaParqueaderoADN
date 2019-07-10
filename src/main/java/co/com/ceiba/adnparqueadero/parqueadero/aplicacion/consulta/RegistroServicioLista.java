package co.com.ceiba.adnparqueadero.parqueadero.aplicacion.consulta;

import java.util.List;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.RegistroVehiculo;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.ServicioListRegistro;


public class  RegistroServicioLista {

	 private final ServicioListRegistro repositorioRegistro;
	
	public RegistroServicioLista (ServicioListRegistro repositorioRegistro) {
		this. repositorioRegistro= repositorioRegistro;
					
	}
	 public List<RegistroVehiculo> listRegister() {
	        return repositorioRegistro.listaRegistrarse();
	    }
	
}
