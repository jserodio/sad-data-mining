package fss.tfidf;

import arff2bow.Data;
import fss.InfoGain.Preprocess;
import weka.core.Instances;


public class Main {
	
   public static void main(String[] args) throws Exception {
	   
	   // Run Configurations -> program arguments
	   // exportedJar/assets/spamTrain.arff.Bow.arff exportedJar/assets/spamDev.arff.Bow.arff  
	   
		Instances train;
	   	Instances dev;
	   	
	   	Instances trainTfIdf;
	   	Instances devTfIdf;
	   	
	   	String loadPathTrain = args[0]; // ruta para cargar fichero train
		String loadPathDev = args[1]; // ruta para cargar fichero dev
		
		train = Data.getData().loadFile(loadPathTrain);
		dev = Data.getData().loadFile(loadPathDev);
		
		
		trainTfIdf = Preprocess.getPreprocess().filtrar(train);
		devTfIdf = Preprocess.getPreprocess().filtrar(dev);
		
		System.out.println("Train instance number: " + train.numInstances());
		System.out.println("Dev instance number: " + dev.numInstances());
		System.out.println("TrainTFIDF instance number: " + trainTfIdf.numInstances());
		System.out.println("DevTFIDF instance number: " + devTfIdf.numInstances());

		Data.getData().saveFile(trainTfIdf, loadPathTrain+".FSS_TFIDF.arff");
		Data.getData().saveFile(devTfIdf, loadPathDev+".FSS_TFIDF.arff");
   }
}

