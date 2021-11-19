package co.edu.ucundinamarca.negocio.parametricaservice.validators;

import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;


public class ImageFilesValidator {

    public void isValid(MultipartFile[] files) {
        boolean noValid = true;

        // Verifying empty array
        if (files.length == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                                                "Se debe subir al menos una imagen");
        }

        // Check if content-type of files are images
        noValid = Arrays.stream(files).anyMatch( file -> !file.getContentType().contains("image") );
        if (noValid) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Uno de los archivos subidos no es una imagen");
        }
    }
}
