package client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.omg.CORBA.portable.InputStream;

public class Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String number,temp;
		Socket s = new Socket("10.100.103.255",6281);
		// sc = new DataInputStream(System.in);
		DataInputStream sc1 = new DataInputStream(s.getInputStream());
		DataOutputStream sc2 = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1="",str2="";
		//PrintStream p = new  PrintStream(s.getOutputStream());
		while(true) {
		
			/*System.out.println("enter any string ");
			number = sc.nextLine();
			p.println(number);
			temp = sc1.nextLine();
			System.out.println(temp);*/
			
			str1=br.readLine();
			sc2.writeUTF(str1);
			sc2.flush();
			str2=sc1.readUTF();
			System.out.println("Server says : "+str2);
			
			
		}
		
	}

}
