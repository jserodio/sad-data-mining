package bayes.NaiveBayes;

import weka.core.Instances;


public class Main {
	
   public static void main(String[] args) throws Exception {

	   	Instances train; 
	   	Instances test;

		String pathTrain = args[0];
		String pathTest = args[1];
		train = Data.getData().cargar(pathTrain);
		test = Data.getData().cargar(pathTest);
		System.out.println("The files " + pathTrain + " and " + pathTest + " were loaded.");	
		
		Classifier c = new Classifier();
		
		c.naiveBayes(train,test);
   }
}

