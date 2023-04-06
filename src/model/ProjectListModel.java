package model;

import java.util.List;

import javax.swing.AbstractListModel;

/**
 * Die Klasse ProjectListModel dient dazu eine Liste zu erzeugen,
 * welche zur Verwaltung der Projekte dient.
 * @author Tommy Winter
 *
 * @param <E>
 */
public class ProjectListModel<E> extends AbstractListModel<E> {

	private static final long serialVersionUID = 1L;
	protected List<E> list;

	/**
	 * Ctor für die ProjektListe
	 * @param list aller Projekte
	 */
	public ProjectListModel(List<E> list) {
		this.list = list;
	}

	/**
	 * Fügt ein Objekt der Klasse Projekt der Liste hinzu
	 * @param element
	 */
	public void addElement(E element) {
		list.add(element);
		int index = list.size();
		fireContentsChanged(element, index, index);
	}

	/**
	 * Entfernt ein Objekt der Klasse Projekt aus der Liste
	 * @param element
	 */
	public void removeElement(E element) {
		int index = list.indexOf(element);
		if (index >= 0) {
			list.remove(index);
			fireIntervalRemoved(this, index, index);
		}
	}

	// Setter und Getter der Klasse
	public int getSize() {
		return list.size();
	}

	public E getElementAt(int index) {
		return list.get(index);
	}

}