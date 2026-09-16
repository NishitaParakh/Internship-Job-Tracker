package tracker;

public class Interview {

    private int applId;
    private String interviewDate;
    private String interviewTime;
    private String interviewType;

    public Interview(int applId, String interviewDate,
                     String interviewTime, String interviewType) {
        this.applId = applId;
        this.interviewDate = interviewDate;
        this.interviewTime = interviewTime;
        this.interviewType = interviewType;
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

    public void displayInterview() {
        System.out.println("Application ID : " + applId);
        System.out.println("Interview Date : " + interviewDate);
        System.out.println("Interview Time : " + interviewTime);
        System.out.println("Interview Type : " + interviewType);
    }
}
