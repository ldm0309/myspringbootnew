package lx.edu.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lx.edu.springmvc.vo.AddrBookVO;

@Component
public class AddrBookDAO {
	
	@Autowired
	SqlSession session;
	
	public int insertDB(AddrBookVO ab) throws Exception {
		return session.insert("insertDB",  ab);
	}

	public List<AddrBookVO> getDBList() throws Exception {
		return session.selectList("getDBList");		
	}

	    // 수정 (에딧과제)
		public AddrBookVO getDB(int abId) throws Exception {
			return session.selectOne("getDB", abId);
		}

		// 수정 (에딧과제)
		public int updateDB(AddrBookVO ab) throws Exception {
			return session.update("updateDB", ab);
		}
		
	public AddrBookVO deleteDB(int abId) throws Exception {
		AddrBookVO vo = new AddrBookVO();
		Connection con = getConnection();
		String sql = "delete from addrbook where ab_id = ?";
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setInt(1, abId);
		psmt.executeUpdate();
		con.close();
		return vo;
	}
	private static Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource dataSource = (DataSource) envContext.lookup("jdbc/mydb");
		Connection connection = dataSource.getConnection();
		return connection;
	}
	
}
