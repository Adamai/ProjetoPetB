package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCadastroVeterinario extends JFrame {

	private JPanel painel;
	private JTextField campoNome;
	private JTextField campoTelefone;
	private JTextField campoIdade;
	private JTextField campoCRMV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroVeterinario frame = new TelaCadastroVeterinario();
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
	public TelaCadastroVeterinario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		setContentPane(painel);
		
		JLabel textoCadastroVeterinario = new JLabel("Cadastro Veterin\u00E1rio");
		textoCadastroVeterinario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textoCadastroVeterinario.setBounds(292, 24, 200, 50);
		painel.add(textoCadastroVeterinario);
		
		JLabel textoNome = new JLabel("Nome");
		textoNome.setBounds(65, 92, 56, 50);
		painel.add(textoNome);
		
		JLabel textoTelefone = new JLabel("Telefone");
		textoTelefone.setBounds(65, 194, 94, 50);
		painel.add(textoTelefone);
		
		JLabel textoIdade = new JLabel("Idade");
		textoIdade.setBounds(65, 312, 94, 50);
		painel.add(textoIdade);
		
		JLabel textoCrmv = new JLabel("CRMV");
		textoCrmv.setBounds(65, 438, 43, 50);
		painel.add(textoCrmv);
		
		campoNome = new JTextField();
		campoNome.setBounds(98, 126, 228, 29);
		painel.add(campoNome);
		campoNome.setColumns(10);
		
		campoTelefone = new JTextField();
		campoTelefone.setBounds(100, 239, 226, 29);
		painel.add(campoTelefone);
		campoTelefone.setColumns(10);
		
		campoIdade = new JTextField();
		campoIdade.setColumns(10);
		campoIdade.setBounds(98, 354, 226, 29);
		painel.add(campoIdade);
		
		campoCRMV = new JTextField();
		campoCRMV.setColumns(10);
		campoCRMV.setBounds(98, 474, 226, 29);
		painel.add(campoCRMV);
		
		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botaoCadastrar.setBounds(512, 357, 173, 92);
		painel.add(botaoCadastrar);
	}

}
