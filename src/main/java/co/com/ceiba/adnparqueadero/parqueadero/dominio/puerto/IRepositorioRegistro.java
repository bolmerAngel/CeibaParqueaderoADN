package co.com.ceiba.adnparqueadero.parqueadero.dominio.puerto;

import java.util.List;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.Registro;
import co.com.ceiba.adnparqueadero.parqueadero.infraestructura.entida.RegistroEntida;



public interface IRepositorioRegistro {
	
	Registro Regitrar(Registro registro);
	
	int cantidadVehiculo(String tipovehiculo);
	
	List<Registro> list();
	
	boolean  ExisteRegistro(Registro registro);

	int countVehicleType(String tipovehiculo);
	
	Registro findByPlaca(String placa);
	
	
	

}
