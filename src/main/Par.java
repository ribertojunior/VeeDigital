package main;


/**
 * @author riber
 * Classe para encapsular os pares complementares do Teste 2.
 */
public class Par {
	private int i;
	private int j;
	
	
	/** Construtor da classe
	 * @param i2 índice i do par
	 * @param j2 índice j do par
	 */
	public Par(Integer i2, Integer j2) {
		this.i = i2;
		this.j = j2;
	}
	
	/** Getter do índice i.
	 * @return índice i
	 */
	public int getI() {
		return i;
	}
	/** Setter do índice i.
	 * @param i novo índice
	 */
	public void setI(int i) {
		this.i = i;
	}
	/** Getter do índice j.
	 * @return índice j.
	 */
	public int getJ() {
		return j;
	}
	/** Setter do índice j.
	 * @param j novo índice.
	 */
	public void setJ(int j) {
		this.j = j;
	}
}
