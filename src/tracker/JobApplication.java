package tracker;

public class JobApplication {

    private int applId;
    private String companyName;
    private String jobRole;
    private String applDate;
    private ApplicationStatus status;

    public JobApplication(int applId, String companyName,
                          String jobRole, String applDate) {
        this.applId = applId;
        this.companyName = companyName;
        this.jobRole = jobRole;
        this.applDate = applDate;
        this.status = ApplicationStatus.APPLIED;
    }

    public int getApplicationId() {
        return applId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getJobRole() {
        return jobRole;
    }

    public String getApplicationDate() {
        return applDate;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public void displayApplication() {
        System.out.println("Application ID : " + applId);
        System.out.println("Company        : " + companyName);
        System.out.println("Role           : " + jobRole);
        System.out.println("Date Applied   : " + applDate);
        System.out.println("Status         : " + status);
    }
}