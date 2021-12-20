package uc.us_security.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_pedido_oracion")
public class Pedido_Oracion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_pedido;
	@Column(name="respuesta")
	private String respuesta;
	@Column(name="oracion")
	private String oracion;
	@Column(name="F_pedido")
	private Date F_pedido;
	@Column(name="f_respuesta")
	private Date f_respuesta;
	@Column(name="estado")
	private String estado;
	

	
	//relacion de 1 a 1 con pedido_oracion ,de beneficiario a pedido_oracion
//			@OneToOne(cascade = CascadeType.MERGE)
//			@JoinColumn(name = "id_beneficiario", referencedColumnName = "id_beneficiario")
//			private Beneficiario beneficiario;
	@ManyToOne()
	@JoinColumn(name = "id_beneficiario")
	  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Beneficiario beneficiario;
	
	
			
			//relacionde de uno a muchos de admi a pedido_oracion
//			
//			@ManyToOne()
//			@JoinColumn(name = "id_admi")
//			private Admi admi;

}
