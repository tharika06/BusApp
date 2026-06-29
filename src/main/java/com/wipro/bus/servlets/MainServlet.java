package com.wipro.bus.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.bus.bean.ScheduleBean;
import com.wipro.bus.service.Administrator;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private Administrator admin=new Administrator();
	
	public String addSchedule(HttpServletRequest request) {
			ScheduleBean scheduleBean=new ScheduleBean();
			scheduleBean.setSource(request.getParameter("source"));
			scheduleBean.setDestination(request.getParameter("destination"));
			scheduleBean.setStartTime(request.getParameter("startTime"));
			scheduleBean.setArrivalTime(request.getParameter("arrivalTime"));
			return admin.addSchedule(scheduleBean);
	}
	
	public ArrayList<ScheduleBean>viewSchedule(HttpServletRequest request){
        	return admin.viewSchedule(request.getParameter("source"),request.getParameter("destination"));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
      String operation=request.getParameter("operation");
      if(operation.equals("newSchedule")) {
    	  String result=addSchedule(request);
          if(result.equals("SUCCESS")){
    	     response.sendRedirect("success.jsp");    	  
      }
          else{
        	  response.sendRedirect("errorInserting.html");
          }
      }
      
      if(operation.equals("viewSchedule")) {
    	  ArrayList<ScheduleBean> view=viewSchedule(request);
    	  if(view==null|| view.isEmpty()) {
    		  response.sendRedirect("displaySchedule.jsp?No matching schedules exists! Please try again!");
    	  }
    	  else {
    		  request.setAttribute("scheduleList", view);
    		  request.getRequestDispatcher("displaySchedule.jsp").forward(request, response);
    	  }
    		  
      }
	}

}
