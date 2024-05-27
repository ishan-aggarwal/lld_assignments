package com.assignment.question;

import com.assignment.question.parser.DocumentParser;
import com.assignment.question.parser.TextDocumentParser;
import com.assignment.question.printer.DocumentPrinter;
import com.assignment.question.printer.TextDocumentPrinter;
import com.assignment.question.processor.DocumentProcessor;
import com.assignment.question.processor.TextDocumentProcessor;

// Concrete factory class for creating text documents
public class TextDocumentFactory extends DocumentFactory {

    // Methods for creating different parts of a text document
    @Override
    public DocumentProcessor createProcessor(String name) {
        return new TextDocumentProcessor(name);
    }

    @Override
    public DocumentParser createParser(String path) {
        return new TextDocumentParser(path);
    }

    @Override
    public DocumentPrinter createPrinter(DocumentProcessor documentProcessor) {
        return new TextDocumentPrinter(documentProcessor);
    }

    // Method for getting the type of document the factory supports
    @Override
    public DocumentType supportsType() {
        return DocumentType.TEXT;
    }
}
