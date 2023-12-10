package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TaiSan;
import com.example.demo.repository.TaiSanRepository;
import com.example.demo.service.TaiSanService;

@Service
public class TaiSanServiceImpl implements TaiSanService {
	@Autowired
	private TaiSanRepository taiSanRepository;
	@Override
	public List<TaiSan> getAllTaiSan() {
		// TODO Auto-generated method stub
		return taiSanRepository.findAll();
	}

	@Override
	public void saveTaiSan(TaiSan taiSan) {
		// TODO Auto-generated method stub
		if (isMataisanExists(taiSan.getMataisan())) {
            // Xử lý thông báo lỗi khi mã giáo viên đã tồn tại
        } else {
            taiSanRepository.save(taiSan);
        }
	}

	@Override
	public TaiSan getTaiSanById(long id) {
		Optional < TaiSan > optional = taiSanRepository.findById(id);
		TaiSan taiSan = null;
		if (optional.isPresent()) {
			 taiSan = optional.get();
			 } else {
			 throw new RuntimeException(" Không tìm thấy id tài sản :: " + id);
			 }
		return taiSan;
	}

	@Override
	public void deleteTaiSanByid(long id) {
		// TODO Auto-generated method stub
		this.taiSanRepository.deleteById(id);
	}

	@Override
	public boolean isMataisanExists(String mataisan) {
		// TODO Auto-generated method stub
		return taiSanRepository.existsByMataisan(mataisan);
	}

}
