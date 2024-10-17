package tr.gov.sg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
	private String date;
	private String day;
	private String icon;
	private String description;
	private String status;
	private String degree;
	private String min;
	private String max;
	private String night;
	private String humidity;
}