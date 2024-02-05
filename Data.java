import java.util.*;
import java.io.*;
import java.util.ArrayList;

class Data {
    public static void main(String[] args) {
        ArrayList<Report> allReports = readData();

        /*for (int i =0; i < allReports.size(); i++) {
            System.out.println(allReports.get(i));
        }*/

        ArrayList<Report> sixHundred = districtSearch(600, allReports);
        for (int i =0; i < sixHundred.size(); i++) {
            System.out.println(sixHundred.get(i));
        }

    }

    public static ArrayList<Report> readData() {
        try {
            ArrayList<Report> everyReport = new ArrayList<Report>();
            String fileName = "ppd_complaints.csv";
            Scanner reports = new Scanner(new File(fileName));

            reports.nextLine();
            int i = 0;

            while (reports.hasNextLine()) {
                String information = reports.nextLine();
                Report currentReport = parseData(information);
                everyReport.add(i, currentReport);
                //System.out.println(currentReport);
            }
            return everyReport;
        } catch (FileNotFoundException e) { 
            System.out.print("Could not find file");
            System.exit(1);
        }
        return null;
    }

    public static Report parseData(String information) {
        //System.out.println(information);
        String[] boxes = information.split(",");
        String complaintID = boxes[0];
        int year = 0;
        if (boxes[2].equals("") != true) {
           year = Integer.parseInt(boxes[1].substring(0, 4));
           //System.out.println("year " + year);
        } 
        
        String date = boxes[1];
        int district = 0;
        if (boxes[2].equals("") != true) {
            district = Integer.parseInt(boxes[2]);
        } 
        
        String classification = boxes[3];
        String summary = boxes[4];
        Report newReport = new Report(complaintID, year, date, district, classification, summary);
        return newReport;
        
    }

    public static ArrayList<Report> yearSearch(int year, ArrayList<Report> allYears) {
        ArrayList<Report> fromYear = new ArrayList<Report>();
        int numReports = 0;
        for (int i = 0; i < allYears.size(); i++) {
            Report currentReport = allYears.get(i);
            //System.out.println( currentReport.getYear() + " " + year + " !" + (currentReport.getYear() == year));
            if (currentReport.getYear() == year) {
                fromYear.add(numReports, currentReport);
                numReports++;
            }
        }

        return fromYear;
    }

    public static ArrayList<Report> districtSearch(int district, ArrayList<Report> allYears) {
        ArrayList<Report> fromDistrict = new ArrayList<Report>();
        int numReports = 0;
        for (int i = 0; i < allYears.size(); i++) {
            Report currentReport = allYears.get(i);
            if (currentReport.getDistrict() == district) {
                fromDistrict.add(numReports, currentReport);
                numReports++;
            }
        }
        return fromDistrict;
    }
}