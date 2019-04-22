package main.io;

import main.data.ImageContainer;
import main.data.ImageFormat;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by moles on 2016-09-09.
 */
public class ImageFileManager {

    private final String DOT = ".";
    private static final Logger logger = Logger.getLogger(ImageFileManager.class.getName());

    public ImageContainer loadFromDisk(String path) throws IOException {
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException();
        }
        BufferedImage bufferedImage = ImageIO.read(new File(path));
        ImageFormat format = extractFormat(path);
        String filePath = null;
        try {
            filePath = extractPathWithOutFormat(path, format);
        } catch (Exception e) {
        }
        ImageContainer imageContainer = new ImageContainer(bufferedImage, filePath, format);
        return imageContainer;
    }

    public boolean saveForDisk(ImageContainer imageContainer) {
        BufferedImage bufferedImage = imageContainer.getBufferedImage();
        String path = extractPathWithOutFormat(imageContainer.getFilePath(), imageContainer.getImageFormat());
        ImageFormat format = imageContainer.getImageFormat();
        File file = new File(path + DOT + format.name().toLowerCase());
        try {
            ImageIO.write(bufferedImage, format.name(), file);
        } catch (IOException e) {
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
    private ImageFormat extractFormat(String path) throws IllegalArgumentException {
        ImageFormat result = ImageFormat.JPG;
        if (canExtractFormat(path)) {
            int indexOfDot = path.lastIndexOf(DOT);
            String substring = path.substring(indexOfDot + 1);
            try {
                result = ImageFormat.valueOf(substring.toUpperCase());
            } catch (IllegalArgumentException e) {
                logger.warning(e.getMessage() + " value: " + substring);
            }

        }
        return result;
    }

    private boolean canExtractFormat(String path) {
        int indexOfDot = path.lastIndexOf(DOT);
        return indexOfDot > 0 && path.length() - 1 > indexOfDot;
    }

    private String extractPathWithOutFormat(String path, ImageFormat format) {
        int indexOfFormat = path.indexOf(format.name().toLowerCase());
        if (indexOfFormat > 0) {
            return path.substring(0, indexOfFormat - 1);
        }
        return path;
    }
}
