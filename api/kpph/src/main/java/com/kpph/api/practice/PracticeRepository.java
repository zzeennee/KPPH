package com.kpph.api.practice;

import com.kpph.api.entity.Test2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PracticeRepository extends JpaRepository<Test2, Integer> {
}
