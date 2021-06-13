package com.dashboard.cov19.repository;

import com.dashboard.cov19.entity.CovidCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CovidCaseRepository extends JpaRepository<CovidCase, Long> {
    List<CovidCase> findByCountry(String country);
}
