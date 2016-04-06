package fss.InfoGain;

import weka.core.Instances;


public class Main {
	
   public static void main(String[] args) throws Exception {

	    // Run Configurations -> program arguments
	    // exportedJar/assets/spamTrainBOW.arff exportedJar/assets/spamTrainBOW_FSS_InfoGain.arff   
	   
	   	Instances data; 	
	   	Instances newData;
	   	
		String loadPath = args[0]; // ruta para cargar fichero
		String savePath = args[1]; // ruta guardar fichero
		
		data = Data.getData().loadFile(loadPath);
		System.out.println("The file '" + loadPath + "' was loaded.");	
		
		newData = Preprocess.getPreprocess().filtrar(data);

		Data.getData().saveFile(newData, savePath);
   }
}

