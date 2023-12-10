package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.entity.TaiSan;
import com.example.demo.service.TaiSanService;


@Controller
public class TaiSanController {
	@Autowired
	private TaiSanService taiSanService;

	// display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listTaiSan", taiSanService.getAllTaiSan());
		return "index";
	}

	@GetMapping("/showNewTaiSanForm")
	public String showNewTaiSanForm(Model model) {
		// create model attribute to bind form data
		TaiSan taiSan = new TaiSan();
		model.addAttribute("taiSan", taiSan);
		return "new_taisan";
	}
	

	
	

	    @PostMapping("/saveTaiSan")
	    public String saveTaiSan(@ModelAttribute("taiSan") TaiSan taiSan, Model model) {
	        if (taiSanService.isMataisanExists(taiSan.getMataisan())) {
	            model.addAttribute("error", "Mã tài sản đã tồn tại");
	            return "new_taisan"; // Trở lại trang thêm mới tài sản
	        } else {
	            taiSanService.saveTaiSan(taiSan);
	            return "redirect:/"; // Chuyển hướng sau khi thêm mới thành công
	        }
	    }


	@GetMapping("/UpdateTaiSan/{id}")
	public String UpdateTaiSan(@PathVariable(value = "id") long id, Model model) {
		// get employee from the service
		TaiSan taiSan = taiSanService.getTaiSanById(id);
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("taiSan", taiSan);
		return "update_taisan";
	}
	
	@PostMapping("/updateTaiSan")
	public String updateTaiSan(@ModelAttribute("taiSan") TaiSan taiSan, Model model) {
	    if (taiSanService.isMataisanExists(taiSan.getMataisan())) {
	        model.addAttribute("error", "Mã tài sản đã tồn tại");
	        return "update_taisan"; // Trả về trang cập nhật hiện tại với thông báo lỗi
	    } else {
	        taiSanService.saveTaiSan(taiSan);
	        return "redirect:/"; // Chuyển hướng sau khi cập nhật thành công
	    }
	}

	@GetMapping("/deleteTaiSan/{id}")
	public String deleteTaiSan(@PathVariable(value = "id") long id) {
		// call delete employee method
		this.taiSanService.deleteTaiSanByid(id);
		return "redirect:/";
	}
}
