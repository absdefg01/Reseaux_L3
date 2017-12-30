//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * 
 * @author ZhaoMengzi WangLi
 * A - lancer le serveur_UDP
 * B - lancer le client UDP
 *
 */

public class client_UDP {
	public static void main(String args[]) throws Exception {
		
		/**
		 * création de client socket
		 */
		DatagramSocket socket = new DatagramSocket();
		InetAddress IPAddress = null;
		//obtenir l'adresse
		try {
		      IPAddress = InetAddress.getByName("localhost");
		} catch (UnknownHostException exception) {
		      System.err.println(exception);
		}
		
		
		
		
		
		/**
		 * packet data de "envoie" et "recoie"
		 */
		byte[] envoie = new byte[256];
		byte[] recoie = new byte[256];
		
		
		
		
		
		/**
		 * on a 10 paquets à envoyer
		 * 
		 * d'abord, on envoie 5 par une fois
		 * 
		 * on envoie les restes paquettes un par un 
		 * dès que le serveur envoie sa première réponse pour la 1ere paquette qu'on a envoyé
		 * 
		 */
		//compteur : compter le nombre de fois d'échec pour chaque paquet envoyé
		int compteur = 0;		
		//compteur2 : nb total de paquette à envoyer
		int compteur2 = 0;
		//compteur3 : nb de glissante 
		int compteur3 = 0;
		
		while(compteur < 10 && compteur2 < 10) {	
			// envoyer les paquettes au serveur		
			if(compteur3>=5 && compteur3<10){
				String messageEnvoie = "ping";
				System.out.println("Paquettes envoyées par le client:" + messageEnvoie);
				envoie = messageEnvoie.getBytes();			
				DatagramPacket packetEnvoie = new DatagramPacket(envoie, envoie.length, IPAddress, 4459);
			    socket.send(packetEnvoie);
			  //stop & wait 1000 millisecondes
				socket.setSoTimeout(1000);
			    compteur3++;	//pour limiter le nb de fois d'envoie
			}
			
			while(compteur3 < 5){
				String messageEnvoie = "ping";
				System.out.println("Paquettes envoyées par le client:" + messageEnvoie);
				envoie = messageEnvoie.getBytes();			
				DatagramPacket packetEnvoie = new DatagramPacket(envoie, envoie.length, IPAddress, 4459);
			    socket.send(packetEnvoie);
			  //stop & wait 1000 millisecondes
				socket.setSoTimeout(1000);
			    compteur3++;
			}

			//recevoir
		    DatagramPacket packetRecoie = new DatagramPacket(recoie, recoie.length);
		    try {
		        socket.receive(packetRecoie);
		        compteur = 0;
		        //envoieContinue = false; //un packet a été bien reçu : arrêter d'envoyer
		        compteur2++;
		        String messageRecu = new String(packetRecoie.getData());
			    System.out.println("Client recoit le message depuis le serveur:" + messageRecu);
			    //socket.setSoTimeout(100000);
		    }
		    catch (SocketTimeoutException e) {
		        // ne pas revevoir le message après une seconde, envoie continue
			    compteur++;
		    }    
		}
	    socket.close();
	}
}
