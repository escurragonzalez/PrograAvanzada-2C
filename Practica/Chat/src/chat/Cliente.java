package chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente extends Thread {
	private Socket cliente;
	private DataInputStream in;
	private static DataOutputStream out;
	private int puerto = 1000;

	public Cliente() {
		try {

			Socket cliente = new Socket("localhost", puerto);
			in = new DataInputStream(cliente.getInputStream());
			out = new DataOutputStream(cliente.getOutputStream());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void enviarMensaje(String msj) {
		try {
			out.writeUTF(msj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void leerRespuesta() {
		try {
			System.out.println(in.readUTF());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void cerrarSesion() {
		try {

			if (cliente != null) {
				enviarMensaje("cerrar_socket_cliente");
				in.close();
				out.close();
				cliente.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Cliente c = new Cliente();
		boolean conect = true;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			while (conect) {
				String input = br.readLine();

				if ("cerrarSesion".equals(input)) {
					c.cerrarSesion();
				}else{
					enviarMensaje(input);
				}
			}
		}catch (Exception e) {
		}
	}
}
