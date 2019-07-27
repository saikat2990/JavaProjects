package decision;

import java.util.ArrayList;

/*
 totalPositive = P
 totalNegative = N
 
 truePositive = TP
 trueNegtive = TN
 falsePositive = FP
 falseNegative = FN
 
 truePositiveRate = TPR
 trueNegativeRate = TNR
 falsePositiveRate = FPR
 falseNegativeRate = FNR
 
 TPR = TP / p = TP / (TP+FN) 
 TNR = TN / N = TN / (TN+FP)
 FPR = FP / N = FP / (FP+TN) = 1 - TNR
 FNR = FN / p = FN / (FN+TP) = 1 - TPR
 
 precision = TP / (TP+FP)
 recall = TP / (TP+FN) 
 accuracy = (TP + TN) / (TP+TN+FP+FN)
 F1score = (2*precision*recall)  / (precision + recall)
  
 */


public class ResultEvaluation {

	private ArrayList<String> testAsnwer = new ArrayList<String>();
	private ArrayList<String> originalAsnwer = new ArrayList<String>();
	
	private double accuracy;
	
	public ResultEvaluation(ArrayList<String> testAsnwer,ArrayList<String> originalAsnwer) {
		this.testAsnwer = testAsnwer;
		this.originalAsnwer = originalAsnwer;
		//calculateAllTerminology();
		
		accuracyTest();
		print();
	}
	
	private void accuracyTest() {
		double equalAnsCount = 0;
		for(int i=0;i<originalAsnwer.size();i++) 
			if(testAsnwer.get(i).equals(originalAsnwer.get(i)) )equalAnsCount++;
		

		accuracy =( equalAnsCount/ (double) originalAsnwer.size() ) *100 ;
	}
	
	private void print() {
		System.out.println("Accuracy  = "+accuracy);
	}
	
}	


/*
private void print() {
	System.out.println("accuracy   "+accuracy);
	System.out.println("true positive   "+truePositive);
	System.out.println("true negative    "+trueNegative);
	System.out.println("false positive    "+falsePositive);
	System.out.println("fsalse negative    "+falseNegative);
	System.out.println("precision    "+precision);
	System.out.println("recall     "+recall);
	System.out.println("f score   "+f1score);
}

private void calculateAllTerminology() {
	for(int i=0;i<originalAsnwer.size();i++) {
		if(originalAsnwer.get(i)==1) {
			totalPositive++;
			if(testAsnwer.get(i)==1) truePositive++;
			else if(testAsnwer.get(i)==0) falseNegative++;
		}
		else if(originalAsnwer.get(i)==0) {
			totalNegative++;
			if(testAsnwer.get(i)==0) trueNegative++;
			else if(testAsnwer.get(i)==1) falsePositive++;
		}
	}
	precision = truePositive / (truePositive + falsePositive);
	recall = truePositive / (truePositive + falseNegative);
	accuracy =100* (truePositive + trueNegative) / (truePositive + trueNegative + falsePositive +falseNegative);
	f1score = (2 * precision * recall) / (precision + recall);
}

*/
	

/*
 * 
	
	private void accuracyTest() {
		double equalAnsCount = 0;
		for(int i=0;i<originalAsnwer.size();i++)
			if(testAsnwer.get(i)==originalAsnwer.get(i)) equalAnsCount++;
		accuracy =( equalAnsCount/ (double) originalAsnwer.size() ) *100 ;
	}
	
	private void truePositiveTest() {
		double allPositiveCount = 0,positiveCount=0;
		for(int i=0;i<originalAsnwer.size();i++) {
			if(originalAsnwer.get(i)==1) {
				allPositiveCount++;
				if(testAsnwer.get(i)==originalAsnwer.get(i)) positiveCount++;
			}
		}
		truePositive = positiveCount;
		totalPositive = allPositiveCount;
	}
		
		
	private void trueNegativeTest() {
		double allNegativeCount = 0,NegativeCount=0;
		for(int i=0;i<originalAsnwer.size();i++) {
			if(originalAsnwer.get(i)==0) {
				allNegativeCount++;
				if(testAsnwer.get(i)==originalAsnwer.get(i)) NegativeCount++;
			}
		}
		trueNegative = NegativeCount;
		totalNegative = allNegativeCount;
	}

	private void falsePositive() {
		double count=0;
		for(int i=0;i<originalAsnwer.size();i++) {
			if(originalAsnwer.get(i)==0 && testAsnwer.get(i)==1) count++;
		}
		falsePositive = count;
	}
	
	private void falseNegative() {
		double count=0;
		for(int i=0;i<originalAsnwer.size();i++) {
			if(originalAsnwer.get(i)==1 && testAsnwer.get(i)==0) count++;
		}
		falseNegative = count;
	}
	*/