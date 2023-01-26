package com.hw.ticketapp.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bilet")
public class Bilet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;
	@Column(name = "otobus_Id")
	private Long otobusId;
	@Column(name = "user_Id")
	private Long userId;
	@Column(name = "nereden")
	private String nereden;
	@Column(name = "nereye")
	private String nereye;
	@Column(name = "koltuk_numarasi")
	private String koltukSayisi;
	@Column(name = "tarih")
	private LocalDate tarih;
	@Column(name = "status")
	private int status;

	public Bilet(Long id, Long otobusId, Long userId, String nereden, String nereye, String koltukSayisi,
			LocalDate tarih, int status) {
		super();
		this.id = id;
		this.otobusId = otobusId;
		this.userId = userId;
		this.nereden = nereden;
		this.nereye = nereye;
		this.koltukSayisi = koltukSayisi;
		this.tarih = tarih;
		this.status = status;
	}

	public Bilet() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOtobusId() {
		return otobusId;
	}

	public void setOtobusId(Long otobusId) {
		this.otobusId = otobusId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNereden() {
		return nereden;
	}

	public void setNereden(String nereden) {
		this.nereden = nereden;
	}

	public String getNereye() {
		return nereye;
	}

	public void setNereye(String nereye) {
		this.nereye = nereye;
	}

	public String getKoltukSayisi() {
		return koltukSayisi;
	}

	public void setKoltukSayisi(String koltukSayisi) {
		this.koltukSayisi = koltukSayisi;
	}

	public LocalDate getTarih() {
		return tarih;
	}

	public void setTarih(LocalDate tarih) {
		this.tarih = tarih;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
