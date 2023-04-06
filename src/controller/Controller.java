package controller;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import model.InputOutput;
import model.Project;
import model.ProjectListModel;
import view.MainWindow;
import view.projectPanel.ProjectPanel;

/**
 * Über die Controller Klasse wird die komplette App
 * gesteuert und das main Window aufgerufen.
 * @author Tommy Winter
 */
public class Controller {

	private MainWindow mainWindow;
	private JList<Project> listProject = new JList<>();
	private  ProjectListModel<Project> projectListModel;
	private static java.util.List<Project> projects = new ArrayList<>();

	/**
	 * Ctor für die Kontroller Klasse
	 * Ruft das MainWindow auf
	 * Fügt das Handling der Buttons und Liste ein
	 * Und erstellt ein ProjecktListModel
	 */
	public Controller() {

		initProjectListModel();
		initMainWindow();
		addProjectHandling();
	}

	/**
	 * Erstellt ein ProjectLsitModel und holt sich die Daten aus der Txt Datei,
	 * und füllt diese ab.
	 */
	@SuppressWarnings("unchecked")
	private void initProjectListModel() {

		projectListModel = new ProjectListModel<Project>(getProjects());
		listProject.setModel(projectListModel);
		try (FileInputStream fis = new FileInputStream("Project.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			projects = (ArrayList<Project>) ois.readObject();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
		}
		for (Project proj : getProjects()) {
			projectListModel.addElement(proj);
		}
	}

	/**
	 * Ruft das MainWindow auf.
	 */
	public void initMainWindow() {
		mainWindow = new MainWindow(Controller.this);
		mainWindow.setVisible(true);
	}

	/**
	 * Weiste die ActionEvents den einzelnen Buttons zu.
	 * Der ListSelction event wird auch aufgerufen
	 */
	public void addProjectHandling() {
		mainWindow.getProjectListPanel().getProjectList().getSelectionModel()
		.addListSelectionListener(e -> doListSelection(e));

		mainWindow.getProjectPanel().getBtnReset().addActionListener(e -> doResetProjectPanel(e));
		mainWindow.getProjectPanel().getBtnSave().addActionListener(e -> doSavetProjectPanel(e));
		mainWindow.getProjectPanel().getBtnAdd().addActionListener(e -> addProject(e));
		mainWindow.getProjectPanel().getBtnRemove().addActionListener(e -> removeProject(e));
	}

	/**
	 * Speichert die Werte eines bereits erstellten Projektes wenn diese verändert worden sind.
	 * Und speichert diese in die txt Datei
	 * @param e reagiert auf Klick des Buttons Save
	 */
	private void doSavetProjectPanel(ActionEvent e) {
		Project p = (Project) mainWindow.getProjectListPanel().getProjectList().getSelectedValue();
		ProjectPanel pp = mainWindow.getProjectPanel();

		p.setProjectName(pp.getProjectNameField().getText());
		p.setLeader(pp.getLeaderField().getText());
		p.setTownName(pp.getTownNameField().getText());
		p.setStartDate(pp.getStartDateField().getText());
		p.setEndDate(pp.getStartDateField().getText());
		p.setCost(pp.getCostField().getText());

		InputOutput inputOutput = new InputOutput();
		inputOutput.writer();
	}

	/**
	 * holt die Werte des Projekte wieder wenn diese Verändert worden sind ohne zu Speicher.
	 * @param e reagiert auf einen Klick des Buttons reset
	 */
	public void doResetProjectPanel(ActionEvent e) {
		Project p = (Project) mainWindow.getProjectListPanel().getProjectList().getSelectedValue();
		if (p != null) {
			mainWindow.getProjectPanel().setValues(p.getProjectName(),
					p.getLeader(), p.getTownName(), p.getStartDate(),
					p.getEndDate(), p.getCost());
		}
	}

	/**
	 * Holt sich die Werte eines Projektes und zeigt diese an.
	 * @param e reagiert auf die Auswahl eines ListenElements
	 */
	public void doListSelection(ListSelectionEvent e) {
		Project p = (Project) mainWindow.getProjectListPanel().getProjectList().getSelectedValue();
		if (p != null) {
			mainWindow.getProjectPanel().setValues(p.getProjectName(),
					p.getLeader(), p.getTownName(), p.getStartDate(),
					p.getEndDate(), p.getCost());
		}
	}

	/**
	 * Entfernt das Ausgewählte Element aus der Liste.
	 * @param e reagiert auf einen Klick des Butons Remove
	 */
	public void removeProject(ActionEvent e) {
		Project pr = (Project) mainWindow.getProjectListPanel().getProjectList().getSelectedValue();
		if (pr != null) {
			projectListModel.removeElement(pr);
			getProjects().remove(pr);
			InputOutput inputOutput = new InputOutput();
			inputOutput.writer();
		}
	}

	/**
	 * Fügt der Liste ein Projekt hinzu und Schreibt diese in die txt Datei.
	 * Das Projekt kann über ein Popupfenster mit einem Namen versehen werden.
	 * @param e reagiert auf einen Klick vom Button New
	 */
	public void addProject(ActionEvent e) {
		String projectName = JOptionPane.showInputDialog("Name des neuen Project:");
		if (projectName != null) {
			projectListModel.addElement(new Project(projectName));
			getProjects().add(new Project(projectName));
			InputOutput inputOutput = new InputOutput();
			inputOutput.writer();
		}
	}

	//Ausstieg aus der App benutzung noch offen
	public void exit() {
		getMainWindow().dispose();
	}


	//Setter und Getter der Klasse
	public static java.util.List<Project> getProjects() {
		return projects;
	}

	public ListModel<?> getProjectListModel() {
		return projectListModel;
	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}

}
