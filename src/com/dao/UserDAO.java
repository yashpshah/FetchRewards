package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.UserBean;
import com.util.UserUtil;

public class UserDAO {
	public static void doInsert(UserBean user){
		try {
			Connection conn=UserUtil.createConnection();
			String s1="insert into userAccount(name,points)values(?,?)";
			PreparedStatement ps=conn.prepareStatement(s1); 
			ps.setString(1, user.getName());
			ps.setString(2, String.valueOf(user.getPoints()));
			//ps.setString(3, s.getEmail());
			ps.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
	}
	public static List<UserBean> getAllStudents(){
		List<UserBean> list= new ArrayList<>();
		try {
			Connection conn=UserUtil.createConnection();
			String sql="select * from userAccount";
			PreparedStatement pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				UserBean user=new UserBean();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPoints(rs.getInt("points"));
				//s.setContact(rs.getString("contact"));
				list.add(user);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	return list;	
	}
	public static UserBean getStudentById(int id){
		UserBean user=null;
		try {
			Connection conn=UserUtil.createConnection();
			String sql="select * from userAccount where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				user=new UserBean();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPoints(rs.getInt("points"));
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
	return user;
	}
	public static void updateStudent(UserBean user) {
		
		try {
			Connection conn=UserUtil.createConnection();
			String sql="update userAccount set name=?,points=? where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, String.valueOf(user.getPoints()));
			pst.setInt(3, user.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
