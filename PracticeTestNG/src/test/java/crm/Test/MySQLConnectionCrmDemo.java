package crm.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnectionCrmDemo {

    private static final String URL = "jdbc:mysql://10.1.106.143:3306/ramfin";
    private static final String USERNAME = "update_staging";
    private static final String PASSWORD = "Update@12789";

    public String getOtpFromDB(String userName) {
        String otp = null;

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open connection
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Create statement and execute query
            Statement stmt = conn.createStatement();
            String query = "SELECT u.otp FROM users AS u WHERE u.userName = '" + userName + "'";
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                otp = rs.getString("otp");
                System.out.println("✅ Fetched OTP from DB: " + otp);
            } else {
                System.out.println("❌ No OTP found for userName: " + userName);
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return otp;
    }
}
