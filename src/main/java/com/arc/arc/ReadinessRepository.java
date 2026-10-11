package com.arc.arc;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadinessRepository extends JpaRepository<ReadinessCheck, Long>{
}
