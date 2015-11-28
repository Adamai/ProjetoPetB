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

public class TelaHistoricoAdocoes extends JFrame {

	private JPanel painel;
	private JTable table;
	private IFachada fachada;

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
		scrollPane.setBounds(28, 87, 687, 424);
		painel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel modelo = new DefaultTableModel();
		table.setModel(modelo);
		
		modelo.addColumn("Animal");
		modelo.addColumn("Adotante");
		modelo.addColumn("Data");
		
		table.getColumnModel().getColumn(0).setPreferredWidth(115);
		table.getColumnModel().getColumn(1).setPreferredWidth(115);
		table.getColumnModel().getColumn(2).setPreferredWidth(115);
		
		try{
			ArrayList<Adocao> adocoes = fachada.buscaHistoricoAdocoes();
			for(int i =0;i<adocoes.size();i++){
				String campo1 = adocoes.get(i).getAnimal().getNome();
				String campo2 = adocoes.get(i).getPessoa().getNome();
				String campo3 = adocoes.get(i).getData();
				modelo.addRow(new Object[]{campo1,campo2,campo3});
			}
		}
		catch(HistException h){
			JOptionPane.showMessageDialog(null, h.getMessage());
		}
	}
}
