package fss.tfidf;

import weka.core.Instances;


public class Main {
	
   public static void main(String[] args) throws Exception {
	   
	   // Run Configurations -> program arguments
	   // exportedJar/assets/spamTrain.arff.Bow.arff exportedJar/assets/spamDev.arff.Bow.arff  
	   
	   	Instances data; 	
	   	Instances newData;
	   	
		String loadPath = args[0]; // ruta para cargar fichero
		String savePath = args[1]; // ruta guardar fichero
		
		data = Data.getData().loadFile(loadPath);
		
		newData = Preprocess.getPreprocess().filtrar(data);

		Data.getData().saveFile(newData, savePath);
   }
}

