import java.io.IOException;
import java.net.*;

public class client_bonus {

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
		//création de socket client
		Socket socket;
		try {
		socket = new Socket("localhost",2009);
		socket.close();
		} catch (IOException e) {		
			e.printStackTrace();
		}
	}
}
