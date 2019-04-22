package main;

import main.creator.ImageCreator;
import main.data.ImageContainer;
import main.data.ImageFormat;
import main.io.ImageFileManager;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        String test = "image/create.jpg";
        String lenaIn = "image/lena.jpg";
        String lenaOut = "image/lena_out.jpg";
        System.out.println("Something");
        ImageCreator imageCreator = new ImageCreator();
        ImageFileManager imageFileManager = new ImageFileManager();
        ImageContainer empty = imageCreator.createEmpty(test, ImageFormat.JPG);
        imageFileManager.saveForDisk(empty);
        //----------------------
        ImageContainer lenaImage = imageFileManager.loadFromDisk(lenaIn);
        lenaImage.setFilePath(lenaOut);
        imageFileManager.saveForDisk(lenaImage);

    }
}
