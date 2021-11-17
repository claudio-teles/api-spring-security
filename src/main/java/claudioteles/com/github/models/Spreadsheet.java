package claudioteles.com.github.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table(name = "SPREADSHEET") @NoArgsConstructor @AllArgsConstructor @Data @Builder
public class Spreadsheet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6670805764917184560L;
	
	@Id
	@GeneratedValue(generator = "spreadsheet_id_generator", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "spreadsheet_id_generator", sequenceName = "spreadsheet_sequence_generator", initialValue = 30, allocationSize = 1)
	private Long id;
	@Column(length = 40, nullable = false)
	private String name;
	@Lob
	@Column(nullable = false)
	private byte[] data;

}
