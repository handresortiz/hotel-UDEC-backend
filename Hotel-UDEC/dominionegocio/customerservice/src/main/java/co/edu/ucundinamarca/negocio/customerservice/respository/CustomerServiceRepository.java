/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.negocio.customerservice.respository;


import co.edu.ucundinamarca.negocio.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 *
 * @author sotobotero
 */
public interface CustomerServiceRepository extends JpaRepository<Customer, Long> {

     @Query("SELECT c FROM Customer c WHERE c.code = ?1")
      public Customer findByCode(String code);
   }
