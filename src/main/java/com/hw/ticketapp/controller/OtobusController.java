package com.hw.ticketapp.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hw.ticketapp.model.Otobus;
import com.hw.ticketapp.service.OtobusService;

@RestController
@RequestMapping("/otobus")
public class OtobusController {

	private final OtobusService otobusService;

	public OtobusController(OtobusService otobusService) {
		this.otobusService = otobusService;

	}


	@PostMapping
	public Otobus saveOtobus(@RequestBody Otobus otobus) {

		Otobus result = new Otobus();
		try {
			result = otobusService.saveOtobus(otobus);

		} catch (Exception e) {

			throw e;
		}
		return result;

	}

	@PutMapping
	public Otobus updateOtobus(@RequestBody Otobus otobus) {

		Otobus result = new Otobus();
		try {
			result = otobusService.updateOtobus(otobus);

		} catch (Exception e) {

			throw e;
		}
		return result;

	}

	@DeleteMapping("/{id}")
	public void deleteOtobus(@PathVariable("id") Long id) throws Exception {

		try {
	

			otobusService.deleteOtobus(id);

		} catch (Exception e) {

			throw e;
		}
	}
	
	@GetMapping("rotalariListele")
	public List<String> rotalariListele() throws Exception {

		List<Otobus> otobuss = new ArrayList<>();
		List<String> result = new ArrayList<>();
		try {
			otobuss = otobusService.rotalariListele();
			
			for (Otobus otobus : otobuss) {
				result.add(otobus.getNereden()+" - "+otobus.getNereye()+ " - " + otobus.getTarih());
			}

		} catch (Exception e) {

			throw e;
		}
		return result;

	}
	
	@GetMapping("rotayaGoreOtobusleriGetir/{nereden}/{nereye}")
	public List<Otobus> rotayaGoreOtobusleriGetir(@PathVariable("nereden") String nereden, @PathVariable("nereye") String nereye) throws Exception {

		List<Otobus> otobuss = new ArrayList<>();
		try {
			otobuss = otobusService.rotaVeVeyaTariheGoreOtobusleriGetir(nereden, nereye, "");
			

		} catch (Exception e) {

			throw e;
		}
		return otobuss;

	}
	
	@GetMapping("rotaVeTariheGoreOtobusleriGetir/{nereden}/{nereye}/{tarih}")
	public List<Otobus> rotaVeTariheGoreOtobusleriGetir(@PathVariable("nereden") String nereden, @PathVariable("nereye") String nereye , @PathVariable("tarih") String tarih) throws Exception {

		List<Otobus> otobuss = new ArrayList<>();
		try {
			otobuss = otobusService.rotaVeVeyaTariheGoreOtobusleriGetir(nereden, nereye, tarih);
			

		} catch (Exception e) {

			throw e;
		}
		return otobuss;

	}

}
