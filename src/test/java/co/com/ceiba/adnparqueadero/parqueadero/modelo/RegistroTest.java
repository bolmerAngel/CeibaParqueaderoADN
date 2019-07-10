package co.com.ceiba.adnparqueadero.parqueadero.modelo;



import org.junit.Test;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.excepciones.*;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.RegistroVehiculo;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.protocolorespuestassistemas.RespuestaSistema;
import co.com.ceiba.adnparqueadero.parqueadero.testBase.*;
import co.com.ceiba.adnparqueadero.parqueadero.testdatabuilder.*;



public class RegistroTest {

	 @Test
	    public void validatePlacaRequired() {
	        //Arrange
		 RegistroTestDataBuilder registroTestDataBuilder = new RegistroTestDataBuilder();

		 registroTestDataBuilder.withPlaca(null);

         //Act - Assert
         TestBase.assertThrows(() -> registroTestDataBuilder.build(), ExcepcionPlaca.class, "La placa es un dato requerido.");
     }
	 
	 @Test
	    public void validateTipovehiculopeRequired() {
	        //Arrange
		 RegistroTestDataBuilder registroTestDataBuilder  = new RegistroTestDataBuilder();

		 registroTestDataBuilder.withTipovehiculo(null);

	        //Act - Assert
	        TestBase.assertThrows(() -> registroTestDataBuilder.build(), ExcepcionTipovehiculoNoNull.class,"El tipo de vehiculo es un dato requerido.");
	    }


	 
	 
	 @Test
	    public void validateTipovehiculoInformacion() {
	        //Arrange
		 RegistroTestDataBuilder  registroTestDataBuilder  = new RegistroTestDataBuilder();

		 registroTestDataBuilder.withTipovehiculo("AUTO");
		 
		

	        //Act - Assert
		TestBase.assertThrows(() -> registroTestDataBuilder.build(), ExcepcionTipoInformacion.class,"El campo tipo vehiculo no tiene valor (AUTO) valido.");
	    }

	  @Test
	    public void validardesplazamientorequerido() {
		  RegistroTestDataBuilder registroTestDataBuilder = new RegistroTestDataBuilder();

		   registroTestDataBuilder.withCilindraje(null);

	        //Act - Assert
	        TestBase.assertThrows(() -> registroTestDataBuilder.build(), ExceptionCilindraje.class,"El campo cilindraje es requerido.");
	    }
	 
}
