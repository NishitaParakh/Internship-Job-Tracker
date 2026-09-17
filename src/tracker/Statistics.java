package tracker;

import java.util.ArrayList;

import javax.print.attribute.standard.JobMediaSheetsSupported;

public class Statistics{
    private ApplicationManager applManager;
    public Statistics(ApplicationManager applManager){
        this.applManager = applManager;
    }

    public void showDashboard(){
        ArrayList<JobApplication> appl = applManager.getApplications();

        int total = appl.size();
        int applied = 0;
        int shortlisted = 0;
        int interview = 0;
        int selected = 0;
        int rejected = 0;

        for (JobApplication a : appl){
            ApplicationStatus status = a.getStatus();
            if (status == ApplicationStatus.APPLIED){
                applied++;
            }
            else if (status == ApplicationStatus.SHORTLISTED){
                shortlisted++;
            }
            else if (status == ApplicationStatus.INTERVIEW){
                interview++;
            }
            else if (status == ApplicationStatus.SELECTED){
                selected++;
            }
            else if (status == ApplicationStatus.REJECTED){
                rejected++;
            }
        }

        System.out.println();
        System.out.println("========== APPLICATION DASHBOARD ==========");
        System.out.println("Total Applications : " + total);
        System.out.println("Applied            : " + applied);
        System.out.println("Shortlisted        : " + shortlisted);
        System.out.println("Interviews         : " + interview);
        System.out.println("Selected           : " + selected);
        System.out.println("Rejected           : " + rejected);

        if (total > 0){
            double selRate = (selected * 100.0) / total;
            double interviewRate = (interview * 100.0) / total;
            System.out.println("Selection Rate     : " + selRate + "%");
            System.out.println("Interview Rate     : " + interviewRate + "%");
        }
        else{
            System.out.println("Selection Rate     : 0%");
            System.out.println("Interview Rate     : 0%");
        }
        System.out.println("===========================================");
    }
}
