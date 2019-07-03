package co.com.ceiba.adnparqueadero.parqueadero.modelo;



import org.junit.Test;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones.*;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.mensajes.MensageSistema;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.Registro;
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
	 
	  @Test
	    public void validarNumeroCilindraje() {
	        //Arrange
	        RegistroTestDataBuilder registroTestDataBuilder = new RegistroTestDataBuilder();
	        registroTestDataBuilder.withTipovehiculo("moto");
	        registroTestDataBuilder.withCilindraje(0);

	        //Act - Assert
	        TestBase.assertThrows(() -> registroTestDataBuilder.build(), ExcepcionCilindrajeNUmerico.class, MensageSistema.MENSAGE_CILINDRAJE_INFORMACION_INCORRECTA);
	    }
}
