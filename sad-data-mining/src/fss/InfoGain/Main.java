package fss.InfoGain;

import arff2bow.Data;
import weka.core.Instances;


public class Main {
	
   public static void main(String[] args) throws Exception {

	    // Run Configurations -> program arguments
	    // exportedJar/assets/spamTrain.arff.Bow.arff exportedJar/assets/spamDev.arff.Bow.arff   
	   
	   	
	   	Instances train;
	   	Instances dev;
	   	
	   	Instances trainGain;
	   	Instances devGain;
	   	
	   	String loadPathTrain = args[0]; // ruta para cargar fichero train
		String loadPathDev = args[1]; // ruta para cargar fichero dev
		
		train = Data.getData().loadFile(loadPathTrain);
		dev = Data.getData().loadFile(loadPathDev);
		
		
		trainGain = Preprocess.getPreprocess().filtrar(train);
		devGain = Preprocess.getPreprocess().filtrar(dev);
		
		System.out.println("Train instance number: " + train.numInstances());
		System.out.println("Dev instance number: " + dev.numInstances());
		System.out.println("TrainGain instance number: " + trainGain.numInstances());
		System.out.println("DevGain instance number: " + devGain.numInstances());
		
		Data.getData().saveFile(trainGain, loadPathTrain+".FSS_InfoGain.arff");
		Data.getData().saveFile(devGain, loadPathDev+".FSS_InfoGain.arff");
   }
}

