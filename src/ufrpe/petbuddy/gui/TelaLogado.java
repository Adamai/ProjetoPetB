package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import ufrpe.petbuddy.facade.*;
import ufrpe.petbuddy.negocio.beans.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogado extends JFrame implements ActionListener{

	private JPanel painel;
	private JButton botaoBusca, botaoAdotar;
	private IFachada fachada;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				TelaLogado frame = new TelaLogado();
	//				frame.setVisible(true);
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//	});
	//}

	/**
	 * Create the frame.
	 */
	public TelaLogado(IFachada fachada) {
		this.fachada = fachada;
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
		
		this.botaoBusca = new JButton("Procurar animais");
		botaoBusca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoBusca.setBounds(304, 165, 179, 65);
		botaoBusca.addActionListener(this);
		painel.add(botaoBusca);
		
		this.botaoAdotar = new JButton("Adotar Animal");
		botaoAdotar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoAdotar.setBounds(306, 289, 179, 65);
		botaoAdotar.addActionListener(this);
		painel.add(botaoAdotar);
	}
	
	public void actionPerformed(ActionEvent evento){
		if(evento.getSource().equals(botaoBusca)){
			dispose();
			//TelaBuscaAnimais tela = new TelaBuscaAnimais(this.fachada);
			//tela.setVisible(true);
		}
	}
}
