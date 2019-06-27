package co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio;

import java.util.List;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.Registro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.puerto.IRepositorioRegistro;

public class ServicioListRegistro {
	
	IRepositorioRegistro repositorioRegistro;

	 public List<Registro> listRegister() {
	        return repositorioRegistro.list();
	    }
}
