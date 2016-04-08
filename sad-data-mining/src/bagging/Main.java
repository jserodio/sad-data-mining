package bagging;

import weka.classifiers.Evaluation;
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
    	Evaluation e_current = null;
    	Evaluation e_max = null;
    	Double max = 0.0;
    	int maxi = 0;
    	
    	System.out.println("");
    	System.out.println("");
    	System.out.println("Starting bagging for NaiveBayes");
    	System.out.println("");
		for (int i=1; i<=4; i++) {
			e_current = c.baggingNaiveBayes(train,dev,i);
			if (e_current.fMeasure(1) > max){
				e_max = e_current;
				max = e_current.fMeasure(1);
				maxi = i;
			}
		}
		
    	System.out.println("Resultados del barrido de parametros...");	    	
    	System.out.println("Optimal num iterations for bagging is:\t" + maxi);
    	System.out.println("Maximum F-measure for minority class:\t" + e_max.fMeasure(1));
		System.out.println(e_max.toSummaryString());
		System.out.println(e_max.toClassDetailsString());
		System.out.println(e_max.toMatrixString());
		
		c = new Classifier();
    	e_current = null;
    	e_max = null;
    	max = 0.0;
    	maxi = 0;
		
		System.out.println("");
		System.out.println("");
		System.out.println("Starting bagging for ZeroR");
		System.out.println("");
		
		for (int i=1; i<=4; i++) {
			e_current = c.baggingZeroR(train,dev,i);
			if (e_current.fMeasure(1) > max){
				e_max = e_current;
				max = e_current.fMeasure(1);
				maxi = i;
			}
		}
		
    	System.out.println("Resultados del barrido de parametros...");	    	
    	System.out.println("Optimal num iterations for bagging is:\t" + maxi);
    	System.out.println("Maximum F-measure for minority class:\t" + e_max.fMeasure(1));
		System.out.println(e_max.toSummaryString());
		System.out.println(e_max.toClassDetailsString());
		System.out.println(e_max.toMatrixString());
		
		c = new Classifier();
    	e_current = null;
    	e_max = null;
    	max = 0.0;
    	maxi = 0;
		
		System.out.println("");
		System.out.println("");
		System.out.println("Starting bagging for OneR");
		System.out.println("");
		
		for (int i=1; i<=4; i++) {
			e_current = c.baggingOneR(train,dev,i);
			if (e_current.fMeasure(1) > max){
				e_max = e_current;
				max = e_current.fMeasure(1);
				maxi = i;
			}
		}
		
//    	e_current = c.bagging(train,dev,2);
//    	e_max = e_current;
    	
    	System.out.println("Resultados del barrido de parametros...");	    	
    	System.out.println("Optimal num iterations for bagging is:\t" + maxi);
    	System.out.println("Maximum F-measure for minority class:\t" + e_max.fMeasure(1));
		System.out.println(e_max.toSummaryString());
		System.out.println(e_max.toClassDetailsString());
		System.out.println(e_max.toMatrixString());
		System.out.println("End.");
   }
}

