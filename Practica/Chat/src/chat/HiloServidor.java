package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class HiloServidor extends Thread {

	private DataInputStream in;
	private DataOutputStream out;
	private ArrayList<Socket> users;
	private SendThread sender;
	private ReceiveThread receiver;
	private Socket sk;
	private int id;
	private LinkedBlockingQueue<String> outgoingMessages;

	public HiloServidor(Socket cliente, ArrayList<Socket> usuarios, int id) {
		setUser(usuarios);
		this.sk = cliente;
		this.id = id;
		try {
			in = new DataInputStream(sk.getInputStream());
			out = new DataOutputStream(sk.getOutputStream());
			outgoingMessages = new LinkedBlockingQueue<String>();
			sender = new SendThread();
			receiver = new ReceiveThread();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setUser(ArrayList<Socket> usuarios) {
		this.users = usuarios;
	}

	public void run() {
		sender.start();
		receiver.start();
	}

	synchronized public String leerRespuesta() {
		try {
			String resp = in.readUTF();
			return resp;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public class ReceiveThread extends Thread {

		private String msj;

		public void run() {
			try {
				while (true) {
					this.msj = leerRespuesta();
					if (msj.equals("cerrar_socket_cliente")) {
						cerrar();
					}
					outgoingMessages.add(msj);
				}
			} catch (Exception e) {
				System.err.println("Error recibiendo el mensaje: \n");
				e.printStackTrace();
			}
		}

		private void cerrar() throws IOException {
			out.close();
			in.close();
			sk.close();
			for (int i = 0; i < users.size(); i++) {
				if (sk == users.get(i)) {
					users.remove(sk);
				}
			}
		}

	}

	public class SendThread extends Thread {

		public void run() {
			try {
				while (true) {
					for (int i = 0; i < users.size(); i++) {
						out = new DataOutputStream(users.get(i).getOutputStream());
						out.writeUTF(id+": "+outgoingMessages.take());
						out.flush();
					}
				}
			} catch (Exception e) {
				for (int i = 0; i < users.size(); i++) {
					if (sk == users.get(i)) {
						users.remove(sk);
					}
				}
				System.err.println("Error recibiendo el mensaje: \n");
				e.printStackTrace();
			}
		}
	}
}