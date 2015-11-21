package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class TelaAdm extends JFrame {

	private JPanel painel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdm frame = new TelaAdm();
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
	public TelaAdm() {
		setTitle("PetBuddy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		setContentPane(painel);
		
		JButton botaoHistricoAdoces = new JButton("Hist\u00F3rico Ado\u00E7\u00F5es");
		botaoHistricoAdoces.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoHistricoAdoces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botaoHistricoAdoces.setBounds(257, 136, 210, 41);
		painel.add(botaoHistricoAdoces);
		
		JButton botaoCadastroAnimais = new JButton("Cadastro Animais");
		botaoCadastroAnimais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoCadastroAnimais.setBounds(257, 220, 210, 41);
		painel.add(botaoCadastroAnimais);
		
		JLabel textoAdministrador = new JLabel("Administrador");
		textoAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textoAdministrador.setBounds(316, 43, 138, 50);
		painel.add(textoAdministrador);
		
		JButton botaoCadastroVeterinario = new JButton("Cadastro Veterin\u00E1rio");
		botaoCadastroVeterinario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoCadastroVeterinario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoCadastroVeterinario.setBounds(257, 388, 210, 41);
		painel.add(botaoCadastroVeterinario);
		
		JButton botaoRemoverAnimais = new JButton("Remover Animais");
		botaoRemoverAnimais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoRemoverAnimais.setBounds(257, 304, 210, 41);
		painel.add(botaoRemoverAnimais);
		
		JButton botaoAtualizarDados = new JButton("Atualizar Dados");
		botaoAtualizarDados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoAtualizarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoAtualizarDados.setBounds(257, 472, 210, 41);
		painel.add(botaoAtualizarDados);
	}
}
