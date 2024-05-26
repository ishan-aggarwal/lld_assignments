package com.assignment.question;

import com.assignment.question.models.*;
import com.assignment.question.services.AnalysisAlgorithmService;
import com.assignment.question.services.DataCollectionService;
import com.assignment.question.services.DataPreprocessingService;
import com.assignment.question.services.VisualizationService;

public class DataAnalysisManager {

    private final DataAnalysisFacade dataAnalysisFacade;

    public DataAnalysisManager(DataCollectionService dataCollectionService,
                               DataPreprocessingService dataPreprocessingService,
                               AnalysisAlgorithmService analysisAlgorithmService,
                               VisualizationService visualizationService) {

        this.dataAnalysisFacade = new DataAnalysisFacade(dataCollectionService,
                dataPreprocessingService,
                analysisAlgorithmService,
                visualizationService);
    }

    public AnalysisResult performFullAnalysis(DataCollectionParams collectionParams,
                                              PreprocessingOptions preprocessingOptions,
                                              AnalysisAlgorithmConfig algorithmConfig) {
        // Step 1: Collect data
        DataCollectionResult collectionResult = dataAnalysisFacade.collectData(collectionParams);

        // Step 2: Preprocess data
        PreprocessedData preprocessedData = dataAnalysisFacade.preprocessData(collectionResult.getData(), preprocessingOptions);

        // Step 3: Apply analysis algorithms
        AnalysisResult analysisResult = dataAnalysisFacade.applyAnalysisAlgorithms(preprocessedData, algorithmConfig);

        // Step 4: Visualize results
        dataAnalysisFacade.visualizeResults(analysisResult);

        return analysisResult;
    }
}

/*
    In this code, the DataAnalysisFacade class acts as a facade for various services involved in data analysis.
    It provides a simplified process method for performing data analysis.
    This method collects data, preprocesses data, applies analysis algorithms, and visualizes results.
    The DataAnalysisManager class uses the DataAnalysisProcessor facade to perform data analysis.

    This is a classic implementation of the Facade Pattern.
    It hides the complexities of the subsystem from the client by providing a simple interface.
    The Facade Pattern is a structural design pattern that provides a simplified interface to a library,
    a framework, or any other complex set of classes.
 */
