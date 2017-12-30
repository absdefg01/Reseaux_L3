import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

/**
 * 
 * @author ZhaoMengzi WangLi
 * A - lancer le serveur_UDP
 * B - lancer le client UDP
 *
 */

public class serveur_UDP {
	public static void main(String args[]) throws Exception{
		/**
		 * création d'une datagram socket
		 * */
		DatagramSocket socket = new DatagramSocket(4459);
		System.out.println("Le serveur est à l'écoute du port "+socket.getLocalPort());

		
		
		
		
		/**
		 * packet data de "envoie" et "recoie"
		 */
		byte[] envoie = new byte[256];
		byte[] recoie = new byte[256];
		
		
		
		
		
		
		/**
		 * partie "recevoir"
		 * nb de recoie de paquettes = 10
		 */
		DatagramPacket packetRecoie = new DatagramPacket(recoie,recoie.length);
		//si bien recevoir le message
		boolean envoieContinue = true;
		int compteur = 0;
		//on recoit les paquettes jusqu'on recoit 10 paquettes
		while(envoieContinue && compteur < 10){
			try {
		        socket.receive(packetRecoie);
		        //envoieContinue = false; //un packet a été bien reçu : arrêter d'envoyer
		        compteur++;
		        String messageRecu = new String(packetRecoie.getData());
			    System.out.println("Serveur recoit le message depuis le client:" + messageRecu);
			    //socket.setSoTimeout(100000);
		    }
		    catch (SocketTimeoutException e) {
		        // ne pas revevoir le message après une seconde, envoie continue
		    }   

			
		    
			
			
	        /**
			 * Création d'un datagramme pour émmetre de l'information l'envoi 
			 * s'effectue avec la méthode send()
			 * */
	        InetAddress IPAddress = packetRecoie.getAddress();
	        int port = packetRecoie.getPort();
	        
	        String messageEnvoie = "pong";
	        envoie = messageEnvoie.getBytes();
	        DatagramPacket packetEnvoie = new DatagramPacket(envoie,envoie.length,IPAddress, port);
	        socket.send(packetEnvoie);
		}
        socket.close();

	}
}
