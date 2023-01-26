package com.hw.ticketapp.model;

import jakarta.persistence.Column;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@Table(name = "otobus")
public class Otobus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "nereden")
    private String nereden;
    @Column(name = "nereye")
    private String nereye;
    @Column(name = "koltuk_sayisi")
    private Integer koltukSayisi;
    @Column(name = "tarih")
    private LocalDate tarih;
    @Column(name = "satilan_koltuk_sayisi")
    private Integer satilanKoltukSayisi;


    public Otobus(){

    }


	public Otobus(Long id, String nereden, String nereye, Integer koltukSayisi, LocalDate tarih,
			Integer satilanKoltukSayisi) {
		super();
		this.id = id;
		this.nereden = nereden;
		this.nereye = nereye;
		this.koltukSayisi = koltukSayisi;
		this.tarih = tarih;
		this.satilanKoltukSayisi = satilanKoltukSayisi;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public Integer getkoltukSayisi() {
		return koltukSayisi;
	}


	public void setkoltukSayisi(Integer koltukSayisi) {
		this.koltukSayisi = koltukSayisi;
	}


	public LocalDate getTarih() {
		return tarih;
	}


	public void setTarih(LocalDate tarih) {
		this.tarih = tarih;
	}


	public Integer getSatilanKoltukSayisi() {
		return satilanKoltukSayisi;
	}


	public void setSatilanKoltukSayisi(Integer satilanKoltukSayisi) {
		this.satilanKoltukSayisi = satilanKoltukSayisi;
	}
	
	

    
    
}
