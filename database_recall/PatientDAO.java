import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDAO {
    private Connection conn;

    public PatientDAO() {
        conn = DatabaseConnection.getConnection();
    }

    public void createPatient(Patient patient) {
        String insertQuery = "INSERT INTO patient (patientName, medicalHistory) VALUES (?, ?)";

        try {
            PreparedStatement pst = conn.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, patient.getPatientName());
            pst.setString(2, patient.getMedicalHistory());
            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                patient.setPatientID(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Patient getPatientByID(int patientID) throws RecordNotFoundException {
        Patient patient = new Patient();

        String retrieveQuery = "SELECT * FROM patient WHERE patientID = ?";

        try {
            PreparedStatement pst = conn.prepareStatement(retrieveQuery);
            pst.setInt(1, patientID);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                patient.setPatientID(rs.getInt("patientID"));
                patient.setPatientName(rs.getString("patientName"));
                patient.setMedicalHistory(rs.getString("medicalHistory"));
            } else {
                throw new RecordNotFoundException("Patient with ID " + patientID + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patient;
    }

    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
