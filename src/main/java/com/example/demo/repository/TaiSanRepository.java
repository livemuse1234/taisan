package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.TaiSan;

public interface TaiSanRepository extends JpaRepository<TaiSan, Long> {
	 boolean existsByMataisan(String mataisan);
}
