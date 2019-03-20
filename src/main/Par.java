package main;


/**
 * @author riber
 * Classe para encapsular os pares complementares do Teste 2.
 */
public class Par {
	private int i;
	private int j;
	
	
	/** Construtor da classe
	 * @param i2 �ndice i do par
	 * @param j2 �ndice j do par
	 */
	public Par(Integer i2, Integer j2) {
		this.i = i2;
		this.j = j2;
	}
	
	/** Getter do �ndice i.
	 * @return �ndice i
	 */
	public int getI() {
		return i;
	}
	/** Setter do �ndice i.
	 * @param i novo �ndice
	 */
	public void setI(int i) {
		this.i = i;
	}
	/** Getter do �ndice j.
	 * @return �ndice j.
	 */
	public int getJ() {
		return j;
	}
	/** Setter do �ndice j.
	 * @param j novo �ndice.
	 */
	public void setJ(int j) {
		this.j = j;
	}
}
