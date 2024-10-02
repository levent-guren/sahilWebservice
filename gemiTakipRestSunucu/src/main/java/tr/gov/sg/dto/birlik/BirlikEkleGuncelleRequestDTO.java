package tr.gov.sg.dto.birlik;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BirlikEkleGuncelleRequestDTO {
	private Long id;
	private String adi;
	private String il;
}
