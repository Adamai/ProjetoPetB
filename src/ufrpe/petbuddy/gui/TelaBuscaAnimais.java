package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaBuscaAnimais extends JFrame {

	private JPanel painel;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBuscaAnimais frame = new TelaBuscaAnimais();
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
	public TelaBuscaAnimais() {
		setTitle("PetBuddy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		setContentPane(painel);
		
		JLabel lblInsiraOsDados = new JLabel("Insira os dados referentes ao tipo de animal que esta procurando");
		lblInsiraOsDados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInsiraOsDados.setBounds(59, 62, 452, 46);
		painel.add(lblInsiraOsDados);
		
		JLabel lblNewLabel = new JLabel("Ra\u00E7a");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(42, 233, 43, 30);
		painel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(95, 234, 352, 30);
		painel.add(textField);
		textField.setColumns(10);
		
		JRadioButton radioButtonCachorro = new JRadioButton("Cachorro");
		radioButtonCachorro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioButtonCachorro.setBounds(39, 156, 109, 23);
		painel.add(radioButtonCachorro);
		
		JRadioButton radioButtonGato = new JRadioButton("Gato");
		radioButtonGato.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioButtonGato.setBounds(187, 156, 109, 23);
		painel.add(radioButtonGato);
		
		JRadioButton radioButtonReptil = new JRadioButton("Reptil");
		radioButtonReptil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioButtonReptil.setBounds(483, 156, 109, 23);
		painel.add(radioButtonReptil);
		
		JRadioButton radioButtonRoedor = new JRadioButton("Roedor");
		radioButtonRoedor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioButtonRoedor.setBounds(631, 156, 109, 23);
		painel.add(radioButtonRoedor);
		
		JRadioButton radioButtonAve = new JRadioButton("Ave");
		radioButtonAve.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioButtonAve.setBounds(335, 156, 109, 23);
		painel.add(radioButtonAve);
		
		JButton botaoBuscar = new JButton("Buscar");
		botaoBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botaoBuscar.setBounds(425, 309, 116, 30);
		painel.add(botaoBuscar);
	}
}
