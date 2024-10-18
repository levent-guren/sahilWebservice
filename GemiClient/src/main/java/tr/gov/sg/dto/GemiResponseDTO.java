package tr.gov.sg.dto;

import java.util.List;

import lombok.Data;
import tr.gov.sg.model.Gemi;

@Data
public class GemiResponseDTO {
	private String adi;
	private String tipi;
	private int hizmeteBaslamaYili;
	private String birlikAdi;

	public static List<GemiResponseDTO> fromGemiList(List<Gemi> gemiler) {
		return gemiler.stream().map(GemiResponseDTO::donustur).toList();
	}

	private static GemiResponseDTO donustur(Gemi gemi) {
		GemiResponseDTO gemiResponseDTO = new GemiResponseDTO();
		gemiResponseDTO.setAdi(gemi.getAdi());
		gemiResponseDTO.setTipi(gemi.getTipi());
		gemiResponseDTO.setHizmeteBaslamaYili(gemi.getHizmeteBaslamaYili());
		gemiResponseDTO.setBirlikAdi(gemi.getBirlikAdi());
		return gemiResponseDTO;
	}

}
