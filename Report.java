public class Report {
    int year;
    String fullDate;
    int district;
    String classification;
    String summary;
    String complaintID;
    public Report(String complaintID, int year, String fullDate, int district, String classification, String summary) {
        this.district = district;
        this.classification = classification;
        this.summary = summary;
        this.complaintID = complaintID;
        this.year = year;
        this.fullDate = fullDate;
    }

    public int getDistrict() {
        return this.district;
    }
    
    public int getYear() {
        return this.year;
    }

    public String toString() {
        return this.complaintID + " " + this.district + " " + this.year; 
    }
}

