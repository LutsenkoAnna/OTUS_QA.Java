package data;

public enum CourseData {
  MACHINELEARNING("Machine Learning"),
  TEAMLEAD("TeamLead"),
  ADMINISTRATORLINUX("Administrator Linux"),
  QAAUTOMATIONENGINEER("QA Automation Engineer");

  private String name;

  CourseData(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
