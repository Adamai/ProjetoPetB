package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class TelaLogado extends JFrame {

	private JPanel painel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogado frame = new TelaLogado();
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
	public TelaLogado() {
		setTitle("PetBuddy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		setContentPane(painel);
		
		JLabel textoPergunta = new JLabel("O que deseja?");
		textoPergunta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textoPergunta.setBounds(328, 28, 127, 65);
		painel.add(textoPergunta);
		
		JButton botaoBusca = new JButton("Procurar animais");
		botaoBusca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoBusca.setBounds(304, 165, 179, 65);
		painel.add(botaoBusca);
		
		JButton botaoAdotar = new JButton("Adotar Animal");
		botaoAdotar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoAdotar.setBounds(306, 289, 179, 65);
		painel.add(botaoAdotar);
	}
}
