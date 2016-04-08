package bagging;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.meta.Bagging;
import weka.classifiers.rules.OneR;
import weka.classifiers.rules.ZeroR;
import weka.core.Instances;

public class Classifier {

	
	
	public Classifier() {
		
	}

	public Evaluation baggingNaiveBayes(Instances train, Instances dev, int it) throws Exception{			
		Evaluation evaluator = null;
		Bagging classifier = new Bagging();
				
		classifier.buildClassifier(train);
		// options for bagging
		classifier.setBagSizePercent(100);
		classifier.setSeed(1);
		classifier.setNumIterations(it);
		classifier.setClassifier(new NaiveBayes());			
		evaluator = new Evaluation(train);		
		evaluator.evaluateModel(classifier, dev);	
		return evaluator;
	}

	public Evaluation baggingZeroR(Instances train, Instances dev, int it) throws Exception{			
		Evaluation evaluator = null;
		Bagging classifier = new Bagging();
				
		classifier.buildClassifier(train);
		// options for bagging
		classifier.setBagSizePercent(100);
		classifier.setSeed(1);
		classifier.setNumIterations(it);
		classifier.setClassifier(new ZeroR());			
		evaluator = new Evaluation(train);		
		evaluator.evaluateModel(classifier, dev);	
		return evaluator;
	}
	
	public Evaluation baggingOneR(Instances train, Instances dev, int it) throws Exception{			
		Evaluation evaluator = null;
		Bagging classifier = new Bagging();
				
		classifier.buildClassifier(train);
		// options for bagging
		classifier.setBagSizePercent(100);
		classifier.setSeed(1);
		classifier.setNumIterations(it);
		classifier.setClassifier(new OneR());			
		evaluator = new Evaluation(train);		
		evaluator.evaluateModel(classifier, dev);	
		return evaluator;
	}
	
}
