package com.spring.spring.boot.hoteleria_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.spring.boot.hoteleria_backend.models.repository.IReservaDao;
import com.spring.spring.boot.hoteleria_backend.models.entity.Reserva;

@Service
public class IReservaServiceImpl implements IReservaService {
	@Autowired
	private IReservaDao reservaDao;
	
	@Override
	public Reserva findById(Long id) {
		return reservaDao.findById(id).orElse(null);
	}

	@Override
	public Reserva save(Reserva reserva) {
		return reservaDao.save(reserva);
	}

}
