package _24June2024;

public class MainPgm {
    public static void main(String[] args) {
        Patient pat = new Patient();
        pat.setPatientName("John Doe");
        pat.setMedicalHistory(("Sugar"));

        PatientDAO pdao = new PatientDAO();
        pdao.createPatient(pat);

        try {
            Patient patNew = pdao.getPatientByID(0);
            System.out.println(patNew.getPatientID());
            System.out.println(patNew.getPatientName());
            System.out.println(patNew.getMedicalHistory());
        } catch (ResourceNotFoundException re) {
            System.out.println(re.getMessage());
        }
    }
}
