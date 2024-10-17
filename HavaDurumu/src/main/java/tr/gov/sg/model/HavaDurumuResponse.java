package tr.gov.sg.model;

import lombok.Data;

@Data
public class HavaDurumuResponse {
	private String date;
	private String day;
	private String description;
	private int degree;
	private String humidity;
}
