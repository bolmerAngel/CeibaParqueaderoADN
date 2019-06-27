package co.com.ceiba.adnparqueadero.parqueadero.dominio.puerto;

import java.util.List;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.Registro;


public interface IRepositorioRegistro {
	
	void Regitrar(Registro registro);
	
	void Egreso(String placa);
	
	int cantidadVehiculo(String tipovehiculo);
	
	List<Registro> list();
	
	boolean  ExisteRegistro(String placa);
	
	
	

}
