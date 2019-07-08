package co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio;

import java.util.Date;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.excepciones.ExcepcionNoExisteRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.RegistroVehiculo;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.protocoloRespuestasSistemas.RespuestaSistema;
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
	        Cobrar(registroVehiculo);
	        registroRepositorio.Regitrar(registroVehiculo);
	    }
	 
	 private void Cobrar(RegistroVehiculo registroVehiculo) {
		    registroVehiculo.setDiasalida(new Date());
	        CobroEstacionamiento ParqueCarga = CargaFabrica.getInstance(registroVehiculo.getTipovehiculo());
	        ParqueCarga.establecerCarga(registroVehiculo);
	        
	    }

}
