package view.projectPanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import net.miginfocom.swing.MigLayout;
/**
 *Die Klasse ProjectPanel erzeugt das Panel in dem die Projectdaten angezeigt werden sowie die Buttons
 * @author Tommy Winter

 */
public class ProjectPanel extends JPanel implements DocumentListener {

	private static final long serialVersionUID = 1L;
	private JTextField projectNameField;
	private JTextField leaderField;
	private JTextField townNameField;
	private JTextField startDateField;
	private JTextField endDateField;
	private JTextField costField;

	private JLabel projectNameLabel;
	private JLabel leaderLabel;
	private JLabel townNameLabel;
	private JLabel startDateLabel;
	private JLabel endDateLabel;
	private JLabel costLabel;

	private JButton btnReset;
	private JButton btnSave;
	private JButton btnRemove;
	private JButton btnAdd;

	/**
	 * Das Panel wird erzeugt mit ButtonPanel und FormPanel
	 * und das Layout wird festgelegt.
	 */
	public ProjectPanel() {
		setLayout(new BorderLayout());
		add(buildFormPanel(),BorderLayout.CENTER);
		add(buildButtonPanel(),BorderLayout.SOUTH);	
	}

	/**
	 * Der Buttonpanel wird erstellt und dem Panel bp hinzugefügt
	 * @return gibt das Buttonpanel zurück
	 */
	public Component buildButtonPanel() {
		JPanel bp = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		btnReset = new JButton("Reset");
		btnSave = new JButton("Save");	
		btnAdd = new JButton("New");
		btnRemove= new JButton("Remove");	
		setEnableButtons(false);	
		bp.add(btnReset);
		bp.add(btnSave);	
		bp.add(btnAdd);
		bp.add(btnRemove);
		return bp;
	}

	/**
	 * Gibt die Buttons frei wen eine Veränderung der TextFields stattgefunden hat
	 * @param enabled
	 */
	private void setEnableButtons(boolean enabled){
		btnReset.setEnabled(enabled);
		btnSave.setEnabled(enabled);		
	}

	/**
	 * Das Formpanel wird erstellt und dem Panel fp hinzugefügt
	 * @return gibt das Formpanel zurück
	 */
	public JComponent buildFormPanel(){

		JPanel fp = new JPanel(new MigLayout());

		projectNameLabel = new JLabel("Projekt Name:");
		projectNameField = new JTextField(25);
		fp.add(projectNameLabel,"wrap");
		fp.add(projectNameField,"wrap");
		projectNameField.getDocument().addDocumentListener(this);

		leaderLabel = new JLabel("Projektleiter:");
		leaderField = new JTextField(25);
		fp.add(leaderLabel,"wrap");
		fp.add(leaderField,"wrap");
		leaderField.getDocument().addDocumentListener(this);

		townNameLabel = new JLabel ("Projektort:");
		townNameField = new JTextField(25);
		fp.add(townNameLabel,"wrap");
		fp.add(townNameField,"wrap");
		townNameField.getDocument().addDocumentListener(this);

		startDateLabel = new JLabel ("Start Datum:");
		startDateField = new JTextField(25);
		fp.add(startDateLabel,"wrap");
		fp.add(startDateField,"wrap");
		startDateField.getDocument().addDocumentListener(this);

		endDateLabel = new JLabel ("End Datum:");
		endDateField = new JTextField(25);
		fp.add(endDateLabel,"wrap");
		fp.add(endDateField,"wrap");
		endDateField.getDocument().addDocumentListener(this);

		costLabel = new JLabel ("Kosten:");
		costField = new JTextField(25);
		fp.add(costLabel,"wrap");
		fp.add(costField,"wrap");
		costField.getDocument().addDocumentListener(this);

		return fp;	
	}

	/**
	 * Setzt die werte eines Projekts in die einzelnen Textfelder ein
	 * @param projectName Name des Projektes
	 * @param leader Name des Verantwortlichen Projektleiters
	 * @param townName des Ortes wo das Projekt umngesetzt wird
	 * @param startDate Start Termin des Projekt
	 * @param endDate End Termin des Projekts
	 * @param cost Kosten des Gesamt Projektes
	 */
	public void setValues(String projectName, String leader, String townName,
			String startDate, String endDate,String cost)	{
		projectNameField.setText(projectName);
		leaderField.setText(leader);
		townNameField.setText(townName);
		startDateField.setText(startDate);
		endDateField.setText(endDate);
		costField.setText(cost);

		setEnableButtons(false);

	}

	//Folgenden drei Methoden setzten der wert von EnableButtons auf True falls eine 
	//veränderung stattgefunden hat.

	@Override
	public void insertUpdate(DocumentEvent e) {
		setEnableButtons(true);

	}
	@Override
	public void removeUpdate(DocumentEvent e) {
		setEnableButtons(true);

	}
	@Override
	public void changedUpdate(DocumentEvent e) {
		setEnableButtons(true);

	}

	//Alle Setter und Getter der Klasse
	public JTextField getStartDateField() {
		return startDateField;
	}

	public JTextField getEndDateField() {
		return endDateField;
	}

	public JTextField getProjectNameField() {
		return projectNameField;
	}

	public JTextField getLeaderField() {
		return leaderField;
	}

	public JTextField getTownNameField() {
		return townNameField;
	}

	public JTextField getCostField() {
		return costField;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public JButton getBtnRemove() {
		return btnRemove;
	}
}
