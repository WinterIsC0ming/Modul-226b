package model;

import java.io.Serializable;
import java.util.ArrayList;

public class ProjectModel implements Serializable {
	
	private final ArrayList<Project> projects = new ArrayList<>();
	
	public ProjectModel() {
		
	}
	
	public void addProject(Project project) {
		projects.add(project);
	}
	
	public boolean removeProject(Project project) {
		boolean result = projects.remove(project);
		
		return result;
	}
	
	public ArrayList<Project> getProjects(){
		return projects;
	}

}
