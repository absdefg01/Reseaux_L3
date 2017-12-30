import java.io.IOException;
import java.net.*;

public class serveur_bonus {

	/**
	 * 
	 * @author ZhaoMengzi WangLi
	 * A - lancer le serveur_bonus
	 * B - lancer le client_bonus pour ajouter le premier client
	 * C - lancer encore le client_bonus pour ajouter le 2ième client
	 * D - ......
	 *
	 */
	public static void main(String[] zero){
		
		ServerSocket socket;
		try {
		socket = new ServerSocket(2009);
		/**
		 * dès qu'un client souhaite se connecter avec le serveur
		 * un Thread s'occupe de la connexion
		 * il ne sera plus la peine de faire appel au serveur lorsqu'un client souhaite se connecter
		 * tout le boulot sera confié à un Thread
		 */
		Thread t = new Thread(new Accepter_clients(socket));
		t.start();
		System.out.println("Prêts !");
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}

class Accepter_clients implements Runnable {

	   private ServerSocket socketserver;
	   private Socket socket;
	   private int nbrclient = 1;
		public Accepter_clients(ServerSocket s){
			socketserver = s;
		}
		
		public void run() {

	        try {
	        	while(true){
			  socket = socketserver.accept(); // Un client se connecte on l'accepte
	                  System.out.println("Le client numéro "+nbrclient+ " est connecté !");
	                  nbrclient++;
	                  socket.close();
	        	}
	        
	        } catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
