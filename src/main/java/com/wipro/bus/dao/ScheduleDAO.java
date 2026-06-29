package com.wipro.bus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.wipro.bus.bean.ScheduleBean;
import com.wipro.bus.util.DBUtil;

public class ScheduleDAO {

public String createSchedule(ScheduleBean scheduleBean) {
	boolean flag=false;
	String out="";
	try {
		Connection con=DBUtil.getDBConnection();
		PreparedStatement ps=con.prepareStatement("INSERT INTO SCHEDULE_TBL VALUES (?,?,?,?,?)");
		ps.setString(1,scheduleBean.getScheduleId());
		ps.setString(2,scheduleBean.getSource());
		ps.setString(3, scheduleBean.getDestination());
		ps.setString(4, scheduleBean.getStartTime());
		ps.setString(5,scheduleBean.getArrivalTime());
		int rows=ps.executeUpdate();
		if(rows>0)
			flag=true;
		if(flag)
			out="SUCCESS";
		con.commit();
		ps.close();
		con.close();
			
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return out;
 	}

public String generateID(String source,String destination) {
	String src=source.substring(0, 2).toUpperCase();
	String des=destination.substring(0, 2).toUpperCase();
	int seq=0;
	try {
		Connection con=DBUtil.getDBConnection();
		PreparedStatement ps=con.prepareStatement("SELECT SCHEDULE_SEQ.NEXTVAL FROM DUAL");
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			seq=rs.getInt(1);
		}
		rs.close();
		ps.close();
		con.close();
		}
	catch(Exception e) {
		e.printStackTrace();
	}
	return src+des+seq;
}

public ArrayList<ScheduleBean>viewSchedule(String source,String destination){
	ArrayList<ScheduleBean>list=new ArrayList<>();
	try {
		Connection con=DBUtil.getDBConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM SCHEDULE_TBL WHERE SOURCE=? AND DESTINATION=?");
		ps.setString(1,source);
		ps.setString(2, destination);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			ScheduleBean sch=new ScheduleBean();
			sch.setScheduleId(rs.getString(1));
			sch.setSource(rs.getString(2));
			sch.setDestination(rs.getString(3));
			sch.setStartTime(rs.getString(4));
			sch.setArrivalTime(rs.getString(5));
			list.add(sch);
		}
		rs.close();
		ps.close();
		con.close();		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return list;
}
}
