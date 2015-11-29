package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaHistoricoAdocoes frame = new TelaHistoricoAdocoes();
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
	public TelaHistoricoAdocoes() {
		fachada = Fachada.getInstance();
		setTitle("PetBuddy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
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
		modelo.addColumn("ID Ado��o");
		
		table.getColumnModel().getColumn(0).setPreferredWidth(115);
		table.getColumnModel().getColumn(1).setPreferredWidth(115);
		table.getColumnModel().getColumn(2).setPreferredWidth(115);
		table.getColumnModel().getColumn(3).setPreferredWidth(115);
		
		try{
			ArrayList<Adocao> adocoes = fachada.buscaHistoricoAdocoes();
			for(int i =0;i<adocoes.size();i++){
				String campo1 = adocoes.get(i).getAnimal().getNome();
				String campo2 = adocoes.get(i).getPessoa().getNome();
				String campo3 = adocoes.get(i).getData();
				long campo4 = adocoes.get(i).getNumid();
				modelo.addRow(new Object[]{campo1,campo2,campo3,campo4});
			}
		}
		catch(HistException h){
			JOptionPane.showMessageDialog(null, h.getMessage());
		}
	}
	
	public void actionPerformed(ActionEvent evento){
		if(evento.getSource().equals(botaoVoltar)){
			dispose();
			TelaAdm tela = new TelaAdm(fachada);
			tela.setVisible(true);
		}
	}
}