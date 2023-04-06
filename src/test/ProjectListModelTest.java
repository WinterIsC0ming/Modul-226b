package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import model.ProjectListModel;

public class ProjectListModelTest {

	//Test für das hinzufügen eines Elementes zur Liste
	@Test
	public void testAddElement() {
		List<String> projects = new ArrayList<>(Arrays.asList("Projekt A", "Projekt B", "Projekt C"));
		ProjectListModel<String> model = new ProjectListModel<>(projects);
		assertEquals(3, model.getSize());
		model.addElement("Projekt D");
		assertEquals(4, model.getSize());
		assertEquals("Projekt D", model.getElementAt(3));
	}

	//Test für das entfernen eines Elementes aus der Liste
	@Test
	public void testRemoveElement() {
		List<String> projects = new ArrayList<>(Arrays.asList("Projekt A", "Projekt B", "Projekt C"));
		ProjectListModel<String> model = new ProjectListModel<>(projects);
		assertEquals(3, model.getSize());
		model.removeElement("Projekt B");
		assertEquals(2, model.getSize());
		assertEquals("Projekt C", model.getElementAt(1));
	}	
}
