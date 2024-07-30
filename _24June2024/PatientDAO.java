package _24June2024;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDAO {
    Connection conn;

    PatientDAO() {
        this.conn = DatabaseConnection.getConnection(conn);
    }

    public void createPatient(Patient pat) {
        String sql = "INSERT INTO patients (patiendID, medicalHistory) VALUES (?, ?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, pat.getPatientName());
            pst.setString(2, pat.getMedicalHistory());
            pst.executeUpdate();
            
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                pat.setPatientID(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Patient getPatientByID(int patientID) throws ResourceNotFoundException {
        String sql = "SELECT * FROM patients WHERE patientID = ?";
        Patient pat = null;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, patientID);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                pat = new Patient();
                pat.setPatientID(rs.getInt("patientID"));
                pat.setPatientName(rs.getString("patientName"));
                pat.setMedicalHistory(rs.getString("medicalHistory"));
            } else {
                throw new ResourceNotFoundException("Patient with ID " + patientID + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pat;
    }
}