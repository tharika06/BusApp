<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add</title>
</head>
<body>
<form method="post" action="MainServlet">
<h1>Enter Schedule Details</h1>
Source:<input type="text" name="source"><br><br>
Destination:<input type="text" name="destination"><br><br>
Start Time:<input type="text" name="startTime"><br><br>
Arrival Time:<input type="text" name="arrivalTime"><br><br>
<input type="hidden" name="operation" value="newSchedule">
<button type="submit" value="create schedule">Create Schedule</button>
</form>
</body>
</html>