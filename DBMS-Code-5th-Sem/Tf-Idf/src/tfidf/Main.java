package tfidf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		HashMap<String ,Integer>Doc1 = null;
		
		HashMap<String ,Integer>Doc2;
		
		String[] stopwords = new String[2000];
	    ArrayList<String> wordsList = new ArrayList<String>();
	    Set<String> stopWordsSet = new HashSet<String>();
	    Set<String> FinalWordsSet = new HashSet<String>();
	    
	    String sCurrentLine;
	    
	    ///stopsword List
	    int k=0;
        FileReader fr=new FileReader("StopWord.txt");
        BufferedReader br= new BufferedReader(fr);
        while ((sCurrentLine = br.readLine()) != null){
            stopwords[k]=sCurrentLine;
            stopWordsSet.add(sCurrentLine);
            k++;
        }
        
	    for(int i=0;i<k;i++) {
	    	System.out.println("stopwords  "+stopwords[i]);
	    }
		
	    ArrayList<ArrayList<String>>tfword = new ArrayList<ArrayList<String>>();
	    
	    String fileName = "Data.txt";
	    wordsList=CollectWords(stopWordsSet,fileName);
	    

	    for(int i=0;i<wordsList.size();i++) {
	    	System.out.println("wordsList  "+wordsList.get(i));
	    	FinalWordsSet.add(wordsList.get(i));
	    }
	    tfword.add(wordsList);
	    
	    wordsList.clear();
	    
	    fileName = "Data1.txt";
	    wordsList=CollectWords(stopWordsSet,fileName);
	    

	    for(int i=0;i<wordsList.size();i++) {
	    	System.out.println("wordsList  "+wordsList.get(i));
	    	FinalWordsSet.add(wordsList.get(i));
	    }
	    tfword.add(wordsList);
	    
	    System.out.println(tfword.size());
	    
	    
		
	}
	
	private static ArrayList<String> CollectWords( Set<String> stopWordsSet,String fileName ) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<String> wordsList = new ArrayList<String>();
		
		ReadFile readFile = new ReadFile();
		String line = readFile.readFile(fileName);
		System.out.println(line);
		
		line = transformText(line);

		// Get and read each token
		final String[] words = line.split(" ");
		
		for (final String word : words) {
			// Skip if word is empty
			if (word == null || word.length() < 1) {
				continue;
			}

			// Stem and lemmatize
			
			 String stem = Stemming.stem(word);
			 System.out.println("hello   " +word);
			 if(!stopWordsSet.contains(word))
				 wordsList.add(word);
			 
			 
		}
		
		return wordsList;
		
		
		
		
	}

	private static String transformText(String text) {
		// Replacing the SGML tags with space.
		text = text.replaceAll("\\<.*?>", " ");

		// Remove digits
		text = text.replaceAll("[\\d+]", "");

		// Remove the special characters
		text = text.replaceAll("[+^:,?;=%#&~`$!@*_)/(}{\\.]", "");

		// Remove possessives
		text = text.replaceAll("\\'s", "");

		// Replace "'" with a space
		text = text.replaceAll("\\'", " ");

		// Replace - with space to count two words
		text = text.replaceAll("-", " ");

		// Remove multiple white spaces
		text = text.replaceAll("\\s+", " ");

		// Trim and set text to lower case
		text = text.trim().toLowerCase();
		return text;
	}

}
