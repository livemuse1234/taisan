package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_taisan")
public class TaiSan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	@Column(name="mataisan")
	private String mataisan;
	@Column(name="tentaisan")
	private String tentaisan;
	@Column(name="nguoisohuu")
	private String nguoisohuu;
	@Column(name="theloai")
	private String theloai;
	@Column(name="soluong")
	private int soluong;
	@Column(name="dongia")
	private String dongia;
	public TaiSan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiSan(long id, String mataisan, String tentaisan, String nguoisohuu, String theloai, int soluong,
			String dongian) {
		super();
		this.id = id;
		this.mataisan = mataisan;
		this.tentaisan = tentaisan;
		this.nguoisohuu = nguoisohuu;
		this.theloai = theloai;
		this.soluong = soluong;
		this.dongia = dongian;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMataisan() {
		return mataisan;
	}
	public void setMataisan(String mataisan) {
		this.mataisan = mataisan;
	}
	public String getTentaisan() {
		return tentaisan;
	}
	public void setTentaisan(String tentaisan) {
		this.tentaisan = tentaisan;
	}
	public String getNguoisohuu() {
		return nguoisohuu;
	}
	public void setNguoisohuu(String nguoisohuu) {
		this.nguoisohuu = nguoisohuu;
	}
	public String getTheloai() {
		return theloai;
	}
	public void setTheloai(String theloai) {
		this.theloai = theloai;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getDongia() {
		return dongia;
	}
	public void setDongia(String dongia) {
		this.dongia = dongia;
	}
	public String getTinhTrang() {
		if (soluong >= 100) {
			return "Nhiều";
		} else if ( soluong < 100) {
			return "TB";
		} else {
			return "Ít";
		}
		
	}
}
