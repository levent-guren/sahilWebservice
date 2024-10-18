package tr.gov.sg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "birlik")
@EqualsAndHashCode(exclude = "birlik")
public class Gemi {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEMI_ID_SEQ")
	@SequenceGenerator(name = "GEMI_ID_SEQ", sequenceName = "GEMI_ID_SEQ", allocationSize = 1)
	private long id;

	private String adi;
	private String tipi;
	@Column(name = "HIZMETE_BASLAMA_YILI")
	private Integer hizmeteBaslamaYili;
	@ManyToOne
	private Birlik birlik;
}
