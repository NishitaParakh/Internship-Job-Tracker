package tracker;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String APPL_FILE = "data/applications.txt";
    private static final String INTERVIEW_FILE = "data/interviews.txt";

    public void saveAppl(ArrayList<JobApplication> appl) {

        try {
            FileWriter writer = new FileWriter(APPL_FILE);

            for (JobApplication a : appl) {
                writer.write(
                    a.getApplId() + "|" +
                    a.getCompanyName() + "|" +
                    a.getJobRole() + "|" +
                    a.getApplDate() + "|" +
                    a.getStatus() + "|" +
                    a.getPriority() + "\n"
                );
            }

            writer.close();
            System.out.println("Applications Saved Successfully.");

        } catch (IOException e) {
            System.out.println("ERROR in Saving Applications.");
        }
    }

    public ArrayList<JobApplication> loadAppl() {

        ArrayList<JobApplication> appl = new ArrayList<>();

        try {
            File file = new File(APPL_FILE);

            if (!file.exists()) {
                return appl;
            }

            BufferedReader reader = new BufferedReader(
                    new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                if (data.length == 6) {

                    int id = Integer.parseInt(data[0]);

                    JobApplication a = new JobApplication(
                            id,
                            data[1],
                            data[2],
                            data[3],
                            data[5]
                    );

                    a.setStatus(
                            ApplicationStatus.valueOf(data[4])
                    );

                    appl.add(a);
                }
            }

            reader.close();

        } catch (IOException | NumberFormatException e) {
            System.out.println("ERROR in Loading Applications.");
        }

        return appl;
    }

    public void saveInterviews(ArrayList<Interview> interviews) {

        try {
            FileWriter writer = new FileWriter(INTERVIEW_FILE);

            for (Interview i : interviews) {
                writer.write(
                    i.getApplId() + "|" +
                    i.getInterviewDate() + "|" +
                    i.getInterviewTime() + "|" +
                    i.getInterviewType() + "\n"
                );
            }

            writer.close();
            System.out.println("Interviews Saved Successfully.");

        } catch (IOException e) {
            System.out.println("ERROR in Saving Interviews.");
        }
    }

    public ArrayList<Interview> loadInterviews() {

        ArrayList<Interview> interviews = new ArrayList<>();

        try {
            File file = new File(INTERVIEW_FILE);

            if (!file.exists()) {
                return interviews;
            }

            BufferedReader reader = new BufferedReader(
                    new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                if (data.length == 4) {

                    int applId = Integer.parseInt(data[0]);

                    Interview interview = new Interview(
                            applId,
                            data[1],
                            data[2],
                            data[3]
                    );

                    interviews.add(interview);
                }
            }

            reader.close();

        } catch (IOException | NumberFormatException e) {
            System.out.println("ERROR in Loading Interviews.");
        }

        return interviews;
    }
}
