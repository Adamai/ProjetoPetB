package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class TelaPrincipal extends JFrame {

	private JPanel painel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		setContentPane(painel);
		
		JLabel textoBemVindo = new JLabel("Bem vindo ao PetBuddy");
		textoBemVindo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textoBemVindo.setBounds(280, 11, 224, 78);
		painel.add(textoBemVindo);
		
		JButton botaoCadastro = new JButton("Cadastre-se");
		botaoCadastro.setBounds(322, 308, 164, 58);
		painel.add(botaoCadastro);
		
		JButton botaoLogin = new JButton("Login");
		botaoLogin.setBounds(322, 233, 164, 58);
		painel.add(botaoLogin);
		
		JButton botaoBusca = new JButton("Procurar Animais");
		botaoBusca.setBounds(322, 383, 164, 58);
		painel.add(botaoBusca);
	}

}
