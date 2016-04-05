package fss.InfoGain;

import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;

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
		
		// Filtro Feature Subset Selection
		AttributeSelection filterAtt = new AttributeSelection();

		// Attribute Evaluator: Info Gain Attribute
		filterAtt.setEvaluator(new InfoGainAttributeEval());
		
		// Search Method: Ranker
		Ranker r = new Ranker();
		r.setNumToSelect(-1);
		r.setThreshold(0.000848);
		filterAtt.setSearch(r);
		
		// Aplicar filtro
		filterAtt.setInputFormat(data);
		newData = Filter.useFilter(data, filterAtt);
			
		return newData;
	}
}
