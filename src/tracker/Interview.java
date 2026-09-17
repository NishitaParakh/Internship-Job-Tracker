package tracker;

public class Interview {

    private int applId;
    private String interviewDate;
    private String interviewTime;
    private String interviewType;
    private String interviewStatus;
    private String notes;

    public Interview(int applId, String interviewDate,
                     String interviewTime, String interviewType) {

        this.applId = applId;
        this.interviewDate = interviewDate;
        this.interviewTime = interviewTime;
        this.interviewType = interviewType;
        this.interviewStatus = "Scheduled";
        this.notes = "No notes";
    }

    public int getApplId() {
        return applId;
    }

    public String getInterviewDate() {
        return interviewDate;
    }

    public String getInterviewTime() {
        return interviewTime;
    }

    public String getInterviewType() {
        return interviewType;
    }

    public String getInterviewStatus() {
        return interviewStatus;
    }

    public String getNotes() {
        return notes;
    }

    public void setInterviewStatus(String interviewStatus) {
        this.interviewStatus = interviewStatus;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void displayInterview() {

        System.out.println("Application ID : " + applId);
        System.out.println("Interview Date : " + interviewDate);
        System.out.println("Interview Time : " + interviewTime);
        System.out.println("Interview Type : " + interviewType);
        System.out.println("Interview Status: " + interviewStatus);
        System.out.println("Notes          : " + notes);
    }
}
