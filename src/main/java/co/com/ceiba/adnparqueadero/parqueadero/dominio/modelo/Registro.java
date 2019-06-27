package co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo;

import java.util.Date;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones.ValidatorAgument;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones.ValidatorArgument;


public class Registro {

    private static final String MESAGE_PLACA_REQUERIDO= "La placa es un dato requerido.";
    private static final String MENSAGE_TIPO_VEHUCULO_REGUERIDO = "El tipo de vehiculo es un dato requerido.";
    private static final String MENSAGE_TIPO_VEHICULO_INFORMACIÓN_INCORRECTA= "El campo tipo vehiculo no tiene valor (%S) valido.";
    private static final String MESAGE_CILINDRAJE_REQUERIDO = "El campo cilindraje es requerido.";
    private static final String MESSAGE_CILINDRAJE_INFORMACIÓN_INCORRECTA  = "El campo cilindraje debe ser numerico.";
    private static final String MESSAGE_VALOR_WRONG_DATA  = "El campo valor debe ser numerico.";
    
    private static final String TIPO_VEHICULO_VALUE_CARRO = "CARRO";
    private static final String TIPO_VEHICULO_VALUE_MOTO = "MOTO";

	private Integer idvehiculo;
	private String placa;
	private Date diallegada;
	private Date diasalida;
	private Integer cilindraje;
	private Integer valor;
	private String tipovehiculo;
	
	public Registro(Integer idvehiculo, String placa, Date diallegada, Date diasalida, Integer cilindraje, Integer valor, String tipo_vehiculo) {
		ValidarArgumento.validarPlacaNoNull(placa, MESAGE_PLACA_REQUERIDO);
		ValidarArgumento.validarTipovehiculoNoNull(tipovehiculo,MENSAGE_TIPO_VEHUCULO_REGUERIDO);
		ValidarArgumento.validarTipovehiculoValorNoNull(tipovehiculo, MENSAGE_TIPO_VEHICULO_INFORMACIÓN_INCORRECTA);
		
		if(!placa.contains(TIPO_VEHICULO_VALUE_CARRO) && !placa.contains(TIPO_VEHICULO_VALUE_MOTO)) {
			ValidatorArgument.validarPlacaWrongDate(String.format(MESSAGE_CILINDRAJE_INFORMACIÓN_INCORRECTA , placa));
			
		}
		if(placa.equalsIgnoreCase(TIPO_VEHICULO_VALUE_MOTO)){
			ValidatorAgument.validarCilindrajeRequired(MESAGE_CILINDRAJE_REQUERIDO ,cilindraje);
			
			
		}
		
		
		this.idvehiculo = idvehiculo;
		this.placa = placa;
		this.diallegada = diallegada;
		this.diasalida= diasalida;
		this.cilindraje = cilindraje;
		this.valor = valor;
		this.tipovehiculo = tipo_vehiculo;
	}
		
	
	/**
	 * @return the id_vehiculo
	 */
	public long getIdvehiculo() {
		return idvehiculo;
	}
	/**
	 * @param id_vehiculo the id_vehiculo to set
	 */
	public void setIdvehiculo(Integer idvehiculo) {
		this.idvehiculo = idvehiculo;
	}
	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}
	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/**
	 * @return the hora_llegada
	 */
	public Date getDiallegada() {
		return diallegada;
	}
	/**
	 * @param hora_llegada the hora_llegada to set
	 */
	public void setDiallegada(Date diallegada) {
		this.diallegada = diallegada;
	}
	/**
	 * @return the hora_salida
	 */
	public Date getDiasalida() {
		return diasalida;
	}
	/**
	 * @param hora_salida the hora_salida to set
	 */
	public void setDiasalida(Date diasalida) {
		this.diasalida = diasalida;
	}

	/**
	 * @return the cilindraje
	 */
	public Integer getCilindraje() {
		return cilindraje;
	}

	/**
	 * @param cilindraje the cilindraje to set
	 */
	public void setCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
	}
	/**
	 * @return the valor
	 */
	public Integer getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	/**
	 * @return the tipo_vehiculo
	 */
	public String getTipovehiculo() {
		return tipovehiculo;
	}
	/**
	 * @param tipo_vehiculo the tipo_vehiculo to set
	 */
	public void setTipovehiculo(String tipo_vehiculo) {
		this.tipovehiculo = tipo_vehiculo;
	}
	
}

