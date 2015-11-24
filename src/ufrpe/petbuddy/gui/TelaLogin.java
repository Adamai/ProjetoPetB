package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class TelaLogin extends JFrame {

	private JPanel painel;
	private JTextField campoLogin;
	private JPasswordField campoSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setTitle("PetBuddy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		setContentPane(painel);
		
		JLabel textoLogins = new JLabel("Usu\u00E1rio\r\n");
		textoLogins.setBounds(70, 174, 60, 26);
		painel.add(textoLogins);
		
		JLabel textoSenha = new JLabel("Senha");
		textoSenha.setBounds(70, 230, 46, 14);
		painel.add(textoSenha);
		
		campoLogin = new JTextField();
		campoLogin.setBounds(133, 177, 321, 20);
		painel.add(campoLogin);
		campoLogin.setColumns(10);
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(133, 227, 321, 20);
		painel.add(campoSenha);
		
		JButton botaoEfetuarLogin = new JButton("Entrar");
		botaoEfetuarLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botaoEfetuarLogin.setBounds(540, 341, 125, 46);
		painel.add(botaoEfetuarLogin);
		
		JLabel textoEntrar = new JLabel("Login");
		textoEntrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textoEntrar.setBounds(154, 43, 149, 38);
		painel.add(textoEntrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(70, 428, 89, 23);
		painel.add(btnVoltar);
		
		
	}
}
