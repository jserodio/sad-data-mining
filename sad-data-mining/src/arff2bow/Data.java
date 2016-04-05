package arff2bow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import weka.core.Instances;
import weka.core.converters.ArffSaver;

public class Data {
	
	private static Data miData;
	
	private Data (){ }
	
	public static Data getData (){
		if ( miData == null ) {
			miData = new Data();
		}
		return miData;
	}

	public Instances loadFile(String path){
		FileReader fi=null;

		try {
		fi= new FileReader(path); 
		} catch (FileNotFoundException e) {
		System.out.println("ERROR: File not found "+path);
		}

		Instances data=null;
		try {
		data = new Instances(fi);
		} catch (IOException e) {
		System.out.println("ERROR: Check data inside the file: "+path);
		} catch (NullPointerException e) {
			System.out.println("ERROR: File is missing.");
		}

		try {
		fi.close();
		} catch (IOException e) {
			System.out.println("ERROR: Closing the file.");
		}

		data.randomize(new Random(42));
		

		if (data.attribute("class") != null){
			data.setClassIndex(data.attribute("class").index());
		} else {
			data.setClassIndex(data.numAttributes()-1);
		}

		return data;
	}
	
	public void saveFile(Instances dataSet, String savePath) throws IOException{
		 ArffSaver saver = new ArffSaver();
		 saver.setInstances(dataSet);
		 saver.setFile(new File(savePath));
		 saver.writeBatch();
		 System.out.println("The file '" + savePath + "' was saved.");	
	}
	
}
