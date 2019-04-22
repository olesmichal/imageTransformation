package main.data;

import java.awt.image.BufferedImage;

/**
 * @author michal.oles
 * @version 1.01
 */
public class ImageContainer {
    private BufferedImage bufferedImage;
    private int numberOfColumn;
    private int numberOfLine;
    private String filePath;
    private ImageFormat imageFormat;

    public ImageContainer(BufferedImage bufferedImage, String filePath, ImageFormat imageFormat) {
        this.bufferedImage = bufferedImage;
        this.numberOfColumn = bufferedImage.getWidth();
        this.numberOfLine = bufferedImage.getHeight();
        this.filePath = filePath;
        this.imageFormat = imageFormat;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public int getNumberOfColumn() {
        return numberOfColumn;
    }

    public void setNumberOfColumn(int numberOfColumn) {
        this.numberOfColumn = numberOfColumn;
    }

    public int getNumberOfLine() {
        return numberOfLine;
    }

    public void setNumberOfLine(int numberOfLine) {
        this.numberOfLine = numberOfLine;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ImageFormat getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(ImageFormat imageFormat) {
        this.imageFormat = imageFormat;
    }
}
