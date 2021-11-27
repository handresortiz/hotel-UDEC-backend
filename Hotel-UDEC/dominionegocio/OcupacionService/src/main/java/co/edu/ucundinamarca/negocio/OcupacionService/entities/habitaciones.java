/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.negocio.OcupacionService.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Setter
@Getter
@Table(name = "habitaciones")
public class habitaciones {
    
    @Id
    private Integer id_habitacion;
    private Integer id_tipo_habitacion;
    private Long num_habitacion;
    private Date fec_cambio;
    private Long id_usuario_cambio;
    private Boolean limpieza;
    private String estado;
    private Boolean mantenimiento;

    
    public habitaciones(){}
    
   public habitaciones(long num_habitacion){
       super();
       this.num_habitacion=num_habitacion;
   }
    
   
   
    
}