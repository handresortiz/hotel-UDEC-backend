package co.edu.ucundinamarca.negocio.parametricaservice.controller;

import co.edu.ucundinamarca.negocio.parametricaservice.entities.GaleriaHabitacion;
import co.edu.ucundinamarca.negocio.parametricaservice.entities.TipoHabitacion;
import co.edu.ucundinamarca.negocio.parametricaservice.services.DriveService;
import co.edu.ucundinamarca.negocio.parametricaservice.services.GaleriaHabitacionService;
import co.edu.ucundinamarca.negocio.parametricaservice.services.TipoHabitacionService;
import co.edu.ucundinamarca.negocio.parametricaservice.validators.ImageFilesValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/tipohabitacion")
public class TipoHabitacionController {

    private final TipoHabitacionService tipoHabitacionService;
    private final GaleriaHabitacionService galeriaHabitacionService;
    private final DriveService driveService;

    @Autowired
    public TipoHabitacionController(TipoHabitacionService tipoHabitacionService, GaleriaHabitacionService galeriaHabitacionService, DriveService driveService) {
        this.tipoHabitacionService = tipoHabitacionService;
        this.galeriaHabitacionService = galeriaHabitacionService;
        this.driveService = driveService;
    }

    @PostMapping()
    public ResponseEntity<TipoHabitacion> crearTipoHabitacion(
            @Valid @RequestPart TipoHabitacion tipo,
            @RequestPart MultipartFile[] images
            ){
        //Validar imagenes
        new ImageFilesValidator().isValid( images );

        // Crea el registro del tipo de habitacion
        tipo = tipoHabitacionService.createTipoHabitacion( tipo );

        //Sube las imagenes a Google Drive y obtiene una lista de las url
        List<String> urls = galeriaHabitacionService.subirGaleriaADrive( images, tipo.getNom_tipo_habitacion() );

        // Guarda las url en la BD asociando el tipo de habitacion
        List<GaleriaHabitacion> galeria = galeriaHabitacionService.guardarGaleria( urls, tipo.getId_tipo_habitacion() );

        tipo.setGaleria( galeria );

        return new ResponseEntity<TipoHabitacion>(tipo, HttpStatus.CREATED);
    }
}
