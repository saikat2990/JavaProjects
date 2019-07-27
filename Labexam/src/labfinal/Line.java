package labfinal;

public final class Line {
	
	private char [] charByte;
	
	public Line(String chars) { 
		charByte = chars.toCharArray(); 
		}
	
	
	public int length(String str) {
		int i=0;
		
		 //char [] compare ;
		
		//compare = str.toCharArray();
		for(char ch : charByte) {
			i++;
		}
		return i+1;
	}

	
	public char charAt(int num) {
		
		return charByte[num-1];
		
	}
	
	public int compareToString(String str) {
		
		 char [] compare ;
		 int value = -1;
		compare = str.toCharArray();
		
		String str1 = charByte.toString();
		if(str1.equals(str))return 0;
		
		
		for(int i=0;i<length(str);i++) {
			
			if(compare[i]!=charByte[i]) {
				value = compare[i]-charByte[i];
				break;
			}
		
		}
		return value;
		
	}

	
	
	public boolean startsWith(String str) {
		
		 char [] prefix;
		 prefix = str.toCharArray();
		 
		 int ta = 0;
		 
		 for(int i=0;i<length(str);i++) {System.out.println(prefix[i]);}
		 
		 for(int i=0;i<length(str);i++) {
			
			 if( prefix[i] == charByte[i] ) {
				 
				 ta=1;
			 }
			 
			 else {
				 ta=0;
				 break;
			 }
		 }
		 
		if(ta==1) return true;
		else return false;
		
	}  
	
	public boolean endsWith( String str) {
		
		 char [] suffix;
		 suffix = str.toCharArray();
		 
		 String str2 = charByte.toString(); 
		 int tag = 0;
		 
		 for(int i=length(str)-1;i>=0;i--) {
			 
			 if(suffix[i]==charByte[length(str2)-i-1]) {
				 tag=1;
			 }
			 else {
				 tag=0;
				 break;
			 }
		 }
		 
		if(tag==1) return true;
		else return false ;
		
	} 
	
	public int indexOf( char ch ){
		
		int index=-1;
		
		String forlen = charByte.toString();
		
		for(int i=0;i<length(forlen);i++) {
			if(charByte[i]==ch) {
				index=i+1;
				break;
			}
		}
		
		return index;
	}
	
	public void replace(String str1,String str2) {
		
		char [] arr2 = str2.toCharArray();
		
		if(length(str1)>length(str2)) {
			
			char [] arr1 = str1.toCharArray();
			int i=0;
			for(;i< length(str2) ;i++ ) {
				
				arr1[i] = arr2[i];
			}
			
			arr1[i+1] = '\n';
			
			
		}
		
		else {
			
			char [] arr1 = new char [length(str2)];
			
			int i=0;
			for(;i< length(str2) ;i++ ) {
				
				arr1[i] = arr2[i];
			}
			
			arr1[i+1] = '\n';
			
			for(char ch : arr1) {
				System.out.println(ch);
			}
		}
		

	}
	
	public void toLowerCase() {
		
		String str = charByte.toString();
		char [] arr = new char [length(str)] ;
		int j=0;
		
		for(char ch : charByte) {
			arr[j] = ch;
			j++;
		}
		
		
		
		
		System.out.println(length(str));
		
		for(int i=0;i<length(str);i++)
			System.out.println(arr[i]);
		
		
		for(int i=0;i<length(str);i++)
			System.out.println((int)charByte[i]);
		
		
		for(int i=0;i<length(str);i++) {
			
			if(91>((int)charByte[i])) {
				
				char ch = (char)((int)arr[i]+32);
				System.out.println(ch);
				arr[i] = ch;
				System.out.println(ch);
			}
		}
		
		for(int i=0;i<length(str);i++) {
			System.out.print(arr[i]);
		}
	}
		
	public void toUpperCase() {
		
		String str = charByte.toString();
		
		char [] arr = str.toCharArray();
		
		for(int i=0;i<length(str);i++) {
			
			System.out.println((int)charByte[i]);
			
			if(91>((int)charByte[i])) {
				
				char ch = (char)((int)arr[i]+32);
				System.out.println(ch);
				arr[i] = ch;
			}
		}
		
		for(int i=0;i<length(str);i++) {
			System.out.print(arr[i]);
		}
		
		
	}
	public int tag1=0;
	
	public int findArr(String str,int index) {
		
		
		int size = length(str);
		int n=index;
		char [] arr = str.toCharArray();
		
		for(int i=0;i<size;i++) {
			
			if(charByte[n] == arr[i]) {
				
				n++;
				tag1 =1 ;
			}
			else {
				
				tag1=0;
				break;
			}
		}
		
		if(tag1==0)return index+1;
		else return index;
		
		
	}
	
	public int findPosition(String str) {
		
		String arr = charByte.toString();
		int arrsize = length(arr);
		int i=0;
		for(;i<arrsize;i++) {
			int j=0;
			
			j=findArr(str,j);
			if(tag1==1)break;
		}
		
		return i;
	}
	
	
	
}

