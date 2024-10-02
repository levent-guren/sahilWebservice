package tr.gov.sg.dto.birlik;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BirlikEkleGuncelleResponseDTO {
	private long id;
	private String adi;
	private String il;
}
