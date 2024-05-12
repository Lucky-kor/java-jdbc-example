import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsetIntoExample {
    public static void main(String[] args) {
        try {
            // 데이터베이스에 연결합니다.
            String URL = "jdbc:mysql://127.0.0.1:3306/testDatabase";
            String user = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(URL, user, password);

            Statement stmt = conn.createStatement();


            // Board 테이블에 데이터 추가
            String sqlInsertBoard = "INSERT INTO Board (title, body) VALUES " +
                    "('Java 프로그래밍', 'Java 프로그래밍에 대한 기초 설명'), " +
                    "('데이터베이스 기초', 'SQL 및 데이터베이스 관리에 대한 입문서')";
            int boardRows = stmt.executeUpdate(sqlInsertBoard);
            System.out.println(boardRows + " 개의 글이 Board 테이블에 추가되었습니다.");

            // Member 테이블에 데이터 추가
            String sqlInsertMember = "INSERT INTO Member (name, email, board_id) VALUES " +
                    "('김철수', 'chulsoo@example.com', 1), " +
                    "('이영희', 'younghee@example.com', 2)";
            int memberRows = stmt.executeUpdate(sqlInsertMember);
            System.out.println(memberRows + " 명의 회원이 Member 테이블에 추가되었습니다.");

            // 리소스를 정리합니다.
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
