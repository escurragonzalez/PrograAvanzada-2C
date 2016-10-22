package practica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class Evento extends JFrame {

	private JPanel contentPane;
	private int contador=0;
	private JLabel label;
	private JButton btnAbrir;
	private JPanel panel;
	private JPanel panel_1;
	private Evento event;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Evento frame = new Evento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Evento() {
		setEvento(this);
		setTitle("Ventena con Evento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(null);

				label = new JLabel("###");
				label.setBounds(133, 48, 141, 14);
				panel_1.add(label);

		panel = new JPanel();
		contentPane.add(panel);
						panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

						JButton btnContarClick = new JButton("Contar Click");
						panel.add(btnContarClick);
						btnContarClick.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								sumar();
								label.setText(String.valueOf(contador));
							}
						});

				btnAbrir = new JButton("Abrir");
				panel.add(btnAbrir);
				btnAbrir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						new SubVentana(event);
					}
				});
	}

	public void sumar(){
		this.contador++;
	}

	public void setEvento(Evento e){
		this.event=e;
	}

	public void setLabel(String str){
		this.label.setText(str);
	}
}
