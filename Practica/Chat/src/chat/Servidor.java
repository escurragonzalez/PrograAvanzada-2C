package chat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

	private ServerSocket socket;
	private int puerto=1000;
	private ArrayList<Socket> usuarios;
	private int id=1;

	public Servidor() {
		usuarios = new ArrayList<Socket>();
		try {
			socket = new ServerSocket(puerto);
			while(true){
				Socket clientSocket = socket.accept();
				usuarios.add(clientSocket);
				HiloServidor hilo = new HiloServidor(clientSocket,usuarios,id);
				hilo.start();
				id++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Servidor();
	}

}

