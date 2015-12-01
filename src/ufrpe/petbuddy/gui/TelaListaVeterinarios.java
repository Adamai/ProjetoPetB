package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ufrpe.petbuddy.exceptions.HistException;
import ufrpe.petbuddy.negocio.beans.*;
import ufrpe.petbuddy.facade.*;

public class TelaListaVeterinarios extends JFrame implements ActionListener{

	private JPanel painel;
	private JTable table;
	private JButton botaoVoltar;
	private IFachada fachada;
	private Usuario usuario;
	private ArrayList<Veterinario>veterinarios;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
			//	try {
			//		TelaListaVeterinarios frame = new TelaListaVeterinarios();
			//		frame.setVisible(true);
				//} catch (Exception e) {
			//		e.printStackTrace();
			//	}
		//	}
		//});
	//}

	/**
	 * Create the frame.
	 */
	public TelaListaVeterinarios(Usuario usuario,ArrayList<Veterinario> buscados) {
		this.usuario = usuario;
		this.veterinarios = buscados;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		painel.setBackground(new Color(255, 228, 181) );
		setContentPane(painel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 97, 687, 357);
		painel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel modelo = new DefaultTableModel();
		table.setModel(modelo);
		
		this.botaoVoltar = new JButton("Voltar");
		botaoVoltar.setBounds(74, 501, 143, 38);
		botaoVoltar.addActionListener(this);
		painel.add(botaoVoltar);
		
		modelo.addColumn("Nome");
		modelo.addColumn("Contato");
		modelo.addColumn("ID");
				
		table.getColumnModel().getColumn(0).setPreferredWidth(115);
		table.getColumnModel().getColumn(1).setPreferredWidth(115);
		table.getColumnModel().getColumn(2).setPreferredWidth(115);
		
		
			for(int i =0;i< this.veterinarios.size();i++){
				String campo1 = veterinarios.get(i).getNome();
				long campo2 = veterinarios.get(i).getContato();
				long campo3 = veterinarios.get(i).getNumid();
				modelo.addRow(new Object[]{campo1,campo2,campo3});
			}
		
	}
	
	public void actionPerformed(ActionEvent evento){
		if(evento.getSource().equals(botaoVoltar)){
			dispose();
			TelaAdm tela = new TelaAdm(fachada,usuario);
			tela.setVisible(true);
		
	}
		}
	}
