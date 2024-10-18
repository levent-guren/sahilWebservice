package tr.gov.sg.dto.gemi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GemiResponseDTO {
	private String adi;
	private String tipi;
	private int hizmeteBaslamaYili;
	private String birlikAdi;
}
