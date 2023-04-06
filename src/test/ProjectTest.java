package test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import model.Project;

public class ProjectTest {

	@Test
	public void testConstructor() {
		String projectName = "Test Project";
		Project project = new Project(projectName);
		assertEquals(projectName, project.getProjectName());
	}

	@Test
	public void testProjectSerialization() throws Exception {
		Project project = new Project("My Project");

		project.setLeader("Tommy Winter");
		project.setTownName("Mogelsberg");
		project.setStartDate("Mai 2022");
		project.setEndDate("Januar 2023");
		project.setCost("100'000");

		// Serialize
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(bos);
		out.writeObject(project);
		byte[] bytes = bos.toByteArray();

		// Deserialize
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInputStream in = new ObjectInputStream(bis);
		Project deserializedProject = (Project) in.readObject();

		// überprüfung ob nach serialize und deserialize Daten noch identisch
		assertEquals(project.getProjectName(), deserializedProject.getProjectName());
		assertEquals(project.getLeader(), deserializedProject.getLeader());
		assertEquals(project.getTownName(), deserializedProject.getTownName());
		assertEquals(project.getStartDate(), deserializedProject.getStartDate());
		assertEquals(project.getEndDate(), deserializedProject.getEndDate());
		assertEquals(project.getCost(), deserializedProject.getCost());
	}
}
