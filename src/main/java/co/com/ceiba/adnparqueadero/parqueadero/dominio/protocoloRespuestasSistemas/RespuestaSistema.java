package co.com.ceiba.adnparqueadero.parqueadero.dominio.protocolorespuestassistemas;

public  final class RespuestaSistema {

	
	public static final String MENSAJES_PLACAS_RESTRINGIDAS_QUE_COMENZAN_CON_LA_LETRA = "A";
    public static final String MENSAJES_DIAS_NO_PERMITIDO = "El vehiculo no esta autorizado a ingresar.";
    public static final String MESAJES_NO_HAY_ESPACIO_DISPONIBLE = "En este momento no hay cupo para el tipo de vehiculo %S";
    public static final String MESAJE_VEHICULO_NO_ENCONTRADO = "El vehiculo no se encuentra en el parqueadero";
    public static final String MENSAJE_YA_EXISTE_VEHICULO = "El vehiculo ya ha ingresado";
    
   public static final String MENSAGE_CILINDRAJE_INFORMACION_INCORRECTA  = "El campo cilindraje debe ser numerico.";
    public static final String MENSAGE_TIPO_VEHICULO_INFORMACION_INCORRECTA= "El campo tipo vehiculo no tiene valor (%S) valido.";
    

    public  static final String TIPO_VEHICULO_VALUE_CARRO = "CARRO";
    public static final String TIPO_VEHICULO_VALUE_MOTO = "MOTO";
    
    
    public static final int TIPO_VEHICULO_MAXIMO_CARRO = 20;
    public static final int TIPO_VEHICULO_MAXIMO_MOTO = 10;

    private RespuestaSistema() {}
}
