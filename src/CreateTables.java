import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {
    public static void main(String[] args) {
        try {
            // 생성된 데이터베이스에 연결합니다.
            String URL = "jdbc:mysql://127.0.0.1:3306/testDatabase";
            String user = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(URL, user, password);

            Statement stmt = conn.createStatement();

            // Board 테이블 생성
            String sqlCreateBoard = "CREATE TABLE IF NOT EXISTS Board (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "title VARCHAR(255) NOT NULL, " +
                    "body TEXT NOT NULL)";
            stmt.executeUpdate(sqlCreateBoard);
            System.out.println("Board 테이블이 생성되었습니다.");

            // Member 테이블 생성
            String sqlCreateMember = "CREATE TABLE IF NOT EXISTS Member (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(255) NOT NULL, " +
                    "email VARCHAR(255) NOT NULL UNIQUE, " +
                    "board_id INT, " +
                    "FOREIGN KEY (board_id) REFERENCES Board(id))";
            stmt.executeUpdate(sqlCreateMember);
            System.out.println("Member 테이블이 생성되었습니다.");

            // 리소스를 정리합니다.
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
