package server;
//package labserver;

import java.io.*;
import java.net.*;
public class Server implements Runnable
{
    ServerSocket serverSocket;
    PrintStream streamToClient;
    BufferedReader streamFromClient;
    Socket fromClient;
    static int count = 0;
    Thread thread;
    public Server()
    {
    	System.out.println("Welcome to Server");
        try{
            serverSocket = new ServerSocket(1068);
        }
        catch(Exception e)
        {
            System.out.println("Socket could not be created"+e);
        }
        thread = new Thread(this);
        thread.start();
    }
    public void run()
    {
        try{
            while(true)
            {
                fromClient = serverSocket.accept();
                count++;    
                System.out.println("Client connection number "+count);
                streamFromClient = new BufferedReader(new InputStreamReader((fromClient.getInputStream())));
                streamToClient = new PrintStream(fromClient.getOutputStream());
                //String str = streamFromClient.readLine();
               // System.out.println("Client name "+str);
                String str1 = streamFromClient.readLine();
                System.out.println(str1);
                
                String info[] = str1.split(",");
    		    Red rd = new Red();
    			String info1[][] = rd.read();
    			int personNum = rd.getperson();
    			for(int i=0;i<personNum;i++) {
    				System.out.println(info1[i][0]+info1[i][1]);
    			}
    			for(int i=0;i<personNum;i++) {
    				System.out.println(info1[i][0]+info1[i][1]);
	                if(info[0].equals(info1[i][0])&&info[1].equals(info1[i][1])) {
	                	streamToClient.println("Done");
	                	String str2 = streamFromClient.readLine();
	                	Double b =Double.parseDouble(str2);
	                	Double a = Double.parseDouble(info1[i][2]);
	                	String st;
	                	Double ans = a-b;
	                	if(ans<0) {
	                		System.out.println("Out OF Range");
	                	}
	                	else {
	                		st = Double.toString(ans);
	                		info1[i][2]= st;
	                	}
	                	System.out.println(str2);
	                	break;
	                }
	                
    			}
                
                WX wt = new WX();
                wt.write(info1);
               /* while(true) {
                String str1 = streamFromClient.readLine();
                System.out.println("Client says "+str1);
                String name; 
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                name = reader.readLine(); 
                streamToClient.println(name);
                }*/
            }
        }
        catch(Exception e){
            System.out.println("Exception "+e);         
        }
        finally{
            try{
                fromClient.close();
            }
            catch(Exception e)
            {
                System.out.println("could not close connection "+e);
            }
        }
         
    }
public static void main(String args[])  
{
    new Server();
}
}
