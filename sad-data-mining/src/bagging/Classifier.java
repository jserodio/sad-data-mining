package bagging;

import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.meta.Bagging;
import weka.core.Instances;

public class Classifier {

	Bagging classifier;
	long start;
	long stop;
	double seconds;
	
	public Classifier() {
		classifier = new Bagging();
		
	}

	public Evaluation bagging(Instances train, Instances dev, int it) throws Exception{
		 				
		Evaluation evaluator;
		
		start = System.nanoTime();
		
		evaluator = new Evaluation(train);	
		
		train.randomize(new Random(1));

		classifier.buildClassifier(train);
		// options for bagging
		classifier.setClassifier(new NaiveBayes());
		classifier.setNumIterations(it);
			
		evaluator.evaluateModel(classifier, dev);
				
		// time
		stop = System.nanoTime();
		seconds = (double)(stop - start) / 1000000000.0;
		System.out.println("Elapsed time: " + seconds);
		
		return evaluator;
	
	}

}
