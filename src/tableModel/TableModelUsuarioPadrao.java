package tableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;


import dao.DAO;
import model.IDecimalFormat;
import model.UsuarioPadrao;

public class TableModelUsuarioPadrao extends AbstractTableModel implements IDecimalFormat {

	private List<UsuarioPadrao> usuarios = DAO.getUsuariosPadrao();
	private String[] colunas =  new String [] {
            "Login", "Casas", "Banca Total"
        };
	
	
	@Override
	public int getRowCount() {
		return usuarios.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		UsuarioPadrao selectedUser = usuarios.get(rowIndex);
		String valueObject= null;
		
		switch (columnIndex) {
		case 0: valueObject = selectedUser.getLogin(); break;
		case 1: valueObject = String.valueOf( selectedUser.getCasas().size()); break;
		case 2: valueObject = setDecimal(selectedUser.getBancaTotal()); break;
		
		default: throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
		
		return valueObject;
	}

}
