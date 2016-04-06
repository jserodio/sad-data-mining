package bayes.NaiveBayes;

import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;

public class Classifier {

	NaiveBayes estimador;

	public Classifier() {
		estimador= new NaiveBayes();//Naive Bayes
	}


	public void naiveBayes(Instances train, Instances dev) throws Exception{
		 				
		Evaluation evaluator;
								
		evaluator = new Evaluation(train);	
		
		train.randomize(new Random(1));

		estimador.buildClassifier(train);	
			
		evaluator.evaluateModel(estimador, dev);
		
		System.out.println(evaluator.toSummaryString());
		System.out.println(evaluator.toClassDetailsString());
		System.out.println(evaluator.toMatrixString());
					
	}

}
