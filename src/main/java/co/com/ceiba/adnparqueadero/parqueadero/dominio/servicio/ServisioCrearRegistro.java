package co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.Registro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.puerto.IRepositorioRegistro;


public class ServisioCrearRegistro {
	
	IRepositorioRegistro repositorioRegistro;
	
	
	
	 public void registrar(Registro registro) {
		  existe(registro);
		  repositorioRegistro.Regitrar(registro);
	  }
	
	 public void existe(Registro registro) {
		  boolean existe= repositorioRegistro.ExisteRegistro(registro.getPlaca());
		  
		  if(existe) {
			  //Excepciion()
			  
		  }
	  }

}
