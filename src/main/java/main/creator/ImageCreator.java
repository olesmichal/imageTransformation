package main.creator;

import main.data.ImageContainer;
import main.data.ImageFormat;

import java.awt.image.BufferedImage;

/**
 * Created by moles on 2016-09-09.
 *
 * @author moles
 * @version 1.1
 */
public class ImageCreator {

    private final int DEFAULT_DIMENISION=1000;

    public ImageContainer createEmpty(String path, ImageFormat format) {
        format = format == null ? ImageFormat.JPG : format;
        int imageType = getImageFormat(format);
        BufferedImage empty = new BufferedImage(DEFAULT_DIMENISION,DEFAULT_DIMENISION, imageType);
        return new ImageContainer(empty, path, format);
    }

    private int getImageFormat(ImageFormat format) {
        int imageType;
        switch (format) {
            case PNG:
                imageType = BufferedImage.TYPE_INT_ARGB;
                break;
            default:
                imageType = BufferedImage.TYPE_INT_RGB;
                break;
        }
        return imageType;
    }

}
