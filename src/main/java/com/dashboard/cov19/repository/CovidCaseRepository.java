package com.dashboard.cov19.repository;

import com.dashboard.cov19.entity.CovidCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CovidCaseRepository extends JpaRepository<CovidCase, Long> {
}
