package co.edu.ucundinamarca.negocio.ocupacionservice.models.repository;

import java.util.List;

import co.edu.ucundinamarca.negocio.ocupacionservice.models.entity.Reservaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IReservaDao extends JpaRepository<Reservaciones,Integer>{

    @Query("select r from Reservaciones r where r.cuenta.huesped.persona.id_persona = ?1")
    public List<Reservaciones> findAllByCedula(Integer cedula);
}
