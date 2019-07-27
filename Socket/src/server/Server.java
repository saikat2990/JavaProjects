package server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String number,temp;
		
		ServerSocket si = new ServerSocket(1042);
		Socket ss = si.accept();
		//while(true) {
		Scanner sc = new Scanner(ss.getInputStream());
		PrintStream p = new PrintStream(ss.getOutputStream());
		//while(true) {
		number = sc.nextLine();
		
		temp = number+" i am server";
		
		
		p.print(temp);
		//}
		
	}

}
