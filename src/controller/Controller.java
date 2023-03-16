package controller;

import java.awt.event.ActionEvent;

import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;

import model.Project;
import model.ProjectListModel;
import model.ProjectModel;
import view.MainWindow;
import view.actions.Actions;
import view.projectPanel.ProjectPanel;

public class Controller {
	
	protected MainWindow mainWindow;
	private Actions actions;
	private ProjectModel projectModel;


	public Controller() {
		
		initProjectListModel();
		initActions();
		initMainWindow();
		
		addProjectHandling();
		
	}
	
	
	private void addProjectHandling() {
		mainWindow.getProjectListPanel().getProjectList().getSelectionModel()
		.addListSelectionListener(e -> doListSelection(e));
		
		mainWindow.getProjectPanel().getBtnReset().addActionListener(e -> doResetProjectPanel(e));
		mainWindow.getProjectPanel().getBtnSave().addActionListener(e -> doSavetProjectPanel(e));
	
		
	}


	private void doSavetProjectPanel(ActionEvent e) {
		Project p = (Project) mainWindow.getProjectListPanel().getProjectList().getSelectedValue();
		ProjectPanel pp = mainWindow.getProjectPanel();
		
		p.setProjectName(pp.getProjectNameField().getText());
		p.setLeader(pp.getLeaderField().getText());
		p.setTownName(pp.getTownNameField().getText());
		p.setStartDate(pp.getStartDateField().getText());
		p.setEndDate(pp.getStartDateField().getText());
		p.setCost(pp.getCostField().getText());
		
	}


	private void doResetProjectPanel(ActionEvent e) {
		Project p = (Project) mainWindow.getProjectListPanel().getProjectList().getSelectedValue();
		
		mainWindow.getProjectPanel().setValues(p.getProjectName()
				,p.getLeader(),p.getTownName(),p.getStartDate()
				,p.getEndDate(),p.getCost());
	}



	private void doListSelection(ListSelectionEvent e) {
		Project p = (Project) mainWindow.getProjectListPanel().getProjectList().getSelectedValue();
		
		mainWindow.getProjectPanel().setValues(p.getProjectName()
				,p.getLeader(),p.getTownName(),p.getStartDate()
				,p.getEndDate(),p.getCost());
	}


	private void initActions() {
		actions = new Actions(this);

		
	}
	
	public Actions getActions() {

		return actions;
	}


	private void initMainWindow() {

				mainWindow = new MainWindow(Controller.this);
				mainWindow.setVisible(true);
				

	}
	
	public MainWindow getMainWindow() {
		return mainWindow;
	}
	
	public void exit() {
		getMainWindow().dispose();	}


	public void searchElement() {
		System.out.println("Search aufruf");
	}
	
	public void addElement() {
		System.out.println("add");
	}

	public void removeElement() {
		System.out.println("remove");
	}
	
	

	private ProjectListModel projectListModel;

	public ListModel<?> getProjectListModel() {

		return projectListModel;
	}
	
	private void initProjectListModel() {
		
		projectModel = new ProjectModel();
		projectListModel = new ProjectListModel(projectModel);
		
		projectModel.addProject(new Project("Anschaffung Geräte"));
		projectModel.addProject(new Project("Abbau der alten Infastruktur"));
		projectModel.addProject(new Project("Aufbau der neuen Infastruktur"));
		
	}





}
