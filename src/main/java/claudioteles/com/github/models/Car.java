package claudioteles.com.github.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import claudioteles.com.github.enumarations.Fuel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table(name = "CARS") @NoArgsConstructor @AllArgsConstructor @Data @Builder
public class Car implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6568285229878279858L;
	
	@Id
	@GeneratedValue(generator = "cars_id_generator", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "cars_id_generator", sequenceName = "cars_sequence_generator", initialValue = 30, allocationSize = 1)
	@Column(name = "ID")
	private Long id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(foreignKey = @ForeignKey(name="FACTORIES_ID_FK"), nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Factory factoryId;
	@Column(name = "MODEL", length = 20, nullable = false)
	private String model;
	@Column(name = "YEAR", nullable = false)
	private Short year;
	@Column(name = "FUEL", nullable = false)
	private Fuel fuel;
	@Column(name = "DOORS", nullable = false)
	private Short doors;
	@Column(name = "COST", nullable = false)
	private Float cost;
	@Column(name = "COLOR", length = 20, nullable = false)
	private String color;

}
