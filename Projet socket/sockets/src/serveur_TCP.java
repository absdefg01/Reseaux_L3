
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 
 * @author ZhaoMengzi WangLi
 * A - lancer le serveur TCP
 * B - lancer le client TCP
 *
 */

public class serveur_TCP{
	public static void main(String[] zero) {
		ServerSocket serverSocket;
		Socket clientSocket;
		PrintWriter out;
		BufferedReader in;

		/*
		 * 1erement le serveur doit construire la socket 
		 * sur laquelle il va attendre les connexions
		 * */
		/*
		 * si la création se passe bien (si le numéro de port est libre)
		 * le serveur se met en attente d'un client 
		 * à l'aide de la méthode bloquante accept
		 * */
		
		try{
			//création de socket de serveur
			 serverSocket = new ServerSocket(4444);
			 System.out.println("Le serveur est à l'écoute du port "+serverSocket.getLocalPort());
			 //attendre la connexion de client
			 clientSocket = serverSocket.accept();
			 System.out.println("successful connection !");
			 
		     in = new BufferedReader (new InputStreamReader (clientSocket.getInputStream()));
		     String message_distant = in.readLine();
		     System.out.println(message_distant);
		     
		     out = new PrintWriter(clientSocket.getOutputStream());
		     out.println("pong");
		     out.flush();
		     
			 serverSocket.close();
		     clientSocket.close();
		}catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("accept fail");
		}		
	
		
	}
	
}
