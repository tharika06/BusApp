<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view</title>
</head>
<body>
<form method="post" action="MainServlet">
Enter source:<input type="text" name="source"><br><br>
Enter destination:<input type="text" name="destination"><br><br>
<input type="hidden" name="operation" value="viewSchedule">
<button type="submit" value="search">Search Schedule</button>
</form>
</body>
</html>