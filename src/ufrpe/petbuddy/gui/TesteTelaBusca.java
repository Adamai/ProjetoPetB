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

public class TesteTelaBusca extends JFrame implements ActionListener,ListSelectionListener{

	private JPanel contentPane;
	private JButton botaoAdotar;
	private JList lista;
	private DefaultListModel listmodel;
	private IFachada fachada;
	private JScrollPane scrollPane;
	private JEditorPane campoDados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteTelaBusca frame = new TesteTelaBusca();
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
	public TesteTelaBusca() {
		fachada = Fachada.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		try{
		//Usuario vet = new Veterinario("jose",15,123456789,12345687);
		//Animal a = new Animal("ringo","york","macho",12.1,10,"saudavel","calmo",(Veterinario)vet,AnimalEspecie.CACHORRO);
		//Animal b = new Animal("like","york","macho",12.1,10,"saudavel","calmo",(Veterinario)vet,AnimalEspecie.CACHORRO);
		//Animal c = new Animal("bia","york","femea",12.1,10,"saudavel","calmo",(Veterinario)vet,AnimalEspecie.CACHORRO);
		//fachada.cadastrarAnimal(a);
		//fachada.cadastrarAnimal(b);
		//fachada.cadastrarAnimal(c);
		listmodel = new DefaultListModel<Animal>();
		ArrayList<Animal> buscados = fachada.buscaAnimais("york", AnimalEspecie.CACHORRO);
		
		for(int i = 0; i<buscados.size();i++){
			listmodel.addElement(buscados.get(i));
		}

		}
		catch(RepoException e){
			System.out.println(e.getMessage());
		}
		//catch(DadosException d){
		//	System.out.println(d.getMessage());
		//}
		
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
		
		this.botaoAdotar = new JButton("Adotar");
		botaoAdotar.setBounds(493, 446, 141, 56);
		botaoAdotar.addActionListener(this);
		botaoAdotar.setEnabled(false);
		contentPane.add(botaoAdotar);
		
		this.campoDados = new JEditorPane();
		campoDados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoDados.setBounds(433, 90, 278, 259);
		contentPane.add(campoDados);
	}
	
	public void valueChanged(ListSelectionEvent evento){
		//int index = lista.getSelectedIndex();
		campoDados.setText(((Animal)lista.getSelectedValue()).exibirDados());
		botaoAdotar.setEnabled(true);
	}
	
	public void actionPerformed(ActionEvent evento){

		
			}
	}

