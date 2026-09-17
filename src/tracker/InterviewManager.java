package tracker;

import java.util.ArrayList;

public class InterviewManager {

    private ArrayList<Interview> interviews;

    public InterviewManager() {
        interviews = new ArrayList<>();
    }

    public void addInterview(Interview interview) {
        interviews.add(interview);
        System.out.println("Interview Added Successfully.");
    }

    public void viewInterviews() {

        if (interviews.isEmpty()) {
            System.out.println("No Interviews Found.");
            return;
        }

        for (Interview i : interviews) {
            System.out.println("----------------------------");
            i.displayInterview();
        }
    }

    public Interview searchInterview(int applicationId) {

        for (Interview i : interviews) {

            if (i.getApplId() == applicationId) {
                return i;
            }
        }

        return null;
    }

    public ArrayList<Interview> getInterviews() {
        return interviews;
    }
}
