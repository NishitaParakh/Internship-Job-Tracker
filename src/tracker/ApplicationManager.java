package tracker;

import java.util.ArrayList;

public class ApplicationManager {
    private ArrayList<JobApplication> appl;

    public ApplicationManager() {
        appl = new ArrayList<>();
    }

    public void addAppl(JobApplication application){
        appl.add(application);
        System.out.println("Application Added Successfully.");
    }

    public void viewAppl(){
        if (appl.isEmpty()){
            System.out.println("No Applications Found.");
            return;
        }

        for (JobApplication application : appl){
            System.out.println("----------------------------");
            application.displayAppl();
        }
    }

    public JobApplication searchAppl(int id){
        for (JobApplication a : appl){
            if (a.getApplId() == id){
                return a;
            }
        }
        return null;
    }

    public boolean updateStatus(int id, ApplicationStatus newStatus){
        JobApplication a = searchAppl(id);
        if (a != null){
            a.setStatus(newStatus);
            return true;
        }
        return false;
    }

    public boolean deleteAppl(int id){
        JobApplication a = searchAppl(id);
        if (a != null){
            appl.remove(a);
            return true;
        }
        return false;
    }

    public ArrayList<JobApplication> getApplications(){
        return appl;
    }
}
