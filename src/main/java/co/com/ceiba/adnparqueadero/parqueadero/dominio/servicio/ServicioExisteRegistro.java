package co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio;

import java.util.Date;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones.ExcepcionNoExisteRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.mensajes.MensageSistema;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.Registro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.puerto.IRepositorioRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.fabrica.CargaFabrica;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.fabrica.CobroEstacionamiento;




public class ServicioExisteRegistro {
	
	 private IRepositorioRegistro registroRepositorio;
	

	 public ServicioExisteRegistro(IRepositorioRegistro registroRepositorio){
	        this.registroRepositorio = registroRepositorio;
	    }
	 
	 public void salida(String placa) {
	        Registro registro = registroRepositorio.findByPlaca(placa);

	        if (registro == null) {
	            throw new ExcepcionNoExisteRegistro(MensageSistema.MESAJE_VEHICULO_NO_ENCONTRADO);
	        }
	        chargePark(registro);
	        registroRepositorio.ExisteRegistro(registro);
	    }
	 
	 private void chargePark(Registro registro) {
		 
		  CargaFabrica cargarFabrica;
	        registro.setDiasalida(new Date());
	        CobroEstacionamiento ParqueCarga = CargaFabrica.getInstance(registro.getTipovehiculo());
	        ParqueCarga.establecerCarga(registro);
	        
	    }

}
