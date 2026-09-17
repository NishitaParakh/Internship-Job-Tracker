package tracker;

public class JobApplication {

    private int applId;
    private String companyName;
    private String jobRole;
    private String applDate;
    private ApplicationStatus status;
    private String priority;

    public JobApplication(int applId, String companyName,
                          String jobRole, String applDate,
                          String priority) {

        this.applId = applId;
        this.companyName = companyName;
        this.jobRole = jobRole;
        this.applDate = applDate;
        this.priority = priority;
        this.status = ApplicationStatus.APPLIED;
    }

    public int getApplId() {
        return applId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getJobRole() {
        return jobRole;
    }

    public String getApplDate() {
        return applDate;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public String getPriority() {
        return priority;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void displayAppl() {
        System.out.println("Application ID : " + applId);
        System.out.println("Company        : " + companyName);
        System.out.println("Role           : " + jobRole);
        System.out.println("Date Applied   : " + applDate);
        System.out.println("Status         : " + status);
        System.out.println("Priority       : " + priority);
    }
}