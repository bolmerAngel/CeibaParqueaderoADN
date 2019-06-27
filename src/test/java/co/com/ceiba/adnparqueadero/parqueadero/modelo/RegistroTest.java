package co.com.ceiba.adnparqueadero.parqueadero.modelo;



import org.junit.Test;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones.*;
import co.com.ceiba.adnparqueadero.parqueadero.testBase.*;
import co.com.ceiba.adnparqueadero.parqueadero.testdatabuilder.*;




public class RegistroTest {

	 @Test
	    public void validatePlacaRequired() {
	        //Arrange
		   RegistroTestDataBuilder registroTestDataBuilder = new RegistroTestDataBuilder();

		   registroTestDataBuilder.withPlaca(null);

	        //Act - Assert
	        TestBase.assertThrows(() -> registroTestDataBuilder.build(), ExcepcionPlaca.class,"La placa es un dato requerido.");
	    }
	 
	 @Test
	    public void validateTipovehiculopeRequired() {
	        //Arrange
		 RegistroTestDataBuilder registroTestDataBuilder  = new RegistroTestDataBuilder();

		 registroTestDataBuilder.withTipovehiculo(null);

	        //Act - Assert
	        TestBase.assertThrows(() -> registroTestDataBuilder.build(), ExcepcionTipovehiculoNoNull.class,"El tipo de vehiculo es un dato requerido.");
	    }


}
