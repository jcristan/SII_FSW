package cl.gob.sii.poc.vo;

import java.io.Serializable;

public class CasoVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2837468087874583786L;
	private int     rut;
	private int		anno;
	private int		diferencia;
	public int getRut() {
		return rut;
	}
	public void setRut(int rut) {
		this.rut = rut;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public int getDiferencia() {
		return diferencia;
	}
	public void setDiferencia(int diferencia) {
		this.diferencia = diferencia;
	}
	
}
