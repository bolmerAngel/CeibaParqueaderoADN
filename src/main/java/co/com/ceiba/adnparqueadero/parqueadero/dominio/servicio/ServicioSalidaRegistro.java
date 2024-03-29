package co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio;

import java.util.Date;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.excepciones.ExcepcionNoExisteRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.RegistroVehiculo;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.protocolorespuestassistemas.RespuestaSistema;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.puerto.PuertoRepositorioRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.fabrica.CargaFabrica;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.fabrica.CobroEstacionamiento;




public class ServicioSalidaRegistro {
	
	 private PuertoRepositorioRegistro registroRepositorio;
	

	 public ServicioSalidaRegistro(PuertoRepositorioRegistro registroRepositorio){
	        this.registroRepositorio = registroRepositorio;
	    }
	 
	 public void salida(String placa) {
	        RegistroVehiculo registroVehiculo = registroRepositorio.findByPlaca(placa);

	        if (registroVehiculo == null) {
	            throw new ExcepcionNoExisteRegistro(RespuestaSistema.MESAJE_VEHICULO_NO_ENCONTRADO);
	        }
	        cobrar(registroVehiculo);
	        registroRepositorio.regitrar(registroVehiculo);
	    }
	 
	 private void cobrar(RegistroVehiculo registroVehiculo) {
		    registroVehiculo.setDiasalida(new Date());
	        CobroEstacionamiento parqueCarga = CargaFabrica.getInstance(registroVehiculo.getTipovehiculo());
	        parqueCarga.establecerCarga(registroVehiculo);
	        
	    }

}
