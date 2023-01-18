package study;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ImageInfoExtractor {
    public static void main(String[] args) throws IOException {
        File folder = new File("photos");
        File[] listOfFiles = folder.listFiles();

        FileWriter writer = new FileWriter("output.txt", true);

        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(".jpg")) {
                BufferedImage image = ImageIO.read(file);
                int width = image.getWidth();
                int height = image.getHeight();
                String type = ImageIO.getImageReaders(ImageIO.createImageInputStream(file)).next().getFormatName();
                String colorSpace = image.getColorModel().getColorSpace().toString();
                String fileName = file.getName();
                long fileSize = file.length();
                writer.write(fileName + "," + fileSize + "," + type + "," + width + "x" + height + "," + colorSpace + "\n");
            }
        }
        writer.close();
    }
}