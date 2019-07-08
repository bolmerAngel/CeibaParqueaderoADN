package co.com.ceiba.adnparqueadero.parqueadero.servicio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.excepciones.ExcepcionDuplicada;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.excepciones.ExcepcionLicenciaLugarFecha;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.excepciones.ExcepcionNoEspacioTipoVehiculo;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.excepciones.ExcepcionNoExisteRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.RegistroVehiculo;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.protocoloRespuestasSistemas.RespuestaSistema;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.puerto.PuertoRepositorioRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.ServicioCrearRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.ServicioSalidaRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.testdatabuilder.RegistroTestDataBuilder;






public class ServicioTest {
	
	private PuertoRepositorioRegistro  puertoRepositorioRegistro;

	@Before
	public void InicioMocks() {
		puertoRepositorioRegistro = mock(PuertoRepositorioRegistro.class);
	}
	
	 @Test
	 public void  RegistroCarroTest() {
		 RegistroTestDataBuilder registrar = new RegistroTestDataBuilder()
	                .withTipovehiculo(RespuestaSistema.TIPO_VEHICULO_VALUE_CARRO);
		 
		 RegistroVehiculo registroVehiculo = registrar.build();

		 ServicioCrearRegistro  servicioCrearRegistro  = new ServicioCrearRegistro (puertoRepositorioRegistro);

	     when(puertoRepositorioRegistro.Regitrar(registroVehiculo)).thenReturn(registroVehiculo);

	        //Act
	        RegistroVehiculo registerCopia = servicioCrearRegistro.EntradaEstabelcida(registroVehiculo);

	        //Assert
	        assertEquals(registerCopia.getIdvehiculo(),registroVehiculo.getIdvehiculo());

		 
	 }
	
	
	 @Test
	    public void  RegistroMotoTest(){
	        //Arrange
		 RegistroTestDataBuilder registrar = new RegistroTestDataBuilder()
				 .withTipovehiculo(RespuestaSistema.TIPO_VEHICULO_VALUE_MOTO);
		 			
		 

	        RegistroVehiculo registroVehiculo = registrar.build();

	        ServicioCrearRegistro servicioCrearRegistro = new ServicioCrearRegistro(puertoRepositorioRegistro);

	        when(puertoRepositorioRegistro.Regitrar(registroVehiculo)).thenReturn(registroVehiculo);

	        //Act
	        RegistroVehiculo registerCopia = servicioCrearRegistro.EntradaEstabelcida(registroVehiculo);

	        //Assert
	        assertEquals(registerCopia.getIdvehiculo(),registroVehiculo.getIdvehiculo());
	    }
	
	
	 @Test
	    public void  VehiculoExistePrueba(){
		 RegistroTestDataBuilder registrar = new RegistroTestDataBuilder()
	                .withTipovehiculo(RespuestaSistema.TIPO_VEHICULO_VALUE_CARRO);

	        RegistroVehiculo registroVehiculo = registrar.build();

	        ServicioCrearRegistro servicioCrearRegistro = new ServicioCrearRegistro(puertoRepositorioRegistro);

	        when(puertoRepositorioRegistro.Regitrar(registroVehiculo)).thenReturn(registroVehiculo);

	        //Act
	        try {
	        	 servicioCrearRegistro.EntradaEstabelcida(registroVehiculo);
	        }catch (ExcepcionDuplicada ex){
	            // Assert.
	            assertEquals(RespuestaSistema.MENSAJE_YA_EXISTE_VEHICULO, ex.getMessage());
	        }
	    }

	
	
	 
	 @Test
	    public void RegistroPruebahoraCarga() {
	        //Arrange
	        int valorHora = 1000;
	        int hora = 6;
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(new Date());

	        cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) - hora);

	        RegistroTestDataBuilder registrar = new RegistroTestDataBuilder()
	                .withTipovehiculo(RespuestaSistema.TIPO_VEHICULO_VALUE_CARRO)
	                .withDiallegada(cal.getTime());

	        RegistroVehiculo registroVehiculo = registrar.build();

	        ServicioCrearRegistro servicioCrearRegistro = new ServicioCrearRegistro(puertoRepositorioRegistro);
	        ServicioSalidaRegistro servicioSalidaRegistro = new ServicioSalidaRegistro(puertoRepositorioRegistro);
	        when(puertoRepositorioRegistro.findByPlaca(registroVehiculo.getPlaca())).thenReturn(registroVehiculo);

	        //Act
	        servicioSalidaRegistro.salida(registroVehiculo.getPlaca());

	        //Assert
	        assertEquals((valorHora * hora),registroVehiculo.getValor(),0);

	    }

	 @Test
	    public void  RegistroPruebahoraCargaMoto() {
	        //Arrange
	        int valorHora = 500;
	        int hora = 6;
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(new Date());

	        cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) - hora);

	        RegistroTestDataBuilder registrar = new RegistroTestDataBuilder()
	                .withTipovehiculo(RespuestaSistema.TIPO_VEHICULO_VALUE_MOTO)
	                .withDiallegada(cal.getTime())
	                .withCilindraje(500);

	        RegistroVehiculo registroVehiculo = registrar.build();

	        ServicioCrearRegistro servicioCrearRegistro = new ServicioCrearRegistro(puertoRepositorioRegistro);
	        ServicioSalidaRegistro servicioSalidaRegistro = new ServicioSalidaRegistro(puertoRepositorioRegistro);
	        when(puertoRepositorioRegistro.findByPlaca(registroVehiculo.getPlaca())).thenReturn(registroVehiculo);

	        //Act
	        servicioSalidaRegistro.salida(registroVehiculo.getPlaca());

	        //Assert
	        assertEquals((valorHora * hora),registroVehiculo.getValor(),0);

	    }
	 @Test
	    public void  RegistrarHorasCargaMaximoMotoTest() {
	        //Arrange
	        int valorHora = 500;
	        int hora = 6;
	        int valorAdicional = 2000;

	        Calendar cal = Calendar.getInstance();
	        cal.setTime(new Date());

	        cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) - hora);

	        RegistroTestDataBuilder registrar = new RegistroTestDataBuilder()
	                .withTipovehiculo(RespuestaSistema.TIPO_VEHICULO_VALUE_MOTO)
	                .withDiallegada(cal.getTime())
	                .withCilindraje(600);

	        RegistroVehiculo registroVehiculo = registrar.build();

	        ServicioCrearRegistro servicioCrearRegistro = new ServicioCrearRegistro(puertoRepositorioRegistro);
	        ServicioSalidaRegistro servicioSalidaRegistro = new ServicioSalidaRegistro(puertoRepositorioRegistro);
	        when(puertoRepositorioRegistro.findByPlaca(registroVehiculo.getPlaca())).thenReturn(registroVehiculo);

	        //Act
	        servicioSalidaRegistro.salida(registroVehiculo.getPlaca());

	        //Assert
	        assertEquals((hora*valorHora)+valorAdicional,registroVehiculo.getValor(),0);

	    }

	 
	 @Test
	    public void  RegistrarDiaCargo() {
	        //Arrange
	        int valorDia = 8000;
	        int hora = 9;
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(new Date());

	        cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) - hora);

	        RegistroTestDataBuilder registrar = new RegistroTestDataBuilder()
	                .withTipovehiculo(RespuestaSistema.TIPO_VEHICULO_VALUE_CARRO)
	                .withDiallegada(cal.getTime());

	        RegistroVehiculo registroVehiculo = registrar.build();

	        ServicioCrearRegistro servicioCrearRegistro = new ServicioCrearRegistro(puertoRepositorioRegistro);
	        ServicioSalidaRegistro servicioSalidaRegistro = new ServicioSalidaRegistro(puertoRepositorioRegistro);
	        when(puertoRepositorioRegistro.findByPlaca(registroVehiculo.getPlaca())).thenReturn(registroVehiculo);

	        //Act
	        servicioSalidaRegistro.salida(registroVehiculo.getPlaca());

	        //Assert
	        assertEquals(valorDia,registroVehiculo.getValor(),0);

	    }
	 
	 
	 @Test
	    public void  RegistrarDiaCargaCilindrajeMaximoMotoTest() {
	        //Arrange
	        int valorDia = 4000;
	        int hora = 9;
	        int valarAdicional = 2000;

	        Calendar cal = Calendar.getInstance();
	        cal.setTime(new Date());

	        cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) - hora);

	        RegistroTestDataBuilder registrar = new RegistroTestDataBuilder()
	                .withTipovehiculo(RespuestaSistema.TIPO_VEHICULO_VALUE_MOTO)
	                .withDiallegada(cal.getTime())
	                .withCilindraje(600);

	        RegistroVehiculo registroVehiculo = registrar.build();

	        ServicioCrearRegistro servicioCrearRegistro = new ServicioCrearRegistro(puertoRepositorioRegistro);
	        ServicioSalidaRegistro servicioSalidaRegistro = new ServicioSalidaRegistro(puertoRepositorioRegistro);
	        when(puertoRepositorioRegistro.findByPlaca(registroVehiculo.getPlaca())).thenReturn(registroVehiculo);

	        //Act
	        servicioSalidaRegistro.salida(registroVehiculo.getPlaca());

	        //Assert
	        assertEquals(valorDia + valarAdicional,registroVehiculo.getValor(),0);

	    }
	 
	  @Test
	    public void RegistraDiaCargaMotoPrueba() {
	        //Arrange
	        int valorDia = 4000;
	        int hora = 9;

	        Calendar cal = Calendar.getInstance();
	        cal.setTime(new Date());

	        cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) - hora);

	        RegistroTestDataBuilder registrar = new RegistroTestDataBuilder()
	        		.withTipovehiculo(RespuestaSistema.TIPO_VEHICULO_VALUE_MOTO)
	                .withDiallegada(cal.getTime())
	                .withCilindraje(500);

	        RegistroVehiculo registroVehiculo = registrar.build();

	        ServicioCrearRegistro servicioCrearRegistro = new ServicioCrearRegistro(puertoRepositorioRegistro);
	        ServicioSalidaRegistro servicioSalidaRegistro = new ServicioSalidaRegistro(puertoRepositorioRegistro);
	        when(puertoRepositorioRegistro.findByPlaca(registroVehiculo.getPlaca())).thenReturn(registroVehiculo);

	        //Act
	        servicioSalidaRegistro.salida(registroVehiculo.getPlaca());

	        //Assert
	        assertEquals(valorDia,registroVehiculo.getValor(),0);

	    }
	 
	 
	 
	 
	  @Test
	    public void  RegistrarDiaMasHoraCarro() {
	        //Arrange
	        int valorDia = 8000;
	        int valorHora = 1000;
	        int hora = 27;
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(new Date());

	        cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) - hora);

	        RegistroTestDataBuilder registrar = new RegistroTestDataBuilder()
	                .withTipovehiculo(RespuestaSistema.TIPO_VEHICULO_VALUE_CARRO)
	                .withDiallegada(cal.getTime());

	        RegistroVehiculo registroVehiculo = registrar.build();

	        ServicioCrearRegistro servicioCrearRegistro = new ServicioCrearRegistro(puertoRepositorioRegistro);
	        ServicioSalidaRegistro servicioSalidaRegistro = new ServicioSalidaRegistro(puertoRepositorioRegistro);
	        when(puertoRepositorioRegistro.findByPlaca(registroVehiculo.getPlaca())).thenReturn(registroVehiculo);

	        //Act
	        servicioSalidaRegistro.salida(registroVehiculo.getPlaca());

	        //Assert
	       
	        assertEquals((valorHora * 3) + valorDia,registroVehiculo.getValor(),0);

	    }
	  
	  

	    @Test
	    public void RegistrarDiaMasHoraMoto() {
	        //Arrange
	        int valorDia = 4000;
	        int valorHora = 500;
	        int hour = 27;

	        Calendar cal = Calendar.getInstance();
	        cal.setTime(new Date());

	        cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) - hour);

	        RegistroTestDataBuilder registrar = new RegistroTestDataBuilder()
	                .withTipovehiculo(RespuestaSistema.TIPO_VEHICULO_VALUE_MOTO)
	                .withDiallegada(cal.getTime())
	                .withCilindraje(400);

	        RegistroVehiculo registroVehiculo = registrar.build();

	        ServicioCrearRegistro servicioCrearRegistro = new ServicioCrearRegistro(puertoRepositorioRegistro);
	        ServicioSalidaRegistro servicioSalidaRegistro = new ServicioSalidaRegistro(puertoRepositorioRegistro);
	        when(puertoRepositorioRegistro.findByPlaca(registroVehiculo.getPlaca())).thenReturn(registroVehiculo);

	        //Act
	        servicioSalidaRegistro.salida(registroVehiculo.getPlaca());

	        //Assert
	        assertEquals((valorHora * 3) + valorDia,registroVehiculo.getValor(),0);

	    }
	  
	    
	    
	    
	    
	  
	
	
	
	@Test
	 public void  EstacionamientoSinEspacioPruebaCarro(){
		 RegistroTestDataBuilder registrar = new RegistroTestDataBuilder().withTipovehiculo(RespuestaSistema.TIPO_VEHICULO_VALUE_CARRO);
		 
		 RegistroVehiculo  registroVehiculo = registrar.build();
		 
		 ServicioCrearRegistro servicioCrearRegistro = new  ServicioCrearRegistro(puertoRepositorioRegistro);
		 
		 when(puertoRepositorioRegistro.cantidadVehiculo(RespuestaSistema.TIPO_VEHICULO_VALUE_CARRO)).thenReturn(20);
	 
		 try {
			 servicioCrearRegistro.EntradaEstabelcida(registroVehiculo);;
	            fail();
	        }catch (ExcepcionNoEspacioTipoVehiculo ex){
	            // Assert
	            assertEquals(String.format(RespuestaSistema.MESAJES_NO_HAY_ESPACIO_DISPONIBLE, RespuestaSistema.TIPO_VEHICULO_VALUE_CARRO), ex.getMessage());
	        }
	    }
	 
	@Test
	 public void AparcamientoSinEspacioPruebaMotos() {
		 RegistroTestDataBuilder  registrar = new RegistroTestDataBuilder().withTipovehiculo(RespuestaSistema.TIPO_VEHICULO_VALUE_MOTO).withCilindraje(500);
		 
		 RegistroVehiculo registroVehiculo= registrar.build();
		 ServicioCrearRegistro servicioCrearRegistro = new  ServicioCrearRegistro(puertoRepositorioRegistro);
		 when(puertoRepositorioRegistro.cantidadVehiculo(RespuestaSistema.TIPO_VEHICULO_VALUE_MOTO)).thenReturn(10);
		 
		 try {
			 servicioCrearRegistro.EntradaEstabelcida(registroVehiculo);;
	            //fail();
	        }catch (ExcepcionNoEspacioTipoVehiculo ex){
	            // Assert
	            assertEquals(String.format(RespuestaSistema.MESAJES_NO_HAY_ESPACIO_DISPONIBLE, RespuestaSistema.TIPO_VEHICULO_VALUE_MOTO), ex.getMessage());
	        } 
	 }
	
	@Test
	public void NodejesEntrarAlosVehiculoPorA() {
		 Calendar dateArrival =Calendar.getInstance();
		 RegistroTestDataBuilder  registrar = new RegistroTestDataBuilder().withPlaca("B123").withDiallegada(dateArrival.getTime());
		 RegistroVehiculo registroVehiculo= registrar.build();
		 ServicioCrearRegistro servicioCrearRegistro = new  ServicioCrearRegistro(puertoRepositorioRegistro);
		 
		 try {
			 servicioCrearRegistro.EntradaEstabelcida(registroVehiculo);;
	            //fail();
	        }catch (ExcepcionLicenciaLugarFecha ex){
	            // Assert
	            assertEquals(String.format(RespuestaSistema.MENSAJES_DIAS_NO_PERMITIDO), ex.getMessage());
	        } 
		 
	}
	
	
	
	
	
	
 }

