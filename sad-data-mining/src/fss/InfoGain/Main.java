package fss.InfoGain;

import arff2bow.Data;
import weka.core.Instances;


public class Main {
	
   public static void main(String[] args) throws Exception {

	    // Run Configurations -> program arguments
	    // exportedJar/assets/spamTrainBOW.arff exportedJar/assets/spamTestBow.arff exportedJar/assets/spamDevBow.arff   
	   
	   	Instances dataBow; 	
	   	Instances dataGain;
	   	
	   	Instances train;
	   	Instances test;
	   	Instances dev;
	   	
	   	Instances trainGain = null;
	   	Instances testGain = null;
	   	Instances devGain = null;
	   	
	   	String loadPathTrain = args[0]; // ruta para cargar fichero train
		String loadPathTest = args[1]; // ruta para cargar fichero test
		String loadPathDev = args[2]; // ruta para cargar fichero dev
		
		train = Data.getData().loadFile(loadPathTrain);
		test = Data.getData().loadFile(loadPathTest);
		dev = Data.getData().loadFile(loadPathDev);
		
		dataBow = new Instances(train);
		
		for (int i=0; i<=test.numInstances()-1; i++) {
			dataBow.add(test.instance(i));
		}
		
		for (int i=0; i<=dev.numInstances()-1; i++) {
			dataBow.add(dev.instance(i));
		}
		
		dataGain = Preprocess.getPreprocess().filtrar(dataBow);
		
		System.out.println("Data instance number: " + dataBow.numInstances());
		System.out.println("DataBow instance number: " + dataGain.numInstances());
		System.out.println("Train instance number: " + train.numInstances());
		System.out.println("Test instance number: " + test.numInstances());
		System.out.println("Dev instance number: " + dev.numInstances());

		trainGain = new Instances(train,1);
		trainGain.delete();
		
		testGain = new Instances(test,1);
		testGain.delete();
		
		devGain = new Instances(dev,1);
		devGain.delete();
		
		int i=0;
		
		while(i<=train.numInstances()-1)
		{
			trainGain.add(dataGain.instance(i));
			i++;
		}
		
		while(i<=(test.numInstances()+train.numInstances())-1)
		{
			testGain.add(dataGain.instance(i));
			i++;
		}
		
		while(i<=dataGain.numInstances()-1)
		{
			devGain.add(dataGain.instance(i));
			i++;
		}
		
		Data.getData().saveFile(dataGain, loadPathTrain+".FSS_InfoGain.arff");
		Data.getData().saveFile(dataGain, loadPathTest+".FSS_InfoGain.arff");
		Data.getData().saveFile(dataGain, loadPathDev+".FSS_InfoGain.arff");
   }
}

