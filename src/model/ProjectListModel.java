package model;

import javax.swing.AbstractListModel;

public class ProjectListModel extends AbstractListModel<Project>{
	private final ProjectModel projectModel;
	
	public ProjectListModel(ProjectModel projectModel) {
		this.projectModel = projectModel;	}

	@Override
	public int getSize() {
		return projectModel.getProjects().size();
	}

	@Override
	public Project getElementAt(int index) {
		return projectModel.getProjects().get(index);
	}

}
