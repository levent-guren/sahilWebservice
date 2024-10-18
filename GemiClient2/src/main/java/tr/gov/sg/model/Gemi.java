package tr.gov.sg.model;

import java.util.List;

import lombok.Data;

@Data
public class Gemi {
	private String adi;
	private String tipi;
	private int hizmeteBaslamaYili;
	private String birlikAdi;
	private List<Kaptan> kaptanlar;
}