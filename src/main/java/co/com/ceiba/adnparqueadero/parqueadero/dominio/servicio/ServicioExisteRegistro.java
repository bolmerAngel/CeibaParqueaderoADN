package co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.Registro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.puerto.IRepositorioRegistro;

public class ServicioExisteRegistro {
	
	IRepositorioRegistro repositorioRegistro;
	
	  public void existe(Registro registro) {
		  boolean existe= repositorioRegistro.ExisteRegistro(registro.getPlaca());
		  
		  if(existe) {
			  //Excepciion()
			  
		  }
	  }

}
