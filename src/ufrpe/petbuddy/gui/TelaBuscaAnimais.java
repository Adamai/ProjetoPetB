package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import ufrpe.petbuddy.exceptions.IDException;
import ufrpe.petbuddy.exceptions.RepoException;
import ufrpe.petbuddy.facade.Fachada;
import ufrpe.petbuddy.facade.IFachada;
import ufrpe.petbuddy.negocio.beans.Animal;
import ufrpe.petbuddy.negocio.beans.AnimalEspecie;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class TelaBuscaAnimais extends JFrame implements ActionListener {

	private IFachada fachada;
	private JPanel painel;
	private JTextField campoRaca;
	private JButton botaoVoltar;
	private JButton botaoBusca;
	private ButtonGroup grupo;
	private JRadioButton radioButtonCachorro, radioButtonGato,radioButtonAve,radioButtonRoedor,radioButtonReptil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBuscaAnimais frame = new TelaBuscaAnimais(Fachada.getInstance());
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
	public TelaBuscaAnimais(IFachada fachada) {
		
		this.fachada = fachada; 
		setTitle("PetBuddy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		setContentPane(painel);
		this.grupo = new ButtonGroup();
		
		JLabel textoInsiraOsDados = new JLabel("Insira os dados referentes ao tipo de animal que esta procurando");
		textoInsiraOsDados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textoInsiraOsDados.setBounds(59, 62, 452, 46);
		painel.add(textoInsiraOsDados);
		
		JLabel textoRaca = new JLabel("Ra\u00E7a");
		textoRaca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textoRaca.setBounds(42, 233, 43, 30);
		painel.add(textoRaca);
		
		campoRaca = new JTextField();
		campoRaca.setBounds(95, 234, 352, 30);
		painel.add(campoRaca);
		campoRaca.setColumns(10);
		
		this.radioButtonCachorro = new JRadioButton("Cachorro");
		radioButtonCachorro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioButtonCachorro.setBounds(39, 156, 109, 23);
		radioButtonCachorro.addActionListener(this);
		painel.add(radioButtonCachorro);
		grupo.add(radioButtonCachorro);
		
		this.radioButtonGato = new JRadioButton("Gato");
		radioButtonGato.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioButtonGato.setBounds(187, 156, 109, 23);
		radioButtonGato.addActionListener(this);
		painel.add(radioButtonGato);
		grupo.add(radioButtonGato);
		
		this.radioButtonReptil = new JRadioButton("Reptil");
		radioButtonReptil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioButtonReptil.setBounds(483, 156, 109, 23);
		radioButtonReptil.addActionListener(this);
		painel.add(radioButtonReptil);
		grupo.add(radioButtonReptil);
		
		this.radioButtonRoedor = new JRadioButton("Roedor");
		radioButtonRoedor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioButtonRoedor.setBounds(631, 156, 109, 23);
		radioButtonRoedor.addActionListener(this);
		painel.add(radioButtonRoedor);
		grupo.add(radioButtonRoedor);
		
		this.radioButtonAve = new JRadioButton("Ave");
		radioButtonAve.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radioButtonAve.setBounds(335, 156, 109, 23);
		radioButtonAve.addActionListener(this);
		painel.add(radioButtonAve);
		grupo.add(radioButtonAve);
		
		this.botaoBusca = new JButton("Buscar");
		botaoBusca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoBusca.setBounds(554, 420, 167, 60);
		botaoBusca.addActionListener(this);
		painel.add(botaoBusca);
		
		this.botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botaoVoltar.setBounds(42, 425, 124, 52);
		botaoVoltar.addActionListener(this);
		painel.add(botaoVoltar);
	}
	
	public void actionPerformed(ActionEvent evento){
		
		AnimalEspecie especie = null;
		
		if(evento.getSource().equals(botaoBusca)){
			try{
				String raca = campoRaca.getText();
				
				if(radioButtonCachorro.isSelected()){
					especie = AnimalEspecie.CACHORRO;
				}
				if(radioButtonGato.isSelected()){
					especie = AnimalEspecie.GATO;
				}
				if(radioButtonAve.isSelected()){
					especie = AnimalEspecie.AVE;
				}
				if(radioButtonReptil.isSelected()){
					especie = AnimalEspecie.REPTIL;
				}
				if(radioButtonRoedor.isSelected()){
					especie = AnimalEspecie.ROEDOR;
				}
				ArrayList<Animal> buscados = fachada.buscaAnimais(raca, especie);
				fachada.buscaAnimais(raca, especie);
				
				if(especie != null){
					JOptionPane.showMessageDialog(null, "Aguarde...");
				}
				JOptionPane.showMessageDialog(null, "Busca Realizada com Sucesso");
				//dispose();
				//Tela tela = new Tela(fachada);
				//tela.setVisible(true);
			}	
			catch(NumberFormatException n){
				JOptionPane.showMessageDialog(null, "Dados Inválidos");
			}
			catch(RepoException i){
				JOptionPane.showMessageDialog(null, i.getMessage());
			}}
			else if(evento.getSource().equals(botaoVoltar)){
				dispose();
				TelaPrincipal tela = new TelaPrincipal(fachada);
				tela.setVisible(true);}
		
		}
			}
			

	
	


