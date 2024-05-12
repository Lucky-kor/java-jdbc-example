import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) {
        try {
            // 데이터베이스 서버에 연결합니다.
            String URL = "jdbc:mysql://127.0.0.1:3306";
            String user = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(URL, user, password);
            Statement stmt = conn.createStatement();

            // 데이터베이스를 생성하는 SQL 명령을 실행합니다.
            String sqlCreateDB = "CREATE DATABASE IF NOT EXISTS testDatabase";
            stmt.executeUpdate(sqlCreateDB);
            System.out.println("데이터베이스가 생성되었습니다.");

            // 리소스를 정리합니다.
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
