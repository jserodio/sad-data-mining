package arff2bow;

import weka.core.Instances;


public class Main {
	
   public static void main(String[] args) throws Exception {

	    // Run Configurations -> program arguments
	    // exportedJar/assets/spamTrain.arff exportedJar/assets/spamTest.arff exportedJar/assets/spamDev.arff
	   
	   	Instances data;
	   	Instances dataBow;
	   	
	   	Instances train;
	   	Instances test;
	   	Instances dev;
	   	
	   	Instances trainBow = null;
	   	Instances testBow = null;
	   	Instances devBow = null;
	   	
		String loadPathTrain = args[0]; // ruta para cargar fichero train
		String loadPathTest = args[1]; // ruta para cargar fichero test
		String loadPathDev = args[2]; // ruta para cargar fichero dev
		
		train = Data.getData().loadFile(loadPathTrain);
		test = Data.getData().loadFile(loadPathTest);
		dev = Data.getData().loadFile(loadPathDev);
		
		data = new Instances(train);
		
//		for (int i=0; i<=train.numInstances()-1; i++) {
//			data.add(train.instance(i));
//		}
		
		for (int i=0; i<=test.numInstances()-1; i++) {
			data.add(test.instance(i));
		}
		
		for (int i=0; i<=dev.numInstances()-1; i++) {
			data.add(dev.instance(i));
		}
				
		dataBow = Preprocess.getPreprocess().filtrar(data);
		
		System.out.println("Data instance number: " + data.numInstances());
		System.out.println("DataBow instance number: " + dataBow.numInstances());
		System.out.println("Train instance number: " + train.numInstances());
		System.out.println("Test instance number: " + test.numInstances());
		System.out.println("Dev instance number: " + dev.numInstances());
		
		trainBow = new Instances(train,1);
		trainBow.delete();
		
		testBow = new Instances(test,1);
		testBow.delete();
		
		devBow = new Instances(dev,1);
		devBow.delete();
		
		int i=0;
		
		while(i<=train.numInstances()-1)
		{
			trainBow.add(dataBow.instance(i));
			i++;
		}
		
		while(i<=(test.numInstances()+train.numInstances())-1)
		{
			testBow.add(dataBow.instance(i));
			i++;
		}
		
		while(i<=dataBow.numInstances()-1)
		{
			devBow.add(dataBow.instance(i));
			i++;
		}
		
		Data.getData().saveFile(dataBow, loadPathTrain+".Bow.arff");
		Data.getData().saveFile(dataBow, loadPathTest+".Bow.arff");
		Data.getData().saveFile(dataBow, loadPathDev+".Bow.arff");
   }
}

