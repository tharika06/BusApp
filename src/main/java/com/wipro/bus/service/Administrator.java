package com.wipro.bus.service;

import java.util.ArrayList;

import com.wipro.bus.bean.ScheduleBean;
import com.wipro.bus.dao.ScheduleDAO;
import com.wipro.bus.util.InvalidInputException;

public class Administrator {

	public String addSchedule(ScheduleBean scheduleBean) {
		try {
			if(scheduleBean==null)
				throw new InvalidInputException();
			String src=scheduleBean.getSource();
			String des=scheduleBean.getDestination();
			
			if(src==null||des==null)
				throw new InvalidInputException();
			
			if(src.trim().isEmpty()||des.trim().isEmpty())
				throw new InvalidInputException();
			
			if(src.length()<2||des.length()<2)
				throw new InvalidInputException();
			
			if(src.equalsIgnoreCase(des))
				return "Source and Destination Same";
			
			ScheduleDAO dao=new ScheduleDAO();
			String id=dao.generateID(src, des);
			scheduleBean.setScheduleId(id);
			return dao.createSchedule(scheduleBean);			
		}
		catch (InvalidInputException e) {
			return e.toString();
		}
	}
	
	public ArrayList<ScheduleBean> viewSchedule(String source,String destination){
		ScheduleDAO dao=new ScheduleDAO();
		ArrayList<ScheduleBean>list=dao.viewSchedule(source, destination);
		if(list==null||list.size()==0)
			return null;
		return list;
		
	}
}
