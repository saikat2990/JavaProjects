package decision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class SeparateTraningAndTestData {
	
	private String line;
	private String [][] totalData;
	private String [][] testData;
	private String [][] traningData;
	private int i,totalFileSize,testSize,traningSize,number,totalYes=0,totalNo=0;
	

	ArrayList<String> totalDataString = new ArrayList<String>(); 
	HashMap<Integer, Boolean> testDataPositonMap = new HashMap<Integer,Boolean>();
	HashMap<Integer, Boolean> alltestDataPositonMap = new HashMap<Integer,Boolean>();
	
	public SeparateTraningAndTestData(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));
		while(sc.hasNextLine()){
			line = sc.next();
			//System.out.println(line);
			totalDataString.add(line);
			i++;
		}
		totalFileSize = i;
		testSize = (int) (totalFileSize * 0.1);
		///////////////
		//testSize = 0;
		traningSize = totalFileSize - testSize;
		storeInArray();
		System.out.println(totalFileSize+"    "+traningSize+"      "+testSize);
		sc.close();
	}
	
	private void storeInArray() {
		totalData = new String[totalFileSize+1][];
		for(int i=0;i<totalDataString.size();i++)
			totalData[i+1] = splitRowData( totalDataString.get(i));
	}
	
	private String []splitRowData(String line) {
		String [] row = line.split(",");
		String [] rowData = new String[row.length+1];
		for(int i=0;i<row.length;i++) {
			rowData[i+1] = row[i];
		}
		return rowData;
	}
	
	
	public void selectTestDataRandomly(int low,int high) {
		Random rand = new Random();
		i=1;
		testData = new String [testSize+1][];
		testDataPositonMap.clear();
		while(i<=testSize) {
			number = rand.nextInt(high-low)+low+1;
			if(!alltestDataPositonMap.containsKey(number)) {
				testData[i++] = totalData[number];
				testDataPositonMap.put(number, true);
				alltestDataPositonMap.put(number, true);
			}
		}
		
	}
	
	public String[][] getTestData() {
		selectTestDataRandomly(0,totalFileSize);
		return testData;
	}
	
	public String[][] getTraningData() {
		i=1;
		traningData = new String [traningSize+1][];
		for(int j=1;j<totalData.length;j++) {
			if(testDataPositonMap.containsKey(j)) {}
			else {
				traningData[i++] = totalData[j];
				if(totalData[j][totalData[j].length-1].equals("yes")) totalYes++;
				else totalNo++;
			}
		}			
		return traningData;
	}

	public double getSpamProbability() {
		return (double) totalYes/ (double) traningSize;
	}

	public double getNonSpamPobablility() {
		return (double)totalNo/ (double)traningSize;
	}
	public int gettotalYes() {
		return (int)totalYes;
	}

	public int gettotalNo() {
		return (int) totalNo;
	}
	
}
