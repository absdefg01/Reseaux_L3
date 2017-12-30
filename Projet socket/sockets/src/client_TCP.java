import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * @author ZhaoMengzi WangLi
 * A - lancer le serveur TCP
 * B - lancer le client TCP
 *
 */

public class client_TCP {
	public static void main(String[] zero) throws IOException {
		Socket echotSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		String userInput;
	
		/*
		 * le client TCP va effectuer sa demande de connexion 
		 * lors de la création de la socket
		 * */		
		
		try{
			echotSocket = new Socket(InetAddress.getLocalHost(),4444);
	        System.out.println("Demande de connexion");
			out = new PrintWriter(echotSocket.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader(echotSocket.getInputStream()));	
		}catch(UnknownHostException e){
			System.err.println("Don't know about host");
			System.exit(-1);
		}catch(IOException e){
			System.err.println("Couldn't I/O for" + "the connection to : machine.");
			System.exit(-1);
		}	

		/*
		 * flux entrant/sortant pour communiquer avec le serveur
		 * */
		
	     out = new PrintWriter(echotSocket.getOutputStream());
	     //message envoyé
	     out.println("ping");
	     out.flush();
	     
	     
	     in = new BufferedReader (new InputStreamReader (echotSocket.getInputStream()));
	     String messageEnvoie = in.readLine();
	     System.out.println("message depuis le serveur:" + messageEnvoie);
	
	     out.close();
	     in.close();
	     echotSocket.close();
		
	}
	
}
