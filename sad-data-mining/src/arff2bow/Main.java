package arff2bow;

import weka.core.Instances;


public class Main {
	
   public static void main(String[] args) throws Exception {

	   	Instances data; 	
	   	Instances dataBow;
	   	
		String path = args[0];
		data = Data.getData().cargar(path);
		System.out.println("The file " + path + " was loaded.");	
		
		dataBow = Preprocess.getPreprocess().filtrar(data);
		

   }
}

