package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import view.projectPanel.ProjectPanel;

public class ProjectPanelTest {

	private ProjectPanel projectPanel;

	@Before
	public void setUp() throws Exception {
		projectPanel = new ProjectPanel();
	}

	// Test für die SetValue Methode
	@Test
	public void testSetValues() {
		// Werte werden festgelegt
		String projectName = "Test project";
		String leader = "Tommy Winter";
		String townName = "Mogelsberg";
		String startDate = "Mai 2023";
		String endDate = "Juni 2023";
		String cost = "1000.-";

		// werte werden ins Projectpanel eingefügt und überprüft
		projectPanel.setValues(projectName, leader, townName, startDate, endDate, cost);

		assertEquals(projectPanel.getProjectNameField().getText(), projectName);
		assertEquals(projectPanel.getLeaderField().getText(), leader);
		assertEquals(projectPanel.getTownNameField().getText(), townName);
		assertEquals(projectPanel.getStartDateField().getText(), startDate);
		assertEquals(projectPanel.getEndDateField().getText(), endDate);
		assertEquals(projectPanel.getCostField().getText(), cost);
	}
}


