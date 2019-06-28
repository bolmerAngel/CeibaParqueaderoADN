package co.com.ceiba.adnparqueadero.parqueadero.infraestructura.entida;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
//import java.util.Date;


@Entity
@Table(name = "Registro")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegistroEntida {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 
	 @Column
	 private Integer idvehiculo;
	 
	 @Column
	 private String placa;
	 
	 @Column
	 private String desplasamineto;
	 
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
	
}
