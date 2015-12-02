package ufrpe.petbuddy.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ufrpe.petbuddy.facade.Fachada;
import ufrpe.petbuddy.facade.IFachada;
import ufrpe.petbuddy.negocio.beans.Pessoa;
import ufrpe.petbuddy.negocio.beans.Usuario;

public class TelaListaUsuarios extends JFrame implements ActionListener{

	private JPanel painel;
	private Usuario usuario;
	private JTable table;
	private IFachada fachada;
	private JButton botaoVoltar;
	private ArrayList<Usuario>usuarios;


	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				TelaListaUsuarios frame = new TelaListaUsuarios();
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
	public TelaListaUsuarios(Usuario u,ArrayList<Usuario>usuarios) {
		setTitle("PetBuddy");
		this.usuarios = usuarios;
		fachada = Fachada.getInstance();
		this.usuario = u;
		setIconImage(Toolkit.getDefaultToolkit().getImage("Sprites\\sai.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		setBackground(new Color(255, 228, 181) );
		setContentPane(painel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 97, 687, 357);
		painel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel modelo = new DefaultTableModel();
		table.setModel(modelo);
		
		this.botaoVoltar = new JButton("Voltar");
		botaoVoltar.setBounds(44, 481, 168, 53);
		botaoVoltar.addActionListener(this);
		painel.add(botaoVoltar);
		
		modelo.addColumn("Nome");
		modelo.addColumn("Idade");
		modelo.addColumn("Email");
		modelo.addColumn("Contato");
		modelo.addColumn("Endereço");
		
		table.getColumnModel().getColumn(0).setPreferredWidth(115);
		table.getColumnModel().getColumn(1).setPreferredWidth(115);
		table.getColumnModel().getColumn(2).setPreferredWidth(115);
		table.getColumnModel().getColumn(3).setPreferredWidth(115);
		table.getColumnModel().getColumn(4).setPreferredWidth(115);
	
		
		for(int i =0;i<usuarios.size();i++){
			Pessoa p = (Pessoa)usuarios.get(i);
			String campo1 = p.getNome();
			int campo2 = p.getIdade();
			String campo3 = p.getEmail();
			long campo4 = p.getContato();
			String campo5 = p.getEndereco();
			modelo.addRow(new Object[]{campo1,campo2,campo3,campo4,campo5});
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
