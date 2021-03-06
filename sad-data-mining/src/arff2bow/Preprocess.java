package arff2bow;

import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;
import weka.filters.unsupervised.instance.SparseToNonSparse;

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
		filterSTWV.setAttributeNamePrefix("bg_");		// bag of words ;)
		filterSTWV.setLowerCaseTokens(true);	// no distinguir entre palabras mayusculas y min�sculas
		filterSTWV.setOutputWordCounts(true);	// indicar el n�mero de veces que aparece la palabra en el mensaje
		
		// Aplicar filtro
		filterSTWV.setInputFormat(data);
		newData = Filter.useFilter(data, filterSTWV);
		
		// Filtro SparseToNonSparse
		SparseToNonSparse filter2NonSparse = new SparseToNonSparse();
		filter2NonSparse.setInputFormat(newData);
		newData = Filter.useFilter(newData, filter2NonSparse);
		
		return newData;
	}
}
