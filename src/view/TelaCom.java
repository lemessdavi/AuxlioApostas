package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class TelaCom extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String texto;

	/**
	 * Create the frame.
	 */
	private void initComponentes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 322, 170);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField(texto);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(UIManager.getColor("Button.background"));
		textField.setEditable(false);
		textField.setBounds(33, 25, 243, 68);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	public TelaCom(String texto) {
		this.texto = texto;
		initComponentes();
	}
}
