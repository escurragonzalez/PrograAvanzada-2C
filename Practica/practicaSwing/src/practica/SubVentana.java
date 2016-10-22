package practica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SubVentana extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Evento e;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubVentana frame = new SubVentana(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param event
	 * @param label
	 */
	public SubVentana(Evento event) {
		e=event;
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(78, 76, 133, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTextLabel();
				cerrar();
			}
		});
		btnAceptar.setBounds(78, 131, 89, 23);
		contentPane.add(btnAceptar);
	}

	private void setTextLabel(){
		e.setLabel(textField.getText());
	}

	private void cerrar() {
		this.dispose();
	}
}
