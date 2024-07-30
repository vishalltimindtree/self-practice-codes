public class Patient {
    private String patientName;
    private String medicalHistory;
    private int patientID;
    
    public Patient() {}

    public Patient(String patientName, String medicalHistory) {
        this.patientName = patientName;
        this.medicalHistory = medicalHistory;
    }
    
    public int getPatientID() {
        return patientID;
    }
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }
    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    public String getMedicalHistory() {
        return medicalHistory;
    }
    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}
