package com.spring.spring.boot.hoteleria_backend.service;

import com.spring.spring.boot.hoteleria_backend.models.entity.Reserva;

public interface IReservaService {

	public Reserva findById(Long id);

	public Reserva save(Reserva reserva);

}
