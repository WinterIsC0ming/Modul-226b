package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Die Klasse Project dient dazue alle Werte der eines
 * Object vom Typ Project zu definieren.
 * Des weiteren implementiert die Klasse serializable um die Objekte
 * fürs Lesen und Schreiben vorbereiten
 * @author Tommy Winter 
 */
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;
	private String projectName;
	private String leader = "Keine Daten";
	private String townName = "Keine Daten";
	private String startDate = "Keine Daten";
	private String endDate = "Keine Daten";
	private String cost = "Keine Daten";

	/**
	 * Ctor für ein Project einziger Parameter der übergeben werden muss
	 * ist der Projektname, alle anderen können später angepasst werden.
	 * @param projectName Name/bezeichnung des Projekts
	 */
	public Project(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * Schreibt die Daten von String in UTF8(Modifiziert) um.
	 * @param s
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream s) throws IOException {
		s.writeUTF(projectName);
		s.writeUTF(leader);
		s.writeUTF(townName);
		s.writeUTF(startDate);
		s.writeUTF(endDate);
		s.writeUTF(cost);
	}

	/**
	 * Liest die Daten von UTF8(Modifiziert)Format aus ->String
	 * @param s
	 * @throws IOException
	 */
	private void readObject(ObjectInputStream s) throws IOException {
		projectName = s.readUTF();
		leader = s.readUTF();
		townName = s.readUTF();
		startDate = s.readUTF();
		endDate = s.readUTF();
		cost = s.readUTF();
	}

	// Alle Setter und Getter der Klasse
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getLeader() {
		return leader;
	}

	public String getProjectName() {
		return projectName;
	}

	// Setter für den Projekt Namen darf nicht null sein
	public void setProjectName(String projectName) {
		if (projectName == null) {
			throw new IllegalArgumentException();
		}
		this.projectName = projectName;
	}

	public String getTownName() {
		return townName;
	}

	public String getCost() {
		return cost;
	}

	//To String Methode für den Projekt Namen
	public String toString() {
		return projectName;
	}

}
