<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP List Users Records</title>
</head>
<body>
<form name="print">

	

    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/workout"
        user="root" password="WYing2402"
    />
     
    <sql:query var="lisGroup1"   dataSource="${myDS}">
        SELECT name, split FROM `group`;
    </sql:query>
     
    <div align="center">
    <caption><h2>Group 1: </h2></caption>
              <c:forEach var="user" items="${lisGroup1.rows}">                       
                  <c:out value="${user.name}" />    
            </c:forEach>
            
            
            
        <table  id = "my-table" cellpadding="5" cellspacing="5" border="1">
             <c:forEach var="user" items="${lisGroup1.rows}">
             <tr>
           <td>  <c:out value="${user.name}" /></td>
           <td>${user.split}</td>
          
                
            </tr>
            </c:forEach>
        </table>
    </div>
    
    </form>
    <script>
    var num1;
    function getnum(getint){
    	
        num1 = Number(document.print.getint.value);
    }
    

    for (j = 0; j < num1; j++) {
        var tbl = document.getElementById('my-table'), // table reference
            i;
        // open loop for each row and append cell
        for (i = 0; i < tbl.rows.length; i++) {
            createCell(tbl.rows[i].insertCell(tbl.rows[i].cells.length),'col');
        }
    }
    
    function createCell(cell, style) {
        var div = document.createElement('div'), // create DIV element
            txt = document.createTextNode('\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0'); 
        div.appendChild(txt);                    // append text node to the DIV
        div.setAttribute('class', style);        // set DIV class attribute
        div.setAttribute('className', style);    // set DIV class attribute for IE (?!)
        cell.appendChild(div);                   // append DIV to the table cell
    }
    </script>
</body>
</html>