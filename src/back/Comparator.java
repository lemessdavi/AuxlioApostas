package back;

public class Comparator implements java.util.Comparator<UsuarioPadrao> {
	
	private String type;
	
	public Comparator(String type) {
		this.type = type;
	}
	
	@Override
	public int compare(UsuarioPadrao o1, UsuarioPadrao o2) {
		if (type ==  "Banca Decrescente") {
			if (o1.getBancaTotal() < o2.getBancaTotal()) {
				return -1;
			}
			if (o2.getBancaTotal() < o1.getBancaTotal()) {
				return 1;
			}else {
				return 0;
			}
		}
		else {
			if (o1.getBancaTotal() < o2.getBancaTotal()) {
				return 1;
			}
			if (o2.getBancaTotal() < o1.getBancaTotal()) {
				return -1;
			}else {
				return 0;
			}
		}
		
	}

	
}
