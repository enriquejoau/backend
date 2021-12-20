package uc.us_security.entity;



//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_persona")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_persona")
	private int idpersona;
	@Column(name="nombre")
	private String nombre;
	@Column(name="p_apellidos")
	private String p_apellidos;
	@Column(name="m_apellidos")
	private String m_apellidos;
	@Column(name="dni")
	private int dni;
	@Column(name="correo")
	private String correo;
	@Column(name="telefono")
	private int telefono;
	@Column(name="estado")
	private String estado;

}
