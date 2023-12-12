import java.io.File;
import java.io.IOException;

public class CreateJpgFile {

    public static void main(String[] args) {
        String fileName = "example.jpg";

        try {
            createEmptyJpgFile(fileName);
            System.out.println("JPG file created successfully!");
        } catch (IOException e) {
            System.out.println("Error creating JPG file: " + e.getMessage());
        }
    }

    private static void createEmptyJpgFile(String fileName) throws IOException {
        File jpgFile = new File(fileName);

        // Create a new empty file
        boolean fileCreated = jpgFile.createNewFile();

        if (fileCreated) {
            System.out.println("File path: " + jpgFile.getAbsolutePath());
        } else {
            throw new IOException("File already exists or cannot be created.");
        }
    }
}
