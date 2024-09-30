package tr.gov.sg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.gov.sg.entity.Gemi;
import tr.gov.sg.repository.GemiRepository;

@Service
public class GemiService {
	@Autowired
	private GemiRepository gemiRepository;

	public Optional<Gemi> getGemi(long id) {
		return gemiRepository.findById(id);
	}
}
