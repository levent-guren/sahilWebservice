package tr.gov.sg.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Root{
	private boolean success;
	private String city;
	private ArrayList<Result> result;
} 