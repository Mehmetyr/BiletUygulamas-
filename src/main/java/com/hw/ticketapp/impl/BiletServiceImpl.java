package com.hw.ticketapp.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hw.ticketapp.model.Bilet;
import com.hw.ticketapp.repository.BiletRepository;
import com.hw.ticketapp.service.BiletService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
 

@Service
public class BiletServiceImpl implements BiletService {
	
	@Autowired
    @PersistenceContext
    private EntityManager entityManager;
	
    private final BiletRepository biletRepository;

    public BiletServiceImpl(BiletRepository biletRepository) {
        this.biletRepository = biletRepository;
    }

	@Override
	public Bilet saveBilet(Bilet bilet) {
		return biletRepository.save(bilet);
	}

	@Override
	public Bilet updateBilet(Bilet bilet) {
		return biletRepository.save(bilet);
	}

	@Override
	public void deleteBilet(Long id) {
		biletRepository.deleteById(id);
		
	}

	@Override
	public List<Bilet> findAllAcikIBilet() throws Exception {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Bilet> query = cb.createQuery(Bilet.class);
        Root<Bilet> bilet = query.from(Bilet.class);



        List<Predicate> predicates = new ArrayList<>();

        predicates.add(cb.equal(bilet.get("status"), 1));
        
        query.select(bilet)
            .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

        ArrayList<Bilet> result = (ArrayList<Bilet>) entityManager.createQuery(query).getResultList();

        if(result == null || result.size() == 0) {
        	throw new Exception("Açık Bilet Bulunamadı");
        }
        
        return result;
	}

	@Override
	public Bilet findById(Long id) {
		Optional<Bilet> optionalBilet= biletRepository.findById(id);
		return optionalBilet.get();
	}

	@Override
	public List<Bilet> findAllAcikBiletwithUserId(Long userId) throws Exception {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Bilet> query = cb.createQuery(Bilet.class);
        Root<Bilet> bilet = query.from(Bilet.class);



        List<Predicate> predicates = new ArrayList<>();

        predicates.add(cb.equal(bilet.get("status"), 1));
        predicates.add(cb.equal(bilet.get("userId"), userId));
        
        query.select(bilet)
            .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

        ArrayList<Bilet> result = (ArrayList<Bilet>) entityManager.createQuery(query).getResultList();

        if(result == null || result.size() == 0) {
        	throw new Exception("Açık Bilet Bulunamadı");
        }
        
        return result;
	}

	@Override
	public List<Bilet> findAllKapaliBilet() throws Exception {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Bilet> query = cb.createQuery(Bilet.class);
        Root<Bilet> bilet = query.from(Bilet.class);



        List<Predicate> predicates = new ArrayList<>();

        predicates.add(cb.equal(bilet.get("status"), 0));
        
        query.select(bilet)
            .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

        ArrayList<Bilet> result = (ArrayList<Bilet>) entityManager.createQuery(query).getResultList();

        if(result == null || result.size() == 0) {
        	throw new Exception("Kapali Bilet Bulunamadı");
        }
        
        return result;
	}

	@Override
	public List<Bilet> findAllKapaliBiletwithUserId(Long userId) throws Exception {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Bilet> query = cb.createQuery(Bilet.class);
        Root<Bilet> bilet = query.from(Bilet.class);



        List<Predicate> predicates = new ArrayList<>();

        predicates.add(cb.equal(bilet.get("status"), 1));
        predicates.add(cb.equal(bilet.get("userId"), userId));
        
        query.select(bilet)
            .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

        ArrayList<Bilet> result = (ArrayList<Bilet>) entityManager.createQuery(query).getResultList();

        if(result == null || result.size() == 0) {
        	throw new Exception("Kapalı Bilet Bulunamadı");
        }
        
        return result;
	}
	
	
	
	


}
