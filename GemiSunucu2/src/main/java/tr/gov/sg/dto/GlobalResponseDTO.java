package tr.gov.sg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalResponseDTO {
	private String status = "success";
	private String message;
	private int code;
}
