package com.assignment.question;

import com.assignment.question.models.Image;
import com.assignment.question.services.*;

public class ImageEditingFacade {

    private final ImageLoader imageLoader;
    private final FilterService filterService;
    private final ImageModifier imageModifier;
    private final ImageWriter imageWriter;
    private final AnalyticsService analyticsService;

    public ImageEditingFacade(ImageLoader imageLoader, FilterService filterService, ImageModifier imageModifier, ImageWriter imageWriter, AnalyticsService analyticsService) {
        this.imageLoader = imageLoader;
        this.filterService = filterService;
        this.imageModifier = imageModifier;
        this.imageWriter = imageWriter;
        this.analyticsService = analyticsService;
    }

    public Image loadImage(String imagePath) {
        return imageLoader.loadImage(imagePath);
    }

    public void applyFilter(Image image, String filterType) {
        filterService.applyFilter(image, filterType);
    }

    public void adjustBrightness(Image image, int brightness) {
        imageModifier.adjustBrightness(image, brightness);
    }

    public void saveImage(Image image) {
        imageWriter.saveImage(image);
    }

    public void store(Image image) {
        analyticsService.store(image);
    }

    // The process method provides a simplified interface for performing image processing.
    public void process(String imagePath, String filterType, int brightness) {

        // Step 1: Load the image
        Image image = loadImage(imagePath);

        // Step 2: Apply the filter to the image
        applyFilter(image, filterType);

        // Step 3: Adjust the brightness of the image
        adjustBrightness(image, brightness);

        // Step 4: Save the image
        saveImage(image);

        // Step 5: Store the image in the analytics service
        store(image);
    }


}