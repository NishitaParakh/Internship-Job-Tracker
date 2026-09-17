package tracker;

public class InputValidator{
    public boolean isValidID(int id){
        return id > 0;
    }

    public boolean isValidText(String s){
        return s != null && !s.trim().isEmpty();
    }

    public boolean isValidPriority(String priority){
        if (priority == null){
            return false;
        }

        return priority.equalsIgnoreCase("Low")
               || priority.equalsIgnoreCase("Medium") 
               || priority.equalsIgnoreCase("High");
    }

    public boolean isValidStats(String stats){
        if (stats == null){
            return false;
        }

        try {
            ApplicationStatus.valueOf(stats.toUpperCase());
            return true;
        } catch(IllegalArgumentException e){
            return false;
        }
    }
}
