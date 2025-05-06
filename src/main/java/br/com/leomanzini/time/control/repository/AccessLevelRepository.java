package br.com.leomanzini.time.control.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leomanzini.time.control.models.AccessLevel;

public interface AccessLevelRepository extends JpaRepository<AccessLevel, Long> {

}
