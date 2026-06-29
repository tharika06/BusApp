<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.wipro.bus.bean.ScheduleBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display</title>
</head>
<body>
<%
List<ScheduleBean>list=(List<ScheduleBean>)request.getAttribute("scheduleList");
if(list==null||list.isEmpty())
{
%>
<h1>No matching schedules exists! Please try again!</h1>
<%
}
else
{
%>
<table border="1">
<tr>
<th>Schedule Id</th>
<th>Source</th>
<th>Destination</th>
<th>Start Time</th>
<th>Arrival Time</th>
</tr>
<%
for(ScheduleBean bean:list)
{
%>
<tr>
<td><%=bean.getScheduleId()%></td>
<td><%=bean.getSource()%></td>
<td><%=bean.getDestination()%></td>
<td><%=bean.getStartTime()%></td>
<td><%=bean.getArrivalTime()%></td>
</tr>
<%
}
%>
</table>
<%
}
%>
</body>
</html>