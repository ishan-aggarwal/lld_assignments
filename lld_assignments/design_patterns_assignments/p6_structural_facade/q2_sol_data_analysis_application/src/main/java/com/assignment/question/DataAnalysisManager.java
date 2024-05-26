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
