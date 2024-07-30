public class Main {
    public static void main(String[] args) {
        PatientDAO patientDAO = new PatientDAO();

        Patient patient1 = new Patient();
        patient1.setPatientName("John Doe");
        patient1.setMedicalHistory("High Sugar");
        patientDAO.createPatient(patient1);

        try {
            Patient patNew = patientDAO.getPatientByID(patient1.getPatientID());
            System.out.println(patNew.getPatientID());
            System.out.println(patNew.getPatientName());
            System.out.println(patNew.getMedicalHistory());
        } catch (RecordNotFoundException re) {
            System.out.println(re.getMessage());
        }

        patientDAO.close();
    }
}
