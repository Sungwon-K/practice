package com.sungwon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sungwon.dto.ItemVO;

public class ItemDAO {
	private ItemDAO() {}
	private static ItemDAO instance = new ItemDAO();
	public static ItemDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception{
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = null;
		conn = ds.getConnection();
		
		return conn;		
	}
	
	//정보 입력
	public void insertItem(ItemVO iVo) {
		String sql = "insert into item values(?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,iVo.getName());
			pstmt.setInt(2, iVo.getPrice());
			pstmt.setString(3, iVo.getDescription());
			pstmt.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//item목록
	public List<ItemVO> selectAllProducts() {
		
		String sql = "select * from item order by name desc";
		List<ItemVO> list = new ArrayList<ItemVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) { // 이동은 행(로우) 단위로
				ItemVO iVo = new ItemVO();
				iVo.setName(rs.getString("name"));
				iVo.setPrice(rs.getInt("price"));
				iVo.setDescription(rs.getString("description"));
				list.add(iVo);
			}// while문 끝
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
