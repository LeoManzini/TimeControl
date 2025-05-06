package br.com.leomanzini.time.control.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leomanzini.time.control.models.DateType;

public interface DateTypeRepository extends JpaRepository<DateType, Long> {

}
