package co.com.ceiba.adnparqueadero.parqueadero.dominio.puerto;

import java.util.List;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.RegistroVehiculo;

public interface PuertoRepositorioRegistro {
	
	RegistroVehiculo Regitrar(RegistroVehiculo registroVehiculo);
	
	int cantidadVehiculo(String tipovehiculo);
	
	List <RegistroVehiculo> list();
	
	boolean  salirRegistro(RegistroVehiculo registroVehiculo);

	int countVehicleType(String tipovehiculo);
	
	RegistroVehiculo findByPlaca(String placa);
	
	
	

}
