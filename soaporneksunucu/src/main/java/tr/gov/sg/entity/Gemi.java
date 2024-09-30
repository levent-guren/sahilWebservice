package tr.gov.sg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gemi {
	@Id
	private long id;
	private String adi;
	private String tipi;
	@Column(name = "hizmete_baslama_yili")
	private int hizmeteBaslamaYili;
}
