package com.hw.ticketapp.service;

import java.util.List;

import com.hw.ticketapp.model.Otobus;

public interface OtobusService {
	Otobus saveOtobus(Otobus otobus);
	Otobus updateOtobus(Otobus otobus);
    void deleteOtobus(Long id);
	List<Otobus> rotaVeVeyaTariheGoreOtobusleriGetir(String nereden, String nereye, String tarih) throws Exception;
	List<Otobus> rotalariListele() throws Exception;
}
