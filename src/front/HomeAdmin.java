package front;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import back.Admin;
import back.Casa;
import back.Comparator;
import back.IDecimalFormat;
import back.UsuarioPadrao;
import banco.BD;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeAdmin extends JFrame implements IDecimalFormat {

	private JPanel contentPane;
	private JTextField textFieldNomeAdmin;
	private JTable tableUsuariosPadroes;

	public void addRowToJTabel() {
		DefaultTableModel model =  (DefaultTableModel) tableUsuariosPadroes.getModel();
		model.setRowCount(0);
			ArrayList<UsuarioPadrao> listaUsuarios = (ArrayList<UsuarioPadrao>) BD.getUsuariosPadrao();
			Object rowData[] = new Object[3];
			for (UsuarioPadrao usuario : listaUsuarios) {
				
				rowData[0] = usuario.getLogin();
				rowData[1] = usuario.getCasas().size();
				rowData[2] = setDecimal(usuario.getBancaTotal());
				model.addRow(rowData);
			
		}
	}
	
	public HomeAdmin(Admin admin) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNomeAdmin = new JTextField();
		textFieldNomeAdmin.setEditable(false);
		textFieldNomeAdmin.setBounds(6, 6, 130, 26);
		textFieldNomeAdmin.setText(admin.getLogin());
		contentPane.add(textFieldNomeAdmin);
		textFieldNomeAdmin.setColumns(10);
		
		tableUsuariosPadroes =	new JTable(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "Login", "Casas", "Banca Total"
	            }
	        ));
		tableUsuariosPadroes.setBounds(16, 48, 414, 197);
		contentPane.add(tableUsuariosPadroes);
		Collections.sort(BD.getUsuariosPadrao());
		addRowToJTabel();
		
		
		JComboBox comboBoxOrdem = new JComboBox();
		comboBoxOrdem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboBoxOrdem.getSelectedItem());
				if(comboBoxOrdem.getSelectedItem().equals("Alfabética")) {
					Collections.sort(BD.getUsuariosPadrao());
					addRowToJTabel();
				}
				else {
					 Comparator comparator = new Comparator((String)comboBoxOrdem.getSelectedItem());
					 Collections.sort(BD.getUsuariosPadrao(), comparator);
					 addRowToJTabel();
					 
					 /*
					 for (UsuarioPadrao usuario : BD.getUsuariosPadrao()) {
						int cont = 0;
						while(cont < BD.getUsuariosPadrao().size()) {
							comparator.compare(usuario, BD.getUsuariosPadrao().get(cont));
						}
						
					}
					 */
					
				}
			}
		});
		
		comboBoxOrdem.setModel(new DefaultComboBoxModel(new String[] {"Alfabética", "Banca Decrescente", "Banca Crescente"}));
		comboBoxOrdem.setBounds(289, 7, 141, 27);
		contentPane.add(comboBoxOrdem);

	}
}
