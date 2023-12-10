package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.TaiSan;


public interface TaiSanService {
	List<TaiSan> getAllTaiSan();
	void saveTaiSan(TaiSan taiSan);
	TaiSan getTaiSanById(long id);
	void deleteTaiSanByid(long id);
	boolean isMataisanExists(String mataisan);
}
