/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ucundinamarca.negocio.ServicioProducto.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author admin
 */
@Entity
@ToString
@Getter
@Setter
@Table(name="productos")
public class Producto {
    @Column(columnDefinition="serial")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;
    private Long id_categoria;
    private String nom_producto;
    private String desc_producto;
    private Date fec_cambio;
    private Long id_usuario_cambio;
    private Long precio_producto;
    private Long unidades_existentes;

    public Producto() {
    }

}
