package tr.gov.sg.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@ToString(exclude = "gemiler")
@EqualsAndHashCode(exclude = "gemiler")
public class Birlik {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BIRLIK_ID_SEQ")
	@SequenceGenerator(name = "BIRLIK_ID_SEQ", sequenceName = "BIRLIK_ID_SEQ", allocationSize = 1)
	private long id;

	private String adi;
	private String il;

	@OneToMany(mappedBy = "birlik")
	private List<Gemi> gemiler;
}
