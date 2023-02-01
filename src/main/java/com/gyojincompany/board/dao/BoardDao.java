package com.gyojincompany.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BoardDao {
	
	String driverName = "com.mysql.jdbc.Driver";//해당 DB의 드라이버 이름
	String url = "jdbc:mysql://localhost:3306/webdb";//DB 주소와 DB(스키마) 이름
	String user = "root";
	String pass = "1234";
	
	public void write(String btitle, String bname, String bcontent) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql="INSERT INTO mvc_board(bname, btitle, bcontent) VALUES(?,?,?)";
		
		try {
			Class.forName(driverName);//jdbc 드라이버 불러오기
			conn = DriverManager.getConnection(url, user, pass);//DB 커넥션 생성
			pstmt = conn.prepareStatement(sql);//sql 객체 생성
			pstmt.setString(1, bname);//글쓴이
			pstmt.setString(2, btitle);//글제목
			pstmt.setString(3, bcontent);//글내용
			
			pstmt.executeUpdate();//sql 실행
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
