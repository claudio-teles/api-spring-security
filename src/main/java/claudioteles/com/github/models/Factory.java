package claudioteles.com.github.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table(name = "FACTORIES") @NoArgsConstructor @AllArgsConstructor @Data @Builder
public class Factory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7527996619514716950L;
	
	@Id
	@GeneratedValue(generator = "factory_id_generator", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "factory_id_generator", sequenceName = "factory_sequence_generator", initialValue = 30, allocationSize = 1)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NAME", length = 20, nullable = false)
	private String name;
	@Column(name = "COUNTRY_CODE", nullable = false)
	private Short countryCode;

}
