package com.hw.ticketapp.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hw.ticketapp.model.Otobus;
import com.hw.ticketapp.repository.OtobusRepository;
import com.hw.ticketapp.repository.UserRepository;
import com.hw.ticketapp.service.OtobusService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
 

@Service
public class OtobusServiceImpl implements OtobusService {
	
	@Autowired
    @PersistenceContext
    private EntityManager entityManager;
	
    private final OtobusRepository otobusRepository;

    public OtobusServiceImpl(OtobusRepository otobusRepository) {
        this.otobusRepository = otobusRepository;
    }

	@Override
	public Otobus saveOtobus(Otobus otobus) {
		return otobusRepository.save(otobus);
	}

	@Override
	public Otobus updateOtobus(Otobus otobus) {
		return otobusRepository.save(otobus);
	}

	@Override
	public void deleteOtobus(Long id) {
		otobusRepository.deleteById(id);
	}



	@Override
	public List<Otobus> rotaVeVeyaTariheGoreOtobusleriGetir(String nereden, String nereye, String tarih) throws Exception {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Otobus> query = cb.createQuery(Otobus.class);
        Root<Otobus> otobus = query.from(Otobus.class);



        List<Predicate> predicates = new ArrayList<>();

        predicates.add(cb.equal(otobus.get("nereden"), nereden));
        predicates.add(cb.equal(otobus.get("nereye"), nereye));
        if(!tarih.isEmpty()) {
        	predicates.add(cb.equal(otobus.get("tarih"), tarih));
        }
        
        query.select(otobus)
            .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

        ArrayList<Otobus> result = (ArrayList<Otobus>) entityManager.createQuery(query).getResultList();

        if(result == null || result.size() == 0) {
        	throw new Exception("İstenilen Rotada Otobüs Bulunamadı");
        }
        
        return result;
	}

	@Override
	public List<Otobus> rotalariListele() {
		return otobusRepository.findAll();
	}

	

}
