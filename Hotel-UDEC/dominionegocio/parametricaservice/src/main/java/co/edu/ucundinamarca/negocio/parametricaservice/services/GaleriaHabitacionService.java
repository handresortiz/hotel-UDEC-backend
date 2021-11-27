package co.edu.ucundinamarca.negocio.parametricaservice.services;

import co.edu.ucundinamarca.negocio.parametricaservice.entities.GaleriaHabitacion;
import co.edu.ucundinamarca.negocio.parametricaservice.repository.GaleriaHabitacionRepository;
import com.google.api.services.drive.model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class GaleriaHabitacionService {

    private final GaleriaHabitacionRepository galeriaRepository;
    private final DriveService driveService;

    @Autowired
    public GaleriaHabitacionService(GaleriaHabitacionRepository galeriaRepository, DriveService driveService) {
        this.galeriaRepository = galeriaRepository;
        this.driveService = driveService;
    }

    public List<GaleriaHabitacion> obtenerGaleriaPorTipo(Integer id_tipo_habitacion){
        return galeriaRepository.findAllByTipo( id_tipo_habitacion );
    }

    private String getDriveFileID(String url){
        Pattern p = Pattern.compile("id=([^&]*)");
        Matcher matcher = p.matcher(url);

        return ( matcher.find() ? matcher.group(1) : "" );
    }

    public void removeFilesDrive(List<GaleriaHabitacion> galeria){

        for (GaleriaHabitacion g: galeria){
            String fileID = getDriveFileID( g.getUrl_imagen() );
            if(fileID != ""){
                driveService.removeFile( fileID );
            }
        }

    }

    public void eliminarGaleria(Integer id_tipo_habitacion){
        // Eliminar la carpeta del tipo de habitacion en Drive
        String folderID = driveService.getFolderID(id_tipo_habitacion+"");
        if(!folderID.isEmpty()){
            driveService.removeFile( folderID );
        }

        // Eliminar los registros de galeria_habitacion en BD
        galeriaRepository.deleteAllByTipo( id_tipo_habitacion );
    }

    public List<GaleriaHabitacion> editarGaleria(Integer id_tipo_habitacion, List<GaleriaHabitacion> g){
        List<GaleriaHabitacion> galeria = obtenerGaleriaPorTipo( id_tipo_habitacion );
        if (galeria.size() != g.size()){
            List<GaleriaHabitacion> removed = new ArrayList<>();

            // Compara la lista original con la traida y extrae las imagenes que fueron removidas
            for(int i = 0; i < galeria.size(); i++){
                boolean isRemoved = true;
                for(int j = 0; j < g.size(); j++){
                    if(galeria.get(i).getId() == g.get(j).getId()){
                        isRemoved = false;
                        break;
                    }
                }

                if(isRemoved){
                    removed.add( galeria.get(i) );
                }
            }

            if(removed.size() > 0){
                // De la lista de imagenes removidas se eliminan las que esten subidas en Google Drive
                removeFilesDrive( removed );

                // Se eliminan los registros de la BD
                galeriaRepository.deleteAll( removed );

                galeria = galeriaRepository.findAllByTipo( id_tipo_habitacion );
            }

        }

        return galeria;
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
        String parentFolder = driveService.getFolderID("catalogo-habitaciones");
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
}
