package model;


public class Project {
	
	private String projectName;
	private String leader;
	private String townName;
	private String startDate;
	private String endDate;
	private String cost;
	//Erweitern wie gewünscht
	
	public Project (String projectName) {
		this.projectName = projectName;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public void setTownName(String townName) {
		this.townName = townName;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	
	public String getStartDate() {
		return startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public String getLeader() {
		return leader;
	}
	public String getProjectName() {
		return projectName;
	}
	public String getTownName() {
		return townName;
	}
	public String getCost() {
		return cost;
	}
	
	public String toString() {
		return projectName;
	}

}


