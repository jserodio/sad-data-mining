package arff2bow;

import weka.core.Instances;


public class Main {
	
   public static void main(String[] args) throws Exception {

	   	Instances data; 	
	   	Instances dataBow;
	   	
		String loadPath = args[0]; // ruta para cargar fichero
		String savePath = args[1]; // ruta guardar fichero
		data = Data.getData().loadFile(loadPath);
		System.out.println("The file '" + loadPath + "' was loaded.");	
		
		dataBow = Preprocess.getPreprocess().filtrar(data);

		Data.getData().saveFile(dataBow, savePath);
   }
}

