package tr.gov.sg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.gov.sg.entity.Gemi;

public interface GemiRepository extends JpaRepository<Gemi, Long> {
	// @Query("from Gemi g where g.birlik.il = :ilAdi")
	public List<Gemi> findByBirlikIl(String ilAdi);
}
