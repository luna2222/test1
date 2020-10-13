package common;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCTemplate {
	public JDBCTemplate() {	}
	public static Connection getConnection() {
		Connection conn = null ;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
//			if(conn == null) {
//				System.out.println("JDBC 실패 !!!!");
			
//				}catch(SQLException e) {
//				e.printStackTrace();
//			}catch(ClassNotFoundException e) {
//				e.printStackTrace();
			}catch(Exception e) {
				System.out.println("!!!실패!!!");
				e.printStackTrace();
			}
				return conn;				
			}
			
	 public List<EmpVo> getEmps() {
		    List<EmpVo> list = new ArrayList<EmpVo>();
		    Connection conn = getConnection();
		    String sql ="select * from emp";
			String sql1 ="";
			String sql2 ="";
			Statement stmt = null;
			PreparedStatement pstmt = null;
			int reInt = 0;
			ResultSet rs = null;
			String minValue= "2000";
			try {
			
	       //sql문을 실행하기 위한 2가지 statement 
	        //1. Statement
		   sql1= sql+" where sal > 2000";
	       stmt = conn.createStatement();
	       
	       //2. PreparedStatement
	       sql2= sql+" where sal > ?";// ?를 사용
	       pstmt = conn.prepareStatement(sql2);
	         
	        //sql문을 실행 결과 2가지 
	        //1. int형 insert/update/delete 1~ 정상 작동, 0 또는 음수인 경루 비정상동작
	        //2. ResultSel형  select 문의 결과 로 행열이 존재함
	      
	       
	       System.out.println("****************** Statement 결과");
	       rs = stmt.executeQuery(sql);
	       if(rs.next()) {
	    	   do {
	    		    EmpVo vo = new EmpVo();
					vo.setEmpno(rs.getInt(1));
					vo.setEname(rs.getString("Ename"));
					vo.setJob(rs.getString("Job"));
					System.out.println("empno : "+rs.getInt(1) // 1번째colume의 데이터를 int형으로 꺼내옴
					+"eName : "+rs.getString(2)               // 2번째colume의 데이터를 String형으로 꺼내옴
					+"eJob : "+rs.getString("job"));          // 3번째colume label의 이용해 데이터를 String형으로 꺼내옴	   
	    	   
	    		list.add(vo);
	    	   }while(rs.next());
	       }else {
	    	   System.out.println("찾는 데이터가 없습니다");
	       }
	       //PrepareStatement
			System.out.println("****************** PrepareStatement 결과");
			
			pstmt.setString(1, minValue);   // set String 또는 set Int (? 의 순서대로1~n, 값)
	        rs= pstmt.executeQuery(); 
	        if(rs.next()) {
				do {
					System.out.println(
							"empno: " + rs.getInt(1)   // 1번째 colume의 데이터를 int형태로 꺼내올거다.
							+ "eName: " + rs.getString(2) // 2번쨰 colume의 데이터를 String 형태로 꺼내올거임.
							+ "eJob: " + rs.getString("job") // colume label을 이용해 데이터를 String 형태로 꺼내올거임.
					);
				}while(rs.next());
			} else {
				System.out.println("찾는 데이터가 없습니다.");
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return list;
	}
	 public List<EmpVo> searchEmps() {
		    List<EmpVo> list = new ArrayList<EmpVo>();
		    Connection conn = getConnection();
		    String sql ="select * from emp";
			String sql1 ="";
			String sql2 ="";
			Statement stmt = null;
			PreparedStatement pstmt = null;
			int reInt = 0;
			ResultSet rs = null;
			String minValue= "2000";
			try {
			
	       //sql문을 실행하기 위한 2가지 statement 
	        //1. Statement
		   sql1= sql+" where sal > 2000";
	       stmt = conn.createStatement();
	       
	       //2. PreparedStatement
	       sql2= sql+" where sal > ?";// ?를 사용
	       pstmt = conn.prepareStatement(sql2);
	                
	       System.out.println("======================= Statement 결과");
	       rs = stmt.executeQuery(sql);
	       if(rs.next()) {
	    	   do {
	    		    EmpVo vo = new EmpVo();
					vo.setEmpno(rs.getInt(1));
					vo.setEname(rs.getString("Ename"));
					vo.setJob(rs.getString("Job"));
					System.out.println("empno : "+rs.getInt(1) // 1번째colume의 데이터를 int형으로 꺼내옴
					+"eName : "+rs.getString(2)               // 2번째colume의 데이터를 String형으로 꺼내옴
					+"eJob : "+rs.getString("job"));          // 3번째colume label의 이용해 데이터를 String형으로 꺼내옴	   
	    	   
	    		list.add(vo);
	    	   }while(rs.next());
	       }else {
	    	   System.out.println("찾는 데이터가 없습니다");
	       }
	       //PrepareStatement
			System.out.println("======================= PrepareStatement 결과");
			
			pstmt.setString(1, minValue);   // set String 또는 set Int (? 의 순서대로1~n, 값)
	        rs= pstmt.executeQuery(); 
	        if(rs.next()) {
				do {
					System.out.println(
							"empno: " + rs.getInt(1)   // 1번째 colume의 데이터를 int형태로 꺼내올거다.
							+ "eName: " + rs.getString(2) // 2번쨰 colume의 데이터를 String 형태로 꺼내올거임.
							+ "eJob: " + rs.getString("job") // colume label을 이용해 데이터를 String 형태로 꺼내올거임.
					);
				}while(rs.next());
			} else {
				System.out.println("찾는 데이터가 없습니다.");
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return list;
	} 	
//	public static void main(String[] args) {
//		Connection conn = getConnection();
//		if(conn!= null) {
//			System.out.println("JDBC 연결 성공");
//		}else {
//			System.out.println("실패!!!!");
//	     }
//	}
}
