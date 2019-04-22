package main;

import main.creator.ImageCreator;
import main.data.ImageContainer;
import main.data.ImageFormat;
import main.io.ImageFileManager;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Something");
        ImageCreator imageCreator=new ImageCreator();
        ImageContainer empty = imageCreator.createEmpty("test/test", ImageFormat.JPG, 100, 100);
        ImageFileManager.saveForDisk(empty);
    }
}
