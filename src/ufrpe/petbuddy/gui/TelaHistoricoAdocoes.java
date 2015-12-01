package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import ufrpe.petbuddy.facade.*;

import java.util.ArrayList;

import ufrpe.petbuddy.exceptions.*;
import ufrpe.petbuddy.negocio.beans.*;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaHistoricoAdocoes extends JFrame implements ActionListener{

	private JPanel painel;
	private JTable table;
	private IFachada fachada;
	private JButton botaoVoltar;
	private Usuario usuario;
	private ArrayList<Adocao>adocoes;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
				//try {
				//	TelaHistoricoAdocoes frame = new TelaHistoricoAdocoes();
					//frame.setVisible(true);
				//} catch (Exception e) {
				//	e.printStackTrace();
				//}
			//}
		//});
//	}

	/**
	 * Create the frame.
	 */
	public TelaHistoricoAdocoes(Usuario usuario,ArrayList<Adocao> adocoes) {
		this.usuario = usuario;
		this.adocoes = adocoes;
		fachada = Fachada.getInstance();
		setTitle("PetBuddy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
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
		
		JLabel lblHistricoDeAdoes = new JLabel("Hist\u00F3rico de Ado\u00E7\u00F5es");
		lblHistricoDeAdoes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHistricoDeAdoes.setBounds(44, 11, 183, 56);
		painel.add(lblHistricoDeAdoes);
		
		modelo.addColumn("Animal");
		modelo.addColumn("Adotante");
		modelo.addColumn("Data");
		modelo.addColumn("ID Adoção");
		
		table.getColumnModel().getColumn(0).setPreferredWidth(115);
		table.getColumnModel().getColumn(1).setPreferredWidth(115);
		table.getColumnModel().getColumn(2).setPreferredWidth(115);
		table.getColumnModel().getColumn(3).setPreferredWidth(115);
			
		for(int i =0;i<this.adocoes.size();i++){
			String campo1 = this.adocoes.get(i).getAnimal().getNome();
			String campo2 = this.adocoes.get(i).getPessoa().getNome();
			String campo3 = this.adocoes.get(i).getData();
			long campo4 = this.adocoes.get(i).getNumid();
			modelo.addRow(new Object[]{campo1,campo2,campo3,campo4});
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
