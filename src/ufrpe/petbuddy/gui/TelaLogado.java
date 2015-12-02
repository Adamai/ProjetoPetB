package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

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
	private JButton botaoBusca,botaoSair;
	private IFachada fachada;
	private Usuario usuario;


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
	public TelaLogado(IFachada fachada, Usuario u) {
		this.fachada = fachada;
		this.usuario = u;
		
		setTitle("PetBuddy");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Sprites\\sai.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		painel.setBackground(new Color(255, 228, 181) );
		setContentPane(painel);
		
		JLabel textoPergunta = new JLabel("Que tal ");
		textoPergunta.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textoPergunta.setBounds(342, 89, 127, 65);
		painel.add(textoPergunta);
		
		this.botaoBusca = new JButton("Procurar animais?");
		botaoBusca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botaoBusca.setBounds(304, 215, 191, 65);
		botaoBusca.addActionListener(this);
		painel.add(botaoBusca);
		
		this.botaoSair = new JButton("Sair");
		botaoSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoSair.setBounds(304, 404, 179, 65);
		botaoSair.addActionListener(this);
		painel.add(botaoSair);
		
		if(usuario != null){
		JLabel label = new JLabel("Bem vindo " + usuario.getNome());
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(104, 11, 592, 65);
		painel.add(label);
	
	}}
	
	public void actionPerformed(ActionEvent evento){
		if(evento.getSource().equals(botaoBusca)){
			dispose();
			TelaBuscaAnimais tela = new TelaBuscaAnimais(usuario);
			tela.setVisible(true);
		}
		if(evento.getSource().equals(botaoSair)){
			dispose();
			TelaPrincipal tela = new TelaPrincipal(fachada);
			tela.setVisible(true);
		}
	}
}
