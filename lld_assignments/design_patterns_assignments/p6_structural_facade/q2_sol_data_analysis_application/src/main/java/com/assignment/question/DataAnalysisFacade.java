package com.assignment.question;

import java.util.*;

import com.assignment.question.models.*;
import com.assignment.question.services.AnalysisAlgorithmService;
import com.assignment.question.services.DataCollectionService;
import com.assignment.question.services.DataPreprocessingService;
import com.assignment.question.services.VisualizationService;

public class DataAnalysisFacade {

    private final DataCollectionService dataCollectionService;
    private final DataPreprocessingService dataPreprocessingService;
    private final AnalysisAlgorithmService analysisAlgorithmService;
    private final VisualizationService visualizationService;

    public DataAnalysisFacade(DataCollectionService dataCollectionService,
                              DataPreprocessingService dataPreprocessingService,
                              AnalysisAlgorithmService analysisAlgorithmService,
                              VisualizationService visualizationService) {

        this.dataCollectionService = dataCollectionService;
        this.dataPreprocessingService = dataPreprocessingService;
        this.analysisAlgorithmService = analysisAlgorithmService;
        this.visualizationService = visualizationService;

    }

    public DataCollectionResult collectData(DataCollectionParams collectionParams) {
        return dataCollectionService.collectData(collectionParams);
    }

    public PreprocessedData preprocessData(List<Object> rawData, PreprocessingOptions preprocessingOptions) {
        return dataPreprocessingService.preprocessData(rawData, preprocessingOptions);
    }

    public AnalysisResult applyAnalysisAlgorithms(PreprocessedData preprocessedData, AnalysisAlgorithmConfig algorithmConfig) {
        return analysisAlgorithmService.applyAnalysisAlgorithms(preprocessedData, algorithmConfig);
    }

    public void visualizeResults(AnalysisResult analysisResult) {
        visualizationService.visualizeResults(analysisResult);
    }

    // The process method provides a simplified interface for performing data analysis.
    public AnalysisResult process(DataCollectionParams collectionParams,
                                  PreprocessingOptions preprocessingOptions,
                                  AnalysisAlgorithmConfig algorithmConfig) {
        // Step 1: Collect data
        DataCollectionResult collectionResult = collectData(collectionParams);

        // Step 2: Preprocess data
        PreprocessedData preprocessedData = preprocessData(collectionResult.getData(), preprocessingOptions);

        // Step 3: Apply analysis algorithms
        AnalysisResult analysisResult = applyAnalysisAlgorithms(preprocessedData, algorithmConfig);

        // Step 4: Visualize results
        visualizeResults(analysisResult);

        return analysisResult;
    }
}