package tr.gov.sg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.gov.sg.entity.Gemi;
import tr.gov.sg.repository.GemiRepository;

@Service
public class GemiService {
	@Autowired
	private GemiRepository gemiRepository;

	public List<Gemi> getTumGemiler() {
		return gemiRepository.findAll();
	}

	public Optional<Gemi> getGemiById(long id) {
		return gemiRepository.findById(id);
	}

	public Gemi gemiEkleGuncelle(Gemi gemi) {
		return gemiRepository.save(gemi);
	}

	public void gemiSil(long id) {
		gemiRepository.deleteById(id);
	}

	public List<Gemi> getGemilerByIlAdi(String ilAdi) {
		return gemiRepository.findByBirlikIl(ilAdi);
	}
}
