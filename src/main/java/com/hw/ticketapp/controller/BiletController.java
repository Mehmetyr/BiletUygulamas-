package com.hw.ticketapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hw.ticketapp.model.Bilet;
import com.hw.ticketapp.service.BiletService;

@RestController
@RequestMapping("/bilet")
public class BiletController {

	private final BiletService biletService;

	public BiletController(BiletService biletService) {
		this.biletService = biletService;

	}
	
	@GetMapping("AllAcikBilet")
	public List<Bilet> findAllAcikIBilet() throws Exception {

		List<Bilet> bilets = new ArrayList<>();
		try {
			bilets = biletService.findAllAcikIBilet();
			

		} catch (Exception e) {

			throw e;
		}
		return bilets;

	}
	
	@GetMapping("AllAcikBilet/{UserId}")
	public List<Bilet> findAllAcikBiletwithUserId(@PathVariable("UserId") Long UserId) throws Exception {

		List<Bilet> bilets = new ArrayList<>();
		try {
			bilets = biletService.findAllAcikBiletwithUserId(UserId);
			

		} catch (Exception e) {

			throw e;
		}
		return bilets;

	}
	
	@GetMapping("KapaliBilet")
	public List<Bilet> findAllKapaliBilet() throws Exception {

		List<Bilet> bilets = new ArrayList<>();
		try {
			bilets = biletService.findAllKapaliBilet();
			

		} catch (Exception e) {

			throw e;
		}
		return bilets;

	}
	
	@GetMapping("AllKapaliBilet/{UserId}")
	public List<Bilet> findAllKapaliBiletwithUserId(@PathVariable("UserId") Long UserId) throws Exception {

		List<Bilet> bilets = new ArrayList<>();
		try {
			bilets = biletService.findAllKapaliBiletwithUserId(UserId);
			

		} catch (Exception e) {

			throw e;
		}
		return bilets;

	}

	@GetMapping("bilet/{id}")
	public Bilet findBiletById(@PathVariable("id") Long id) throws Exception {

		Bilet bilet = new Bilet();
		try {
			bilet = biletService.findById(id);

		} catch (Exception e) {

			throw e;
		}
		return bilet;
	}


	@PostMapping
	public Bilet saveBilet(@RequestBody Bilet bilet) {

		Bilet result = new Bilet();
		try {
			result = biletService.saveBilet(bilet);

		} catch (Exception e) {

			throw e;
		}
		return result;

	}

	@PutMapping
	public Bilet updateBilet(@RequestBody Bilet bilet) {

		Bilet result = new Bilet();
		try {
			result = biletService.updateBilet(bilet);

		} catch (Exception e) {

			throw e;
		}
		return result;

	}

	@DeleteMapping("/{id}")
	public void deleteBilet(@PathVariable("id") Long id) throws Exception {

		try {
	

			biletService.deleteBilet(id);

		} catch (Exception e) {

			throw e;
		}
	}

}
