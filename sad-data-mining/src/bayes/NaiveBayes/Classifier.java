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


	public void naiveBayes(Instances train, Instances test) throws Exception{
		 				
		Evaluation evaluator;
								
		evaluator = new Evaluation(train);	
		
		// randomizar con 1, como en MORE OPTIONS -> Random seed for XVal / % Split = 1 en Weka GUI
		train.randomize(new Random(1));

		
		// Aprender con el 70% de las instancias (train)
		// creando el clasificador con el algoritmo Naive Bayes.
		estimador.buildClassifier(train);	
			
		// Dejar que prediga la clase estimada por el modelo para cada instancia del test
		// y así después podremos comparar la clase real y la estimada
		evaluator.evaluateModel(estimador, test);
		
		System.out.println(evaluator.toSummaryString());
		System.out.println(evaluator.toClassDetailsString());
		System.out.println(evaluator.toMatrixString());
					
	}

}
