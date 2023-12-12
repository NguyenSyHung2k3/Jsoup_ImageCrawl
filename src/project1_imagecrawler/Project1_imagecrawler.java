/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package project1_imagecrawler;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author pv
 */
public class Project1_imagecrawler extends Application {
    
    // get the url image through url : "https://this-person-does-not-exist.com"
    
    public String Crawlimage(){
        String url = "https://this-person-does-not-exist.com/";
        String img = "";
        try{
            
            Document document = Jsoup.connect(url).get();
            Elements docs = document.select("#avatar");
            
            for(Element e:docs){
                img = e.attr("src");
                System.out.println(img);
            }  
        }catch(IOException e){
            e.printStackTrace();
        }
        
        return url + img;
    }
    
    
    // download image through url got from Crawlimage
    public static void downloadImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        try (InputStream in = url.openStream();
             FileOutputStream out = new FileOutputStream(destinationFile)) {

            // Read the image content from the URL and write it to the local file
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
        
    }
    
    // create folder 
    private static void createFolder(String folderPath) throws IOException {
        Path folder = Path.of(folderPath);

        // Create the folder if it doesn't exist
        if (!Files.exists(folder)) {
            Files.createDirectories(folder);
            System.out.println("Folder created: " + folder.toAbsolutePath());
        }
    }

    // save file image to folder image
    private static void saveImagesToFolder(String folderPath, String imageUrl) throws IOException {

            // Extract the filename from the URL
            String fileName = imageUrl.substring(imageUrl.lastIndexOf('/') + 1);

            // Construct the path for saving the image
            Path imagePath = Path.of(folderPath, fileName);

            // Download the image and save it to the folder
            URL url = new URL(imageUrl);
            Files.copy(url.openStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Image saved: " + imagePath.toAbsolutePath());

    }
    
    public String img_url = Crawlimage(); // the url contained the image of each person
    public String destinationFile = "person_image.png"; // file person_image needed to save
    public String folderPath = "project1_imagecrawler/image"; // folder path
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Image Viewer");
        Image image = new Image(img_url);
        ImageView imageView = new ImageView(image);
        
        Button button = new Button("click me");
        
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            
                img_url = Crawlimage();
                Image image = new Image(img_url);
                imageView.setImage(image);
                try {
                    downloadImage(img_url, destinationFile);
                    System.out.println("Image downloaded successfully!");
                   
                    try{
                        
                        createFolder(folderPath);
                        
                        saveImagesToFolder(folderPath, img_url);            
                        
                    } catch(IOException er){
                        er.printStackTrace();
                    }
                            
                    
                } catch (IOException er) {
                    System.out.println("Error downloading the image: " + er.getMessage());
                }
            } 
        }; 
        
        button.setOnAction(event);
        
        StackPane root = new StackPane();
        root.getChildren().add(imageView);
        root.getChildren().add(button);
        
        primaryStage.setScene(new Scene(root, 900, 700));
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
}
