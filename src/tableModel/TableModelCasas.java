package tableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Casa;
import model.IDecimalFormat;
import model.UsuarioPadrao;
import view.TelaCom;

public class TableModelCasas extends AbstractTableModel implements IDecimalFormat {

	private List<Casa> casas;
	private String[] colunas =  new String [] {
            "Nome", "Banca"
        };
	
	public TableModelCasas(UsuarioPadrao usuario) {
		casas = usuario.getCasas();
	}
	
	
	@Override
	public int getRowCount() {
		return casas.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Casa casa = casas.get(rowIndex);
		String valueObject = null;
		
		switch (columnIndex) {
			case 0: valueObject =  casa.getNome(); break;
			case 1: valueObject = setDecimal(casa.getBanca()); break;
			
			default: TelaCom msg = new TelaCom("Indice Invalido");
		}
		return valueObject;
	}

}
