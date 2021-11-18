package co.edu.ucundinamarca.negocio.parametricaservice.services;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DriveService {

    private static final String APPLICATION_NAME = "Hotel UDEC";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = DriveService.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    private Drive getService() throws GeneralSecurityException, IOException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        return new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public void test(){
        try{
            Drive service = this.getService();

            // Print the names and IDs for up to 10 files.
            FileList result = service.files().list()
                    .setPageSize(10)
                    .setFields("nextPageToken, files(id, name)")
                    .execute();
            List<File> files = result.getFiles();
            if (files == null || files.isEmpty()) {
                System.out.println("No files found.");
            } else {
                System.out.println("Files:");
                for (File file : files) {
                    System.out.printf("%s (%s)\n", file.getName(), file.getId());
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private String createFolder( String name, String parent ){
        String folderID = "";
        try{
            Drive service = this.getService();
            File fileMetadata = new File();
            fileMetadata.setName(name);
            fileMetadata.setMimeType("application/vnd.google-apps.folder");

            if( parent != null ){
                fileMetadata.setParents( Collections.singletonList( parent ) );
            }

            File file = service.files().create(fileMetadata)
                    .setFields("id")
                    .execute();

            folderID = file.getId();

        }catch ( GeneralSecurityException | IOException ex ){
            ex.printStackTrace();
        }

        return folderID;
    }

    public List<String> uploadImages(MultipartFile[] images, String folder){

        // Creating folder in Google Drive
        String parentFolder = "1roYx2BPucuBgDI__CGZK9tLSH902E9qg"; // ID catalogo-habitaciones folder
        String folderID = createFolder( folder, parentFolder );
        List<String> urls = new ArrayList<>();

        try{
            Drive service = this.getService();
            int count = 1;

            for( MultipartFile image: images ){

                // Getting extension file
                String[] fileName = image.getOriginalFilename().split("\\.");
                String ext = fileName[ fileName.length - 1 ];

                // Creating temporal file
                java.io.File tmp = new java.io.File("src/main/resources/tmp." + ext);
                tmp.createNewFile();

                // Transfering bytes multipartfile to file
                FileOutputStream fout = new FileOutputStream(tmp);
                fout.write( image.getBytes() );
                fout.close();

                // Creating file google drive
                File file = new File();
                FileContent content = new FileContent(image.getContentType(), tmp);

                file.setName(count + "." + ext);
                file.setParents(Collections.singletonList( folderID ));

                // Uploading file
                file = service.files().create(file, content).setFields("id").execute();

                // Deleting temporal file
                tmp.delete();

                urls.add( "https://drive.google.com/uc?export=view&id=" + file.getId() );
                count++;
            }

        }catch( Exception ex ){
            ex.printStackTrace();
        }

        return urls;
    }
}
