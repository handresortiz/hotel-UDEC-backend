package co.edu.ucundinamarca.negocio.parametricaservice.entities;

import javax.persistence.*;

@Entity
@Table( name="perfiles" )
public class Perfil {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id_perfil;

    private String nom_perfil;
    private String desc_perfil;

    public Integer getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(Integer id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getNom_perfil() {
        return nom_perfil;
    }

    public void setNom_perfil(String nom_perfil) {
        this.nom_perfil = nom_perfil;
    }

    public String getDesc_perfil() {
        return desc_perfil;
    }

    public void setDesc_perfil(String desc_perfil) {
        this.desc_perfil = desc_perfil;
    }
}
