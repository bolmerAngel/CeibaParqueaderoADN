package co.com.ceiba.adnparqueadero.parqueadero.infraestructura.entida;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.Getter;


@Entity
@Table(name = "RegistroEntida")
@Getter


public class RegistroEntida {
	
	
	public  RegistroEntida(){
		
	}
	
	 public RegistroEntida( Integer idvehiculo, String placa, Date diallegada, Date diasalida,
			Integer cilindraje, Integer valor, String tipovehiculo) {
		this.idvehiculo = idvehiculo;
		this.placa = placa;
		this.diallegada = diallegada;
		this.diasalida = diasalida;
		this.cilindraje = cilindraje;
		this.valor = valor;
		this.tipovehiculo = tipovehiculo;
	}

	@Id
	 @TableGenerator(name = "nameRegister", initialValue = 1)
	 @GeneratedValue(strategy = GenerationType.AUTO , generator  = "nameRegister")
	 @Column
	 private Integer idvehiculo;
	 
	 @Column
	 private String placa;
	 
	
	 @Column 
	 private Date diallegada;
	 
	 @Column
	 private Date diasalida;
	 
	 @Column
	 private Integer cilindraje;
	 
	 @Column
	 private Integer valor;
	 
	 @Column
	 private String tipovehiculo;

	/**
	 * @param idvehiculo the idvehiculo to set
	 */
	public void setIdvehiculo(Integer idvehiculo) {
		this.idvehiculo = idvehiculo;
	}

	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}



	/**
	 * @param diallegada the diallegada to set
	 */
	public void setDiallegada(Date diallegada) {
		this.diallegada = diallegada;
	}

	/**
	 * @param diasalida the diasalida to set
	 */
	public void setDiasalida(Date diasalida) {
		this.diasalida = diasalida;
	}

	/**
	 * @param cilindraje the cilindraje to set
	 */
	public void setCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Integer valor) {
		this.valor = valor;
	}

	/**
	 * @param tipovehiculo the tipovehiculo to set
	 */
	public void setTipovehiculo(String tipovehiculo) {
		this.tipovehiculo = tipovehiculo;
	}
	
	 
	 
}
