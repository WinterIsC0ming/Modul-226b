package view;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import controller.Controller;
import view.menu.MainMenuBar;
import view.projectList.ProjectListPanel;
import view.projectPanel.ProjectPanel;

public class MainWindow extends JFrame {
	
	private final Controller controller;
	private ProjectListPanel projectListPanel;
	private ProjectPanel projectPanel;
	
	public MainWindow(Controller controller)	{
		this.controller = controller;
		
		init();
		setJMenuBar (new MainMenuBar(controller));
		
		add(buildProjectListPanel(),BorderLayout.WEST);
		add(buildProjectPanel(),BorderLayout.CENTER);		
		
	}
	
	private Component buildProjectPanel() {
		projectPanel = new ProjectPanel();
		return projectPanel;
	}
	
	public ProjectPanel getProjectPanel() {
		return projectPanel;
	}

	private Component buildProjectListPanel() {
		projectListPanel = new ProjectListPanel(controller.getProjectListModel());
		
		return projectListPanel;
	}
	
	public ProjectListPanel getProjectListPanel() {
		return projectListPanel;
	}

	private void init() {
		setTitle("Projektverwaltung");
		setSize(700,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
	}



}
