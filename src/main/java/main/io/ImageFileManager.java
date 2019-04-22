package main.io;

import main.data.ImageContainer;
import main.data.ImageFormat;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by moles on 2016-09-09.
 */
public class ImageFileManager {

    public ImageFileManager() {
    }

    /**
     * @param path file path
     * @return imageContainer
     * @throws IOException in out error
     */
    public static ImageContainer loadFromDisk(String path) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(path));
        String format = extractFormat(path);
        String filePath = null;
        try {
            filePath = extractPathWithOutFormat(path, format);
        } catch (Exception e) {
        }
        ImageContainer imageContainer = new ImageContainer(bufferedImage, filePath, format);
        return imageContainer;
    }

    /**
     *
     * @param imageContainer image
     * @return result
     */
    public static boolean saveForDisk(ImageContainer imageContainer)  {
        BufferedImage bufferedImage = imageContainer.getBufferedImage();
        String path = imageContainer.getFilePath();
        String format = imageContainer.getImageFormat();
        File file = new File(path + "." + format);
        try {
            ImageIO.write(bufferedImage, format, file);
        }catch (IOException e){
            System.err.println(e);
            return false;
        }
        return true;
    }

    /**
     * @param path file path
     * @return file format
     * @throws IllegalArgumentException path is wrong
     */
    public static String extractFormat(String path) throws IllegalArgumentException {
        if (path == null || "".equals(path)) {
            throw new IllegalArgumentException();
        }
        String result = "";
        for (String s : ImageFormat.formats) {
            if (path.contains("." + s)) {
                result = s;
            }
        }
        if (result.equals("")) {
            result = "bmp";
        }
        return result;
    }

    /**
     * @param path   path
     * @param format format
     * @return path without file format
     */
    public static String extractPathWithOutFormat(String path, String format)
             {
        if (path == null || format == null || "".equals(path)) {
            throw new IllegalArgumentException();
        }
        int i;
        String result = "";
        if (!"".equals(format)) {
            i = path.indexOf("." + format);
            if (i != -1) {
                result = path.substring(0, i);
            } else {

            }
        } else {
            i = path.indexOf(".");
            if (i != -1) {
                result = path.substring(0, i);
            } else {
                result = path;
            }
        }
        return result;
    }
}
