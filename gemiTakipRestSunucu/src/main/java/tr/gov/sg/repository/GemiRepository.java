package tr.gov.sg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.gov.sg.entity.Gemi;

public interface GemiRepository extends JpaRepository<Gemi, Long> {

}
