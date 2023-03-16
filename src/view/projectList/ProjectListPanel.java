package view.projectList;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

public class ProjectListPanel extends JPanel {
	
	private final JList projectList;
	private final ListModel<?> listModel;
	
	public ProjectListPanel(ListModel<?> listModel) {
		this.listModel = listModel;
		
		setPreferredSize(new Dimension(400,0));
		setLayout(new BorderLayout());
		
		projectList = new JList<>(listModel);
		projectList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		projectList.getSelectionModel().addListSelectionListener(e -> doListSelection(e));	
		
		add(new JScrollPane(projectList),BorderLayout.CENTER);
	}

	private void doListSelection(ListSelectionEvent e) {
		System.out.println("DoListSelection");

	}
	
	public JList<?> getProjectList() {
		return projectList;
	}

}
