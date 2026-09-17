package tracker;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ApplicationManager applManager = new ApplicationManager();
        InterviewManager interviewManager = new InterviewManager();
        Statistics statistics = new Statistics(applManager);
        FileManager fileManager = new FileManager();
        InputValidator validator = new InputValidator();

        boolean isRunning = true;

        while (isRunning) {

            showMenu();

            System.out.print("  Enter your choice: ");
            String choice = sc.nextLine();

            System.out.println();

            switch (choice) {

                case "1":
                    addAppl(sc, applManager, validator);
                    pause(sc);
                    break;

                case "2":
                    showSection("MY APPLICATIONS");
                    applManager.viewAppl();
                    pause(sc);
                    break;

                case "3":
                    searchAppl(sc, applManager);
                    pause(sc);
                    break;

                case "4":
                    updateStatus(sc, applManager, validator);
                    pause(sc);
                    break;

                case "5":
                    deleteAppl(sc, applManager);
                    pause(sc);
                    break;

                case "6":
                    addInterview(sc, interviewManager, validator);
                    pause(sc);
                    break;

                case "7":
                    showSection("MY INTERVIEWS");
                    interviewManager.viewInterviews();
                    pause(sc);
                    break;

                case "8":
                    showSection("APPLICATION STATISTICS");
                    statistics.showDashboard();
                    pause(sc);
                    break;

                case "9":
                    showSection("SAVING DATA");

                    fileManager.saveAppl(
                            applManager.getApplications());

                    fileManager.saveInterviews(
                            interviewManager.getInterviews());
                    
                    pause(sc);
                    break;

                case "10":

                    showSection("LOADING DATA");

                    ArrayList<JobApplication> loadedAppl =
                            fileManager.loadAppl();

                    ArrayList<Interview> loadedInterviews =
                            fileManager.loadInterviews();

                    applManager.getApplications().clear();
                    applManager.getApplications()
                            .addAll(loadedAppl);

                    interviewManager.getInterviews().clear();
                    interviewManager.getInterviews()
                            .addAll(loadedInterviews);

                    System.out.println("  ✓ Data Loaded Successfully.");
                    pause(sc);
                    break;

                case "11":

                    System.out.println();
                    System.out.println(
                            "╔══════════════════════════════════════════╗");
                    System.out.println(
                            "║     Thank You for using Job Tracker!    ║");
                    System.out.println(
                            "╚══════════════════════════════════════════╝");

                    isRunning = false;
                    break;

                default:

                    System.out.println(
                            "  [!] Invalid Choice. Please Try Again!");
            }
        }

        sc.close();
    }


    // ================= MENU =================

    private static void showMenu() {

        System.out.println();
        System.out.println(
                "╔══════════════════════════════════════════╗");
        System.out.println(
                "║        INTERNSHIP & JOB TRACKER          ║");
        System.out.println(
                "╠══════════════════════════════════════════╣");
        System.out.println(
                "║                                          ║");
        System.out.println(
                "║   APPLICATION MANAGEMENT                 ║");
        System.out.println(
                "║   [1] Add Application                    ║");
        System.out.println(
                "║   [2] View Applications                  ║");
        System.out.println(
                "║   [3] Search Application                 ║");
        System.out.println(
                "║   [4] Update Application Status          ║");
        System.out.println(
                "║   [5] Delete Application                 ║");
        System.out.println(
                "║                                          ║");
        System.out.println(
                "║   INTERVIEW MANAGEMENT                   ║");
        System.out.println(
                "║   [6] Add Interview                      ║");
        System.out.println(
                "║   [7] View Interviews                    ║");
        System.out.println(
                "║                                          ║");
        System.out.println(
                "║   REPORTS & DATA                         ║");
        System.out.println(
                "║   [8] View Statistics                    ║");
        System.out.println(
                "║   [9] Save Data                          ║");
        System.out.println(
                "║   [10] Load Data                         ║");
        System.out.println(
                "║                                          ║");
        System.out.println(
                "║   [11] Exit                              ║");
        System.out.println(
                "║                                          ║");
        System.out.println(
                "╚══════════════════════════════════════════╝");
    }


    // ================= SECTION HEADER =================

    private static void showSection(String title) {

        System.out.println();
        System.out.println(
                "╔══════════════════════════════════════════╗");
        System.out.printf(
                "║ %-40s ║%n", title);
        System.out.println(
                "╚══════════════════════════════════════════╝");
    }


    // ================= ADD APPLICATION =================

    private static void addAppl(
            Scanner sc,
            ApplicationManager manager,
            InputValidator validator) {

        showSection("ADD NEW APPLICATION");

        System.out.print("  Application ID     : ");
        int id = Integer.parseInt(sc.nextLine());

        if (!validator.isValidId(id)) {
            System.out.println("  [!] Invalid ID!");
            return;
        }

        System.out.print("  Company Name       : ");
        String company = sc.nextLine();

        if (!validator.isValidText(company)) {
            System.out.println(
                    "  [!] Company Name can't be Empty.");
            return;
        }

        System.out.print("  Job Role           : ");
        String role = sc.nextLine();

        if (!validator.isValidText(role)) {
            System.out.println(
                    "  [!] Job Role can't be Empty.");
            return;
        }

        System.out.print("  Application Date   : ");
        String date = sc.nextLine();

        System.out.print(
                "  Priority (Low/Medium/High) : ");
        String priority = sc.nextLine();

        if (!validator.isValidPriority(priority)) {
            System.out.println("  [!] Invalid Priority!");
            return;
        }

        JobApplication a =
                new JobApplication(
                        id,
                        company,
                        role,
                        date,
                        priority);

        manager.addAppl(a);

        System.out.println();
        System.out.println(
                "  Application Added Successfully.");
    }


    // ================= SEARCH APPLICATION =================

    private static void searchAppl(
            Scanner sc,
            ApplicationManager manager) {

        showSection("SEARCH APPLICATION");

        System.out.print(
                "  Enter Application ID : ");

        int id = Integer.parseInt(sc.nextLine());

        JobApplication application =
                manager.searchAppl(id);

        if (application != null) {

            System.out.println();
            System.out.println(
                    "  Application Found");
            System.out.println(
                    "  --------------------------------");

            application.displayAppl();

        } else {

            System.out.println();
            System.out.println(
                    "  [!] Application NOT FOUND!");
        }
    }


    // ================= UPDATE STATUS =================

    private static void updateStatus(
            Scanner sc,
            ApplicationManager manager,
            InputValidator validator) {

        showSection("UPDATE APPLICATION STATUS");

        System.out.print(
                "  Enter Application ID : ");

        int id = Integer.parseInt(sc.nextLine());

        System.out.println();
        System.out.println("  Available Statuses");
        System.out.println("  ------------------");
        System.out.println("  [1] APPLIED");
        System.out.println("  [2] SHORTLISTED");
        System.out.println("  [3] INTERVIEW");
        System.out.println("  [4] SELECTED");
        System.out.println("  [5] REJECTED");

        System.out.print(
                "\n  Enter New Status : ");

        String status = sc.nextLine();

        if (!validator.isValidStats(status)) {
            System.out.println(
                    "  [!] Invalid Status!");
            return;
        }

        ApplicationStatus newStatus =
                ApplicationStatus.valueOf(
                        status.toUpperCase());

        if (manager.updateStatus(id, newStatus)) {

            System.out.println();
            System.out.println(
                    "  Status Updated Successfully.");

        } else {

            System.out.println();
            System.out.println(
                    "  [!] Application NOT FOUND!");
        }
    }


    // ================= DELETE APPLICATION =================

    private static void deleteAppl(
            Scanner sc,
            ApplicationManager manager) {

        showSection("DELETE APPLICATION");

        System.out.print(
                "  Enter Application ID : ");

        int id = Integer.parseInt(sc.nextLine());

        if (manager.deleteAppl(id)) {

            System.out.println();
            System.out.println(
                    "  Application Deleted Successfully.");

        } else {

            System.out.println();
            System.out.println(
                    "  [!] Application NOT FOUND!");
        }
    }


    // ================= ADD INTERVIEW =================

    private static void addInterview(
            Scanner sc,
            InterviewManager manager,
            InputValidator validator) {

        showSection("ADD INTERVIEW");

        System.out.print(
                "  Application ID     : ");

        int applicationId =
                Integer.parseInt(sc.nextLine());

        if (!validator.isValidId(applicationId)) {
            System.out.println(
                    "  [!] Invalid Application ID.");
            return;
        }

        System.out.print(
                "  Interview Date     : ");

        String date = sc.nextLine();

        System.out.print(
                "  Interview Time     : ");

        String time = sc.nextLine();

        System.out.print(
                "  Interview Type     : ");

        String type = sc.nextLine();

        if (!validator.isValidText(type)) {

            System.out.println(
                    "  [!] Interview Type can't be Empty.");
            return;
        }

        Interview interview =
                new Interview(
                        applicationId,
                        date,
                        time,
                        type);

        manager.addInterview(interview);

        System.out.println();
        System.out.println(
                " Interview Added Successfully.");
    }

    private static void pause(Scanner sc) {

    System.out.println();
    System.out.print("  Press Enter to return to the main menu...");
    sc.nextLine();
    }
}