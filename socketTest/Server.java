package socketTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server extends ServerSocket {

	private static Server instance;

	private Server(int port) throws IOException {
		super(port);
		System.out.println("Servidor informa: Execução inicializada, porta " + port + " aberta.");	
	}

	public static Server getInstance(int port) throws IOException {
		if(instance == null) {
			instance = new Server(port);
		}
		return instance;
	}

	public static Server start(int port) throws Exception  {		
		return Server.getInstance(port);			
	}

	public void connect(ArrayList<Client> clients) throws IOException {
		
		for(Client c : clients) {
			
			c.client = this.accept();
			System.out.println("Servidor informa: Conexão com o cliente " + c.client.getInetAddress().getHostAddress() + " estabelecida.");
			Scanner scan = new Scanner(c.client.getInputStream());
			
			while(scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
			
			scan.close();	
			c.client.close();
			System.out.println("Servidor informa: Conexão com o cliente " + c.client.getInetAddress().getHostAddress() + " encerrada.");
		}		
		
		disconnect();
	}

	public void disconnect() throws IOException {		
		this.close();
		System.out.println("Servidor informa: Execução finalizada.");
	}
}
