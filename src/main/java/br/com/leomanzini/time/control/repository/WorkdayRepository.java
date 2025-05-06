package br.com.leomanzini.time.control.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.leomanzini.time.control.models.Workday;

@Repository
public interface WorkdayRepository extends JpaRepository<Workday, Long> {

}
