/**
 * @author Carmine Cristian Cruoglio
 * @author Adalgiso Della Calce
 * @author Stefano Linguiti
 * @author Gilberto Recupito
 */
package Model;

import java.util.GregorianCalendar;

public class PostBean {
	private int idPost;
	private String idUtente;
	private int idFoto;
	private String descrizione;
	private GregorianCalendar data;
	private GregorianCalendar ora;
	private String stato;
	
	
	public PostBean() { }

	public int getIdPost() {
		return idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}

	public String getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}

	public int getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(int idFoto) {
		this.idFoto = idFoto;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public GregorianCalendar getData() {
		return data;
	}

	public void setData(GregorianCalendar data) {
		this.data = data;
	}

	public GregorianCalendar getOra() {
		return ora;
	}

	public void setOra(GregorianCalendar ora) {
		this.ora = ora;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}
	
	public int getYear() {
		return this.data.get(GregorianCalendar.YEAR);
	}
	
	public int getMonth() {
		return this.data.get(GregorianCalendar.MONTH)+1;
	}
	
	public int getDay() {
		return this.data.get(GregorianCalendar.DAY_OF_MONTH);
	}
	
	public int getHour() {
		return this.ora.get(GregorianCalendar.HOUR_OF_DAY);
	}
	
	public int getMinute() {
		return this.ora.get(GregorianCalendar.MINUTE);
	}
	
	public int getSecond() {
		return this.ora.get(GregorianCalendar.SECOND);
	}
	
	public String getStringData () {
		return this.getYear()+"-"+this.getMonth()+"-"+this.getDay();
	}
	
	public String getStringOra() {
		return this.getHour()+":"+this.getMinute()+":"+this.getSecond();
	}
}
