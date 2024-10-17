package tr.gov.sg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personel {
	private long id;
	private String adi;
	private String soyadi;
}
