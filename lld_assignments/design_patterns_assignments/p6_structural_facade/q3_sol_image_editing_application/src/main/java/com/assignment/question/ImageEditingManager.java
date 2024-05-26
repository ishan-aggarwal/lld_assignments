package com.assignment.question;

import com.assignment.question.models.Image;
import com.assignment.question.services.*;

public class ImageEditingManager {
    private final ImageEditingFacade imageEditingFacade;

    public ImageEditingManager(ImageLoader imageLoader, FilterService filterService, ImageModifier imageModifier, ImageWriter imageWriter, AnalyticsService analyticsService) {
        imageEditingFacade = new ImageEditingFacade(imageLoader,
                filterService,
                imageModifier,
                imageWriter,
                analyticsService);
    }

    public void editImage(String imagePath, String filterType, int brightness) {
        Image image = imageEditingFacade.loadImage(imagePath);

        imageEditingFacade.applyFilter(image, filterType);

        imageEditingFacade.adjustBrightness(image, brightness);

        imageEditingFacade.saveImage(image);

        imageEditingFacade.store(image);
    }
}

/*
    In this code, the ImageEditingFacade class acts as a facade for various services involved in image processing.
    It provides a simplified process method for performing image processing.
    This method loads the image, applies a filter to the image, adjusts the brightness of the image,
    saves the image, and stores the image in the analytics service.
    The ImageEditingManager class uses the ImageEditingFacade facade to edit an image.

    This is a classic implementation of the Facade Pattern.
    It hides the complexities of the subsystem from the client by providing a simple interface.
    The Facade Pattern is a structural design pattern that provides a simplified interface to a library,
    a framework, or any other complex set of classes.
 */