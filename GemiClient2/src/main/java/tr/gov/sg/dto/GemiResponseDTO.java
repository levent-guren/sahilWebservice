package tr.gov.sg.dto;

import java.util.List;

import lombok.Data;
import tr.gov.sg.model.Gemi;
import tr.gov.sg.model.Kaptan;

@Data
public class GemiResponseDTO {
	private String adi;
	private String tipi;
	private int hizmeteBaslamaYili;
	private String birlikAdi;
	private List<KaptanResponseDTO> kaptanlar;

	public static List<GemiResponseDTO> fromGemiList(List<Gemi> gemiler) {
		return gemiler.stream().map(GemiResponseDTO::donusturGemi).toList();
	}

	public static List<KaptanResponseDTO> fromKaptanList(List<Kaptan> kaptanlar) {
		return kaptanlar.stream().map(GemiResponseDTO::donusturKaptan).toList();
	}

	private static GemiResponseDTO donusturGemi(Gemi gemi) {
		GemiResponseDTO gemiResponseDTO = new GemiResponseDTO();
		gemiResponseDTO.setAdi(gemi.getAdi());
		gemiResponseDTO.setTipi(gemi.getTipi());
		gemiResponseDTO.setHizmeteBaslamaYili(gemi.getHizmeteBaslamaYili());
		gemiResponseDTO.setBirlikAdi(gemi.getBirlikAdi());
		gemiResponseDTO.setKaptanlar(fromKaptanList(gemi.getKaptanlar()));
		return gemiResponseDTO;
	}

	private static KaptanResponseDTO donusturKaptan(Kaptan kaptan) {
		KaptanResponseDTO kaptanResponseDTO = new KaptanResponseDTO();
		kaptanResponseDTO.setAdi(kaptan.getAdi());
		return kaptanResponseDTO;
	}

}
