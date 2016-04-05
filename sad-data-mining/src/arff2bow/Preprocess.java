package arff2bow;

import java.io.File;
import java.io.IOException;

import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;
import weka.filters.unsupervised.attribute.InterquartileRange;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.unsupervised.attribute.StringToWordVector;
import weka.filters.unsupervised.instance.RemoveWithValues;

public class Preprocess {

	private static Preprocess miPreprocess;
	
	private Preprocess () {

	}
	
	public static Preprocess getPreprocess () {
		if (miPreprocess == null){
			miPreprocess = new Preprocess();
		}
		return miPreprocess;
	}
	
	public Instances filtrar(Instances data) throws Exception{
		Instances newData;
		
		// Filtro StringToWordVector
		StringToWordVector filterSTWV = new StringToWordVector();
		filterSTWV.setAttributeNamePrefix("_bg");		// bag of words ;)
		filterSTWV.setLowerCaseTokens(true);	// no distinguir entre palabras mayusculas y min�sculas
		filterSTWV.setOutputWordCounts(true);	// indicar el n�mero de veces que aparece la palabra en el mensaje
		
		// Aplicar filtro
		// filterSTWV.setInputFormat(data);
		newData = Filter.useFilter(data, filterSTWV);
		
		return newData;
	}

	public void saveFile(Instances dataSet) throws IOException{
			 ArffSaver saver = new ArffSaver();
			 saver.setInstances(dataSet);
			 saver.setFile(new File("assets/test.arff"));
			 // saver.setDestination(new File("./data/test.arff"));   // **not** necessary in 3.5.4 and later
			 saver.writeBatch();
	}
}
