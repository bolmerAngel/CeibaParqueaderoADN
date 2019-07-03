package co.com.ceiba.adnparqueadero.parqueadero.servicio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones.ExcepcionDuplicada;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones.ExcepcionLicenciaLugarFecha;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones.ExcepcionNoEspacioTipoVehiculo;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones.ExcepcionNoExisteRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.mensajes.MensageSistema;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.Registro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.puerto.IRepositorioRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.CrearRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.ServicioExisteRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.testdatabuilder.RegistroTestDataBuilder;





public class ServicioTest {
	
	private IRepositorioRegistro  puertoRepositorioRegistro;

	@Before
	public void InicioMocks() {
		puertoRepositorioRegistro = mock(IRepositorioRegistro.class);
	}
	
	 @Test
	 public void  RegistroCarroTest() {
		 RegistroTestDataBuilder registrar = new RegistroTestDataBuilder()
	                .withTipovehiculo(MensageSistema.TIPO_VEHICULO_VALUE_CARRO);
		 
		 Registro registro = registrar.build();

		 CrearRegistro  crearRegistro  = new CrearRegistro (puertoRepositorioRegistro);

	     when(puertoRepositorioRegistro.Regitrar(registro)).thenReturn(registro);

	        //Act
	        Registro registerCopia = crearRegistro.EntradaEstabelcida(registro);

	        //Assert
	        assertEquals(registerCopia.getIdvehiculo(),registro.getIdvehiculo());

		 
	 }
	
	
	 @Test
	    public void  RegistroMotoTest(){
	        //Arrange
		 RegistroTestDataBuilder registrar = new RegistroTestDataBuilder()
				 .withTipovehiculo(MensageSistema.TIPO_VEHICULO_VALUE_MOTO);
		 			
		 

	        Registro registro = registrar.build();

	        CrearRegistro crearRegistro = new CrearRegistro(puertoRepositorioRegistro);

	        when(puertoRepositorioRegistro.Regitrar(registro)).thenReturn(registro);

	        //Act
	        Registro registerCopia = crearRegistro.EntradaEstabelcida(registro);

	        //Assert
	        assertEquals(registerCopia.getIdvehiculo(),registro.getIdvehiculo());
	    }
	
	
	 @Test
	    public void  VehículoExistePrueba(){
		 RegistroTestDataBuilder registrar = new RegistroTestDataBuilder()
	                .withTipovehiculo(MensageSistema.TIPO_VEHICULO_VALUE_CARRO);

	        Registro registro = registrar.build();

	        CrearRegistro crearRegistro = new CrearRegistro(puertoRepositorioRegistro);

	        when(puertoRepositorioRegistro.Regitrar(registro)).thenReturn(registro);

	        //Act
	        try {
	        	 crearRegistro.EntradaEstabelcida(registro);
	        }catch (ExcepcionDuplicada ex){
	            // Assert
	            assertEquals(MensageSistema.MENSAJE_YA_EXISTE_VEHICULO, ex.getMessage());
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
	                .withTipovehiculo(MensageSistema.TIPO_VEHICULO_VALUE_CARRO)
	                .withDiallegada(cal.getTime());

	        Registro registro = registrar.build();

	        CrearRegistro crearRegistro = new CrearRegistro(puertoRepositorioRegistro);
	        ServicioExisteRegistro servicioExisteRegistro = new ServicioExisteRegistro(puertoRepositorioRegistro);
	        when(puertoRepositorioRegistro.findByPlaca(registro.getPlaca())).thenReturn(registro);

	        //Act
	        servicioExisteRegistro.salida(registro.getPlaca());

	        //Assert
	        assertEquals((valorHora * hora),registro.getValor(),0);

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
	                .withTipovehiculo(MensageSistema.TIPO_VEHICULO_VALUE_MOTO)
	                .withDiallegada(cal.getTime())
	                .withCilindraje(500);

	        Registro registro = registrar.build();

	        CrearRegistro crearRegistro = new CrearRegistro(puertoRepositorioRegistro);
	        ServicioExisteRegistro servicioExisteRegistro = new ServicioExisteRegistro(puertoRepositorioRegistro);
	        when(puertoRepositorioRegistro.findByPlaca(registro.getPlaca())).thenReturn(registro);

	        //Act
	        servicioExisteRegistro.salida(registro.getPlaca());

	        //Assert
	        assertEquals((valorHora * hora),registro.getValor(),0);

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
	                .withTipovehiculo(MensageSistema.TIPO_VEHICULO_VALUE_MOTO)
	                .withDiallegada(cal.getTime())
	                .withCilindraje(600);

	        Registro registro = registrar.build();

	        CrearRegistro crearRegistro = new CrearRegistro(puertoRepositorioRegistro);
	        ServicioExisteRegistro servicioExisteRegistro = new ServicioExisteRegistro(puertoRepositorioRegistro);
	        when(puertoRepositorioRegistro.findByPlaca(registro.getPlaca())).thenReturn(registro);

	        //Act
	        servicioExisteRegistro.salida(registro.getPlaca());

	        //Assert
	        assertEquals((hora*valorHora)+valorAdicional,registro.getValor(),0);

	    }

	 
	 @Test
	    public void  RegistrarDíaCargo() {
	        //Arrange
	        int valorDia = 8000;
	        int hora = 9;
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(new Date());

	        cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) - hora);

	        RegistroTestDataBuilder registrar = new RegistroTestDataBuilder()
	                .withTipovehiculo(MensageSistema.TIPO_VEHICULO_VALUE_CARRO)
	                .withDiallegada(cal.getTime());

	        Registro registro = registrar.build();

	        CrearRegistro crearRegistro = new CrearRegistro(puertoRepositorioRegistro);
	        ServicioExisteRegistro servicioExisteRegistro = new ServicioExisteRegistro(puertoRepositorioRegistro);
	        when(puertoRepositorioRegistro.findByPlaca(registro.getPlaca())).thenReturn(registro);

	        //Act
	        servicioExisteRegistro.salida(registro.getPlaca());

	        //Assert
	        assertEquals(valorDia,registro.getValor(),0);

	    }
	 
	 
	 
	 
	
	
	
	@Test
	 public void  EstacionamientoSinEspacioPruebaCarro(){
		 RegistroTestDataBuilder registrar = new RegistroTestDataBuilder().withTipovehiculo(MensageSistema.TIPO_VEHICULO_VALUE_CARRO);
		 
		 Registro  registro = registrar.build();
		 
		 CrearRegistro crearRegistro = new  CrearRegistro(puertoRepositorioRegistro);
		 
		 when(puertoRepositorioRegistro.cantidadVehiculo(MensageSistema.TIPO_VEHICULO_VALUE_CARRO)).thenReturn(20);
	 
		 try {
			 crearRegistro.EntradaEstabelcida(registro);;
	            fail();
	        }catch (ExcepcionNoEspacioTipoVehiculo ex){
	            // Assert
	            assertEquals(String.format(MensageSistema.MESAJES_NO_HAY_ESPACIO_DISPONIBLE, MensageSistema.TIPO_VEHICULO_VALUE_CARRO), ex.getMessage());
	        }
	    }
	 
	@Test
	 public void AparcamientoSinEspacioPruebaMotos() {
		 RegistroTestDataBuilder  registrar = new RegistroTestDataBuilder().withTipovehiculo(MensageSistema.TIPO_VEHICULO_VALUE_MOTO).withCilindraje(500);
		 
		 Registro registro= registrar.build();
		 CrearRegistro crearRegistro = new  CrearRegistro(puertoRepositorioRegistro);
		 when(puertoRepositorioRegistro.cantidadVehiculo(MensageSistema.TIPO_VEHICULO_VALUE_MOTO)).thenReturn(10);
		 
		 try {
			 crearRegistro.EntradaEstabelcida(registro);;
	            //fail();
	        }catch (ExcepcionNoEspacioTipoVehiculo ex){
	            // Assert
	            assertEquals(String.format(MensageSistema.MESAJES_NO_HAY_ESPACIO_DISPONIBLE, MensageSistema.TIPO_VEHICULO_VALUE_MOTO), ex.getMessage());
	        } 
	 }
	
	@Test
	public void NodejesEntrarAlosVehiculoPorA() {
		 Calendar dateArrival =Calendar.getInstance();
		 RegistroTestDataBuilder  registrar = new RegistroTestDataBuilder().withPlaca("B123").withDiallegada(dateArrival.getTime());
		 Registro registro= registrar.build();
		 CrearRegistro crearRegistro = new  CrearRegistro(puertoRepositorioRegistro);
		 
		 try {
			 crearRegistro.EntradaEstabelcida(registro);;
	            //fail();
	        }catch (ExcepcionLicenciaLugarFecha ex){
	            // Assert
	            assertEquals(String.format(MensageSistema.MENSAJES_DIAS_NO_PERMITIDO), ex.getMessage());
	        } 
		 
	}
	
	
	
	
	
	
 }

