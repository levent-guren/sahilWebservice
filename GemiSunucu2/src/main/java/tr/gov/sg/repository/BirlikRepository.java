package tr.gov.sg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.gov.sg.entity.Birlik;

public interface BirlikRepository extends JpaRepository<Birlik, Long> {
	// Spring Data JPARepository metodları
	// (findBy, findOneBy, findAllBy gibi)
	// veritabanındaki birlik tablosuna göre sorguları hazırlayan metodlar
}
