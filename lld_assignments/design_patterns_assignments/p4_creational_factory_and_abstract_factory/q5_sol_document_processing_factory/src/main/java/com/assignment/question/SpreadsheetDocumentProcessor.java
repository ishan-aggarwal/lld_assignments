package com.assignment.question;

// Concrete class for processing a spreadsheet document
public class SpreadsheetDocumentProcessor extends DocumentProcessor {
    // Constructor for the SpreadsheetDocumentProcessor class
    public SpreadsheetDocumentProcessor(String documentName) {
        super(documentName);
    }

    // Method for processing the spreadsheet document
    @Override
    public void processDocument() {
        System.out.println("Processing a spreadsheet document: " + getDocumentName());
    }

    // Method for getting the type of document the processor supports
    @Override
    public DocumentType supportsType() {
        return DocumentType.SPREAD_SHEET;
    }

    // Additional method specific to the spreadsheet document
    public void performDataAnalysis() {
        System.out.println("Performing data analysis on the spreadsheet.");
    }
}
