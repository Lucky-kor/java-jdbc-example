import java.sql.*;

public class RUDExample {
    public static void main(String[] args) {
        try {
            // 데이터베이스에 연결합니다.
            String URL = "jdbc:mysql://127.0.0.1:3306/testDatabase";
            String user = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(URL, user, password);

            Statement stmt = conn.createStatement();

            // Board 테이블에서 모든 데이터 조회
            String sqlSelectBoard = "SELECT * FROM Board";
            ResultSet rsBoard = stmt.executeQuery(sqlSelectBoard);
            while (rsBoard.next()) {
                System.out.println("ID: " + rsBoard.getInt("id") + ", 제목: " + rsBoard.getString("title") + ", 내용: " + rsBoard.getString("body"));
            }

            // Member 테이블에서 회원 삭제
            String sqlDeleteMember = "DELETE FROM Member WHERE name = '김철수'";
            int deletedRows = stmt.executeUpdate(sqlDeleteMember);
            System.out.println(deletedRows + " 명의 회원이 삭제되었습니다.");

            // Board 테이블의 제목 업데이트
            String sqlUpdateBoard = "UPDATE Board SET title = '자바 프로그래밍 업데이트' WHERE id = 1";
            int updatedRows = stmt.executeUpdate(sqlUpdateBoard);
            System.out.println(updatedRows + " 개의 글 제목이 업데이트되었습니다.");

            // 리소스를 정리합니다.
            rsBoard.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
