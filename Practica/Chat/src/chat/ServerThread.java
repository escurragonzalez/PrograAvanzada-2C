package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class ServerThread extends Thread {

	private DataInputStream in;
	private Socket cliente;
	private DataOutputStream out;
	private ArrayList<Socket> users;
	private LinkedBlockingQueue<String> outgoingMessages;

	public ServerThread(Socket cliente, ArrayList<Socket> usuarios) {
		setUser(usuarios);
		this.cliente = cliente;
		try {
			in = new DataInputStream(cliente.getInputStream());
			out = new DataOutputStream(cliente.getOutputStream());
			outgoingMessages = new LinkedBlockingQueue<String>();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setUser(ArrayList<Socket> usuarios) {
		this.users = usuarios;
	}

	public void run() {
		try {
			while (true) {
				String recibido = in.readUTF();
				System.out.println(recibido);
				for (int i = 0; i < users.size(); i++) {
					out = new DataOutputStream(users.get(i).getOutputStream());
					out.writeUTF(recibido);
				}
			}
		} catch (Exception e) {
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i) == cliente) {
					users.remove(i);
					break;
				}
			}
			e.printStackTrace();
		} finally {
			try {
				cliente.close();
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

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
		}

	}

	public class SendThread extends Thread {

		public void run() {

			try {
				while (true) {
					out.writeUTF(outgoingMessages.take());
					out.flush();
				}
			} catch (Exception e) {
				System.err.println("Error recibiendo el mensaje: \n");
				e.printStackTrace();
			}
		}
	}
}
