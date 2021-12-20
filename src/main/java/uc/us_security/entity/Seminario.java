package uc.us_security.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_seminario")
public class Seminario  {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_seminario")
	int id_seminario;
	@Column(name="fe_fecha_inicio")
	Date fecha_inicio;
	@Column(name="fe_fecha_fin")
	Date fecha_fin;
	@Column(name="url_link")
	String url;
	@Column(name="no_seminario")
	String nombre;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "seminario")
	private List<Asistencia> asistencia = new ArrayList<>();
}
