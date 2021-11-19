package co.edu.ucundinamarca.negocio.parametricaservice.services;

import co.edu.ucundinamarca.negocio.parametricaservice.entities.GaleriaHabitacion;
import co.edu.ucundinamarca.negocio.parametricaservice.repository.GaleriaHabitacionRepository;
import com.google.api.services.drive.model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class GaleriaHabitacionService {

    private final GaleriaHabitacionRepository galeriaRepository;
    private final DriveService driveService;

    @Autowired
    public GaleriaHabitacionService(GaleriaHabitacionRepository galeriaRepository, DriveService driveService) {
        this.galeriaRepository = galeriaRepository;
        this.driveService = driveService;
    }

    public List<GaleriaHabitacion> guardarGaleria(List<String> urls, Integer id_tipo_habitacion ){
        List<GaleriaHabitacion> galeria = new ArrayList<>();
        GaleriaHabitacion imagen;
        for(String url: urls){
            imagen = new GaleriaHabitacion();
            imagen.setId_tipo_habitacion( id_tipo_habitacion );
            imagen.setUrl_imagen( url );
            galeria.add( imagen );
        }

        return galeriaRepository.saveAll( galeria );
    }

    public List<String> subirGaleriaADrive(MultipartFile[] images, String folder){
        List<String> urls = new ArrayList<>();

        // Crear carpeta en Google Drive
        String parentFolder = "1roYx2BPucuBgDI__CGZK9tLSH902E9qg"; // ID catalogo-habitaciones folder
        String folderID = driveService.createFolder( folder, parentFolder );

        // Subir imagenes a Drive
        int count = 1;
        for( MultipartFile image: images ){
            File file = driveService.uploadImage( image, count+"", folderID );
            urls.add( "https://drive.google.com/uc?export=view&id=" + file.getId() );
            count++;
        }

        return urls;
    }

    public void validarImagenes(MultipartFile[] images){

    }
}
