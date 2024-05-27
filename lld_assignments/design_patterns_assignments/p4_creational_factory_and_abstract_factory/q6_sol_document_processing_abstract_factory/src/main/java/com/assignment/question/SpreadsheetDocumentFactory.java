package com.assignment.question;

import com.assignment.question.parser.DocumentParser;
import com.assignment.question.parser.SpreadsheetDocumentParser;
import com.assignment.question.printer.DocumentPrinter;
import com.assignment.question.printer.SpreadsheetDocumentPrinter;
import com.assignment.question.processor.DocumentProcessor;
import com.assignment.question.processor.SpreadsheetDocumentProcessor;

// Concrete factory class for creating spreadsheet documents
public class SpreadsheetDocumentFactory extends DocumentFactory {

    // Methods for creating different parts of a spreadsheet document
    @Override
    public DocumentProcessor createProcessor(String name) {
        return new SpreadsheetDocumentProcessor(name);
    }

    @Override
    public DocumentParser createParser(String path) {
        return new SpreadsheetDocumentParser(path);
    }

    @Override
    public DocumentPrinter createPrinter(DocumentProcessor documentProcessor) {
        return new SpreadsheetDocumentPrinter(documentProcessor);
    }

    // Method for getting the type of document the factory supports
    @Override
    public DocumentType supportsType() {
        return DocumentType.SPREAD_SHEET;
    }
}
