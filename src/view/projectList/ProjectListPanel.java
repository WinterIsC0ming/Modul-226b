package view.projectList;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
/**
 *Die Klasse ProjectListPanel erzeugt eine Liste zur Darstellung der einzelnen Objekte vom Typ Project
 *Des weiteren erweitert sie JPanel
 * @author Tommy Winter
 */
public class ProjectListPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JList<?> projectList;
	public final ListModel<?> listModel;

	/**
	 * Ctor für das ListPanel es werden grösse und Layout bestimmt, sowie die
	 * Liste initiert sowie Event Listener hinzugefügt
	 * @param listModel
	 */
	public ProjectListPanel(ListModel<?> listModel) {
		this.listModel = listModel;

		setPreferredSize(new Dimension(300,0));
		setLayout(new BorderLayout());

		projectList = new JList<>(listModel);
		projectList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		projectList.getSelectionModel().addListSelectionListener(e -> doListSelection(e));	

		add(new JScrollPane(projectList),BorderLayout.CENTER);
	}

	public void doListSelection(ListSelectionEvent e) {
	}

	//Setter und Getter der Klasse
	public JList<?> getProjectList() {
		return projectList;
	}

	public ListModel<?> getListModel() {
		return listModel;
	}

}
