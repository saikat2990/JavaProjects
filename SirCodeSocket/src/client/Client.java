package client;

import java.io.*;
import java.net.*;
public class Client
{
    PrintStream streamToServer;
    BufferedReader streamFromServer;
    Socket toServer;
    public Client()
    {
    	System.out.println("Welcome to Client");
        connectToServer();
    }
    private void connectToServer()
    {
        try{
            String name;
            toServer = new Socket("127.0.0.1",1211);
            streamFromServer = new BufferedReader(new InputStreamReader((toServer.getInputStream())));
            streamToServer = new PrintStream(toServer.getOutputStream());
            System.out.println("Enter Connection Name");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            name = reader.readLine();   
            streamToServer.println(name);
            String str = streamFromServer.readLine();
            System.out.println("The Server Says "+str);         
        }
        catch(Exception e)
        {
                System.out.println("Exception "+e);
        }       
    }
    public static void main(String args[])
    {
        new Client();
    }
}