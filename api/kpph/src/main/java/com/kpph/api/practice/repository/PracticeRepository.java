package com.kpph.api.practice.repository;

import com.kpph.api.practice.entity.Practice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticeRepository extends JpaRepository<Practice, Integer> {
}
