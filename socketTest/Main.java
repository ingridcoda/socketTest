package socketTest;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		Server server = Server.start(5500);
		ArrayList<Client> clients = new ArrayList<Client>();
		clients.add(Client.start("127.0.0.1", 5500));
	  /*clients.add(Client.start("127.0.0.1", 5501));
		clients.add(Client.start("127.0.0.1", 5502));
		clients.add(Client.start("127.0.0.1", 5503));
		clients.add(Client.start("127.0.0.1", 5504));
		clients.add(Client.start("127.0.0.1", 5505));
		clients.add(Client.start("127.0.0.1", 5506));
		clients.add(Client.start("127.0.0.1", 5507));
		clients.add(Client.start("127.0.0.1", 5508));
		clients.add(Client.start("127.0.0.1", 5509));*/
		server.connect(clients);
	}

}
