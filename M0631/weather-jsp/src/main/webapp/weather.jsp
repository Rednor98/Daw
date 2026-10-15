<%@page import="java.io.File"%>
<%@page import="org.w3c.dom.Node"%>
<%@page import="org.w3c.dom.Document"%>
<%@page import="org.w3c.dom.Element"%>
<%@page import="org.w3c.dom.NodeList"%>
<%@page import="javax.xml.parsers.*"%>
<%@page import="javax.xml.parsers.DocumentBuilderFactory"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<header>
	<h1>Weather</h1>
	<%
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	
	DocumentBuilder builder = factory.newDocumentBuilder();
	File file = new File("https://www.aemet.es/es/api-eltiempo/prediccion/2026-10-01/PB/8/6908");
	Document document = builder.parse(file);
	
	
	%>
	
</header>
<body>
	<p><%= document.getChildNodes() %></p>
</body>
</html>
