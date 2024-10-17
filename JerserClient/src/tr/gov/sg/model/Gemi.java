package tr.gov.sg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gemi {
	private String adi;
	private String tipi;
	private double uzunluk;
}
