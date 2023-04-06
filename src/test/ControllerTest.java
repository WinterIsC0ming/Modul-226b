package test;

import static org.mockito.Mockito.*;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;

import org.junit.Before;
import org.junit.Test;

import controller.Controller;
import model.Project;
import view.MainWindow;
import view.projectList.ProjectListPanel;
import view.projectPanel.ProjectPanel;

public class ControllerTest {
	private Controller controller;
	private MainWindow mainWindow;
	private ProjectListPanel projectListPanel;
	private ProjectPanel projectPanel;
	private JList<Project> listProject = new JList<>();

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		controller = new Controller();

		// Erstellt Mock 
		mainWindow = mock(MainWindow.class);
		projectListPanel = mock(ProjectListPanel.class);
		projectPanel = mock(ProjectPanel.class);
		listProject = mock(JList.class);

		// Bereitet Mock Elemente vor
		when(mainWindow.getProjectListPanel()).thenReturn(projectListPanel);
		when(mainWindow.getProjectPanel()).thenReturn(projectPanel);
		// when(projectListPanel.getProjectList()).thenReturn(listProject);
		// Fehler nicht gefunden
	}

	@Test
	public void testDoListSelection() {
		// Erstelle Test Daten
		Project project = new Project("My Project");

		project.setLeader("Tommy Winter");
		project.setTownName("Mogelsberg");
		project.setStartDate("Mai 2022");
		project.setEndDate("Januar 2023");
		project.setCost("100'000.-");
		
		ListSelectionEvent selectionEvent = mock(ListSelectionEvent.class);
		when(listProject.getSelectedValue()).thenReturn(project);

		// Ruft die Methode auf
		controller.doListSelection(selectionEvent);

		// Prüft ob die Richtigen Gesetzt wurden
		verify(projectPanel).setValues("My Project", "Tommy Winter", "Mogelsberg", "Mai 2022", "Januar 2023", "100'000.-");
	}
}

