package bayes.NaiveBayes;

import weka.core.Instances;


public class Main {
	
   public static void main(String[] args) throws Exception {

	   	Instances train; 
	   	Instances dev;

		String pathTrain = args[0];
		String pathDev = args[1];
		
		train = Data.getData().loadFile(pathTrain);
		dev = Data.getData().loadFile(pathDev);
		
		Classifier c = new Classifier();
		
		c.naiveBayes(train,dev);
   }
}

