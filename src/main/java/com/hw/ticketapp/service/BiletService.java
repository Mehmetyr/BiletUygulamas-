package com.hw.ticketapp.service;

import java.util.List;

import com.hw.ticketapp.model.Bilet;

public interface BiletService {
	Bilet saveBilet(Bilet bilet);
	Bilet updateBilet(Bilet bilet);
    void deleteBilet(Long id);
	List<Bilet> findAllAcikIBilet() throws Exception;
	Bilet findById(Long id);
	List<Bilet> findAllAcikBiletwithUserId(Long userId) throws Exception;
	List<Bilet> findAllKapaliBilet() throws Exception;
	List<Bilet> findAllKapaliBiletwithUserId(Long userId) throws Exception;
}
