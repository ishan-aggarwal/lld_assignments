package com.assignment.question;

import com.assignment.question.parser.DocumentParser;
import com.assignment.question.printer.DocumentPrinter;
import com.assignment.question.processor.DocumentProcessor;

// Abstract factory class
public abstract class DocumentFactory {

    // Abstract methods for creating different parts of a document
    public abstract DocumentProcessor createProcessor(String documentName);

    public abstract DocumentParser createParser(String path);

    public abstract DocumentPrinter createPrinter(DocumentProcessor processor);

    // Abstract method for getting the type of document the factory supports
    public abstract DocumentType supportsType();
}

/*
    In this code, the DocumentFactory class is an abstract factory class that declares methods
    for creating different parts of a document (DocumentProcessor, DocumentParser, and DocumentPrinter)
    and a method for getting the type of document the factory supports. The SpreadsheetDocumentFactory
    and TextDocumentFactory classes are concrete factory classes that implement these methods to
    create spreadsheet and text documents, respectively.

    This is a classic implementation of the Abstract Factory Pattern.
    The Abstract Factory Pattern provides an interface for creating families of related or
    dependent objects without specifying their concrete classes. This pattern separates the details
    of implementation of a set of objects from their general usage and relies on object composition:
    object creation methods are implemented in methods exposed in the factory interface.
 */