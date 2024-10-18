import java.io.*;

public class Hider {
    /**
     * Hides a ZIP file inside an image.
     *
     * @param imgPath the path to the original image file
     * @param zipPath the path to the ZIP file to be hidden
     * @param outputPath the path for the output image containing the hidden ZIP
     * @throws IOException if an I/O error occurs during file operations
     */
    public static void simpletrick(String imgPath, String zipPath, String outputPath) throws IOException {
        try (
                FileInputStream imageStream = new FileInputStream(imgPath);
                FileInputStream zipStream = new FileInputStream(zipPath);
                FileOutputStream outputStream = new FileOutputStream(outputPath)
        ) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = imageStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            while ((bytesRead = zipStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("Done successfully!");
        }
    }
}