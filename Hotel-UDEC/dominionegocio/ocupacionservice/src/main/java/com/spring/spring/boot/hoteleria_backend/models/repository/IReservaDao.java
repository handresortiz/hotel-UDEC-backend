package com.spring.spring.boot.hoteleria_backend.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.spring.boot.hoteleria_backend.models.entity.Reserva;

public interface IReservaDao extends JpaRepository<Reserva,Long>{

}
