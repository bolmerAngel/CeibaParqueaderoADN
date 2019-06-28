package co.com.ceiba.adnparqueadero.parqueadero.aplicacion.consulta;

import java.util.List;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.Registro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.puerto.IRepositorioRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.ServicioListRegistro;


public class  RegistroServicioLista {

	 private final ServicioListRegistro repositorioRegistro;
	
	public RegistroServicioLista (ServicioListRegistro repositorioRegistro) {
		this. repositorioRegistro= repositorioRegistro;
					
	}
	 public List<Registro> listRegister() {
	        return repositorioRegistro.listRegister();
	    }
	
}
