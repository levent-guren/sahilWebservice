package tr.gov.sg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.gov.sg.entity.Birlik;
import tr.gov.sg.repository.BirlikRepository;

@Service
public class BirlikService {
	@Autowired
	private BirlikRepository birlikRepository;

	public List<Birlik> getTumBirlikler() {
		return birlikRepository.findAll();
	}

	public Optional<Birlik> getBirlikById(long id) {
		return birlikRepository.findById(id);
	}

	public Birlik birlikEkleGuncelle(Birlik birlik) {
		return birlikRepository.save(birlik);
	}

	public void birlikSil(long id) {
		birlikRepository.deleteById(id);
	}
}
