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

public class TelaAdm extends JFrame implements ActionListener{

	private JPanel painel;
	private JButton botaoCadastroAnimais,botaoCadastroVeterinario;
	 
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
		
		JButton botaoHistoricoAdocoes = new JButton("Hist\u00F3rico Ado\u00E7\u00F5es");
		botaoHistoricoAdocoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoHistoricoAdocoes.setBounds(257, 136, 210, 41);
		painel.add(botaoHistoricoAdocoes);
		
		this.botaoCadastroAnimais = new JButton("Cadastro Animais");
		this.botaoCadastroAnimais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.botaoCadastroAnimais.setBounds(257, 220, 210, 41);
		botaoCadastroAnimais.addActionListener(this);
		painel.add(botaoCadastroAnimais);
		
		JLabel textoAdministrador = new JLabel("Administrador");
		textoAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textoAdministrador.setBounds(316, 43, 138, 50);
		painel.add(textoAdministrador);
		
		this.botaoCadastroVeterinario = new JButton("Cadastro Veterin\u00E1rio");
		this.botaoCadastroVeterinario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.botaoCadastroVeterinario.setBounds(257, 388, 210, 41);
		botaoCadastroVeterinario.addActionListener(this);
		painel.add(botaoCadastroVeterinario);
		
		JButton botaoRemoverAnimais = new JButton("Remover Animais");
		botaoRemoverAnimais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoRemoverAnimais.setBounds(257, 304, 210, 41);
		painel.add(botaoRemoverAnimais);
		
		JButton botaoAtualizarDados = new JButton("Atualizar Dados");
		botaoAtualizarDados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoAtualizarDados.setBounds(257, 472, 210, 41);
		painel.add(botaoAtualizarDados);
	}
	public void actionPerformed (ActionEvent evento){
		if (evento.getSource().equals(this.botaoCadastroAnimais)){
			dispose();
			TelaCadastroAnimal cadastroAnimais = new TelaCadastroAnimal();
			cadastroAnimais.setVisible(true);
		} else if(evento.getSource().equals(this.botaoCadastroVeterinario)){
			dispose();
			TelaCadastroVeterinario cadastroVet = new TelaCadastroVeterinario();
			cadastroVet.setVisible(true);
					}
		}
}

