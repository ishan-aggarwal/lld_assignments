package com.assignment.question;

import com.assignment.question.*;

// Factory class for creating document processors
public class DocumentProcessorFactory {
    // Factory method for creating the appropriate document processor based on the document type
    public static DocumentProcessor createDocumentProcessor(DocumentType documentType, String documentName) {
        return switch (documentType) {
            case TEXT -> new TextDocumentProcessor(documentName);
            case PRESENTATION -> new PresentationDocumentProcessor(documentName);
            case SPREAD_SHEET -> new SpreadsheetDocumentProcessor(documentName);
            default -> throw new IllegalArgumentException("Unsupported document type: " + documentType);
        };
    }
}

/*
    In this code, the DocumentProcessor class is an abstract class that declares methods for processing
    a document and getting the type of document the processor supports.
    The DocumentProcessorFactory class is a factory class that has a factory method createDocumentProcessor
    for creating the appropriate DocumentProcessor based on the DocumentType.
    The PresentationDocumentProcessor, SpreadsheetDocumentProcessor, and TextDocumentProcessor classes are
    concrete classes that implement these methods to process presentation, spreadsheet, and text documents,
    respectively.

    This is a classic implementation of the Factory Method Pattern.
    This pattern separates the details of implementation of a set of objects from their general usage
    and relies on object composition: object creation methods are implemented in methods exposed
    in the factory interface.
 */
