package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import ufrpe.petbuddy.exceptions.DadosException;
import ufrpe.petbuddy.exceptions.RepoException;
import ufrpe.petbuddy.facade.*;
import ufrpe.petbuddy.negocio.beans.AnimalEspecie;

import java.util.ArrayList;

import ufrpe.petbuddy.negocio.beans.*;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;

public class TelaResultadoBusca extends JFrame implements ActionListener,ListSelectionListener{

	private JPanel contentPane;
	private JButton botaoAdotar;
	private JButton botaoVoltar;
	private JList lista;
	private DefaultListModel listmodel;
	private IFachada fachada;
	private Usuario usuario;
	private JScrollPane scrollPane;
	private JEditorPane campoDados;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				TelaResultadoBusca frame = new TelaResultadoBusca();
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
	public TelaResultadoBusca(IFachada fachada, Usuario u,ArrayList<Animal>resultado) {
		fachada = Fachada.getInstance();
		usuario = u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		//Usuario vet = new Veterinario("jose",15,123456789,12345687);
		//Animal a = new Animal("ringo","york","macho",12.1,10,"saudavel","calmo",(Veterinario)vet,AnimalEspecie.CACHORRO);
		//Animal b = new Animal("like","york","macho",12.1,10,"saudavel","calmo",(Veterinario)vet,AnimalEspecie.CACHORRO);
		//Animal c = new Animal("bia","york","femea",12.1,10,"saudavel","calmo",(Veterinario)vet,AnimalEspecie.CACHORRO);
		//fachada.cadastrarAnimal(a);
		//fachada.cadastrarAnimal(b);
		//fachada.cadastrarAnimal(c);
		listmodel = new DefaultListModel();
		ArrayList<Animal> buscados = resultado;
		
		for(int i = 0; i<buscados.size();i++){
			listmodel.addElement(buscados.get(i));
		}

	
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 89, 224, 413);
		contentPane.add(scrollPane);
		
		
		lista = new JList(listmodel);
		scrollPane.setViewportView(lista);
		lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		lista.addListSelectionListener(this);
		lista.setLayoutOrientation(JList.VERTICAL);
		
		JLabel lblNewLabel = new JLabel("Animais");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(38, 30, 150, 48);
		contentPane.add(lblNewLabel);
		
		if(u instanceof Pessoa){
			this.botaoAdotar = new JButton("Adotar");
			botaoAdotar.setBounds(493, 446, 141, 56);
			botaoAdotar.addActionListener(this);
			botaoAdotar.setEnabled(false);
			contentPane.add(botaoAdotar);
		}
		
		this.campoDados = new JEditorPane();
		campoDados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoDados.setBounds(433, 90, 278, 259);
		contentPane.add(campoDados);
		
		this.botaoVoltar = new JButton("Voltar");
		botaoVoltar.setBounds(377, 462, 107, 40);
		botaoVoltar.addActionListener(this);
		contentPane.add(botaoVoltar);
	}
	
	public void valueChanged(ListSelectionEvent evento){
		//int index = lista.getSelectedIndex();
		campoDados.setText(((Animal)lista.getSelectedValue()).exibirDados());
		botaoAdotar.setEnabled(true);
	}
	
	public void actionPerformed(ActionEvent evento){
		
		if(evento.getSource().equals(botaoVoltar)){
			if(usuario == null){
				dispose();
				TelaPrincipal tela = new TelaPrincipal(fachada);
				tela.setVisible(true);
			}
			else if(usuario instanceof Pessoa){
				dispose();
				TelaLogado tela = new TelaLogado(fachada,usuario);
				tela.setVisible(true);
			}
			else if(usuario instanceof Adm){
				dispose();
				TelaAdm tela = new TelaAdm(fachada);
				tela.setVisible(true);
			}
			
		}// fim IF VOLTAR
		
			}
	}

