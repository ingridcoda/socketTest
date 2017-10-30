package socketTest;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
	
	Socket client;
	
	public Client(String ip, int port) throws IOException {
		client = new Socket(ip, port);
		System.out.println("Cliente informa: Execução inicializada no IP " + ip + " porta " + port + ".");	
		//this.communicate("Teste");
	}
	
	public static Client start(String ip, int port) throws Exception  {		
		return new Client(ip, port);		
	}
	
	public void communicate(String message) throws IOException {
		PrintStream out = new PrintStream(client.getOutputStream());
		while(message.compareToIgnoreCase(null) != 0){
			out.println(message);
		}
		out.close();
		client.close();
		System.out.println("Cliente informa: Execução finalizada.");
	}
	
	/*Socket cli = new Socket("127.0.0.1", 12345);
	System.out.println("O cliente se conectou ao servidor!");
	Scanner teclado = new Scanner(System.in);
	PrintStream saida = new PrintStream(cli.getOutputStream());
	String msg = teclado.nextLine();
	while (msg.compareTo("###")!=0) {
	saida.println(msg);
	msg = teclado.nextLine();
	}
	saida.close();
	teclado.close();
	cli.close();
	System.out.println("O cliente terminou de executar!");*/
}
