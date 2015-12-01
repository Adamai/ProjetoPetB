package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;

import ufrpe.petbuddy.exceptions.HistException;
import ufrpe.petbuddy.facade.*;
import ufrpe.petbuddy.negocio.beans.*;
import ufrpe.petbuddy.gui.*;

public class TelaAdm extends JFrame implements ActionListener{

	private JPanel painel;
	private JButton botaoCadastroAnimais; 
	private JButton botaoCadastroVeterinario;
	private JButton botaoHistoricoAdocoes;
	private JButton botaoAtualizarAnimais;
	private JButton botaoControleVeterinarios;
	private JButton botaoSair;
	private JButton botaoHistoricoCadastro;
	private JButton botaoAtualizarVeterinarios;
	private IFachada fachada;
	private Usuario usuario;
	 
	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				TelaAdm frame = new TelaAdm();
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
	public TelaAdm(IFachada fachada, Usuario u) {
		
		this.usuario = u;
		this.fachada = fachada;
		setTitle("PetBuddy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		painel.setBackground(new Color(255, 228, 181) );
		setContentPane(painel);
		
		this.botaoHistoricoAdocoes = new JButton("Hist\u00F3rico Ado\u00E7\u00F5es");
		botaoHistoricoAdocoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoHistoricoAdocoes.setBounds(257, 136, 210, 41);
		botaoHistoricoAdocoes.addActionListener(this);
		painel.add(botaoHistoricoAdocoes);
		
		this.botaoCadastroAnimais = new JButton("Cadastro Animais");
		this.botaoCadastroAnimais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.botaoCadastroAnimais.setBounds(257, 186, 210, 41);
		botaoCadastroAnimais.addActionListener(this);
		painel.add(botaoCadastroAnimais);
		
		JLabel textoAdministrador = new JLabel("Administrador");
		textoAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textoAdministrador.setBounds(282, 43, 160, 50);
		painel.add(textoAdministrador);
		
		this.botaoCadastroVeterinario = new JButton("Cadastro Veterin\u00E1rio");
		this.botaoCadastroVeterinario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.botaoCadastroVeterinario.setBounds(257, 238, 210, 41);
		botaoCadastroVeterinario.addActionListener(this);
		painel.add(botaoCadastroVeterinario);
		
		this.botaoSair = new JButton("Sair");
		this.botaoSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.botaoSair.setBounds(257, 509, 210, 41);
		botaoSair.addActionListener(this);
		painel.add(botaoSair);
		
		this.botaoAtualizarAnimais = new JButton("Atualizar Animais");
		botaoAtualizarAnimais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoAtualizarAnimais.setBounds(257, 290, 210, 41);
		botaoAtualizarAnimais.addActionListener(this);
		painel.add(botaoAtualizarAnimais);
		
		this.botaoControleVeterinarios = new JButton("Controle Veterin\u00E1rios");
		botaoControleVeterinarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoControleVeterinarios.setBounds(257, 342, 210, 41);
		botaoControleVeterinarios.addActionListener(this);
		painel.add(botaoControleVeterinarios);
		
		this.botaoHistoricoCadastro = new JButton("Hist\u00F3rico Animais");
		botaoHistoricoCadastro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoHistoricoCadastro.setBounds(257, 394, 210, 41);
		botaoHistoricoCadastro.addActionListener(this);
		painel.add(botaoHistoricoCadastro);
		
		this.botaoAtualizarVeterinarios = new JButton("Atualizar Veterin\u00E1rios");
		botaoAtualizarVeterinarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoAtualizarVeterinarios.setBounds(257, 446, 210, 41);
		botaoAtualizarVeterinarios.addActionListener(this);
		painel.add(botaoAtualizarVeterinarios);
		
	}
	public void actionPerformed (ActionEvent evento){
		if (evento.getSource().equals(this.botaoCadastroAnimais)){
			dispose();
			TelaCadastroAnimal cadastroAnimais = new TelaCadastroAnimal(fachada,usuario);
			cadastroAnimais.setVisible(true);
		} else if(evento.getSource().equals(this.botaoCadastroVeterinario)){
			dispose();
			TelaCadastroVeterinario cadastroVet = new TelaCadastroVeterinario(fachada,usuario);
			cadastroVet.setVisible(true);
		}else if(evento.getSource().equals(this.botaoSair)){
			dispose();
			TelaPrincipal tela = new TelaPrincipal(fachada);
			tela.setVisible(true);
		}
		else if(evento.getSource().equals(botaoHistoricoAdocoes)){
			
			try{
				ArrayList<Adocao>adocoes = fachada.buscaHistoricoAdocoes();
				if(adocoes.size()>0){
					TelaHistoricoAdocoes tela = new TelaHistoricoAdocoes(usuario,adocoes);
					dispose();
					tela.setVisible(true);
				}
				}
			catch(HistException h){
				JOptionPane.showMessageDialog(null, h.getMessage());
			}
				
		}
		else if(evento.getSource().equals(botaoAtualizarAnimais)){
			dispose();
			TelaBuscaAnimais tela = new TelaBuscaAnimais(usuario);
			tela.setVisible(true);
		} else if(evento.getSource().equals(botaoControleVeterinarios)){
			dispose();
			TelaListaVeterinarios tela = new TelaListaVeterinarios(usuario);
			tela.setVisible(true);
		}else if(evento.getSource().equals(botaoHistoricoCadastro)){
			try{
				ArrayList<Animal>animais = fachada.listarAnimais();
				dispose();
				TelaHistoricoCadastro tela = new TelaHistoricoCadastro(usuario,animais);
				tela.setVisible(true);
			}
			catch(HistException h){
				JOptionPane.showMessageDialog(null, h.getMessage());
			}
		}else if(evento.getSource().equals(botaoAtualizarVeterinarios)){
				try{
				ArrayList<Veterinario> vet = fachada.ListarVet();
				dispose();
				TelaAtualizarVet tela = new TelaAtualizarVet(fachada,usuario,vet);
				tela.setVisible(true);
				}
				catch(HistException h){
					JOptionPane.showMessageDialog(null, h.getMessage());
		}
		
			
		}
}}

