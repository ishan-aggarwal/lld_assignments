package com.assignment.question;

// Concrete class for processing a presentation document
public class PresentationDocumentProcessor extends DocumentProcessor {
    // Constructor for the PresentationDocumentProcessor class
    public PresentationDocumentProcessor(String documentName) {
        super(documentName);
    }

    // Method for processing the presentation document
    @Override
    public void processDocument() {
        System.out.println("Processing a presentation document: " + getDocumentName());
    }

    // Method for getting the type of document the processor supports
    @Override
    public DocumentType supportsType() {
        return DocumentType.PRESENTATION;
    }

    // Additional method specific to the presentation document
    public void addSlide() {
        System.out.println("Adding a slide to the presentation.");
    }
}

