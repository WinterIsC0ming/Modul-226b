package view;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import controller.Controller;
import view.projectList.ProjectListPanel;
import view.projectPanel.ProjectPanel;

/**
 * Die MainWindow Klasse dient dazu die einzelnen Visuellen Komponenten
 * zusammenzuführen und diese darzustellen.
 * Die Main Window Klasse erweitert JFrame.
 * @author Tommy Winter
 *
 */
public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private final Controller controller;
	private ProjectListPanel projectListPanel;
	private ProjectPanel projectPanel;

	/**
	 * Ctor für das MainWindow, das Projectpanel sowie das Projectlsitpanel werden
	 * dem Main Window hinzugefügt, des weiteren wird das Main Window selbst
	 * inizialisiert. Auch wird hier der Kontroller ans Main Window übergeben.
	 * 
	 * @param controller
	 */
	public MainWindow(Controller controller) {
		this.controller = controller;
		init();
		add(buildProjectListPanel(), BorderLayout.WEST);
		add(buildProjectPanel(), BorderLayout.CENTER);

	}

	/**
	 * Optische Eckdaten für das MainWindow wo die einzelnen Komponenten eingefügt
	 * werden
	 */
	private void init() {
		setTitle("Projektverwaltung");
		setSize(650, 450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
	}

	/**
	 * Erzeugt ein neues ProjectPanel
	 * @return gibt das erzeugte Panel zurück
	 */
	private Component buildProjectPanel() {
		projectPanel = new ProjectPanel();
		return projectPanel;
	}

	/**
	 * Erzeugt eine neue ProjectListPanel
	 * @return gibt das erzeugte ListPanel zurück
	 */
	private Component buildProjectListPanel() {
		projectListPanel = new ProjectListPanel(controller.getProjectListModel());
		return projectListPanel;
	}

	//Setter und Getter der Klasse
	public ProjectListPanel getProjectListPanel() {
		return projectListPanel;
	}

	public ProjectPanel getProjectPanel() {
		return projectPanel;
	}

}
