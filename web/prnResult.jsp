<%-- 
    Document   : prnResult
    Created on : Sep 23, 2017, 8:39:21 PM
    Author     : Devendra
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<table style="width: 50%;  border-style: ridge; border-color: orange; " >
    <caption style="background: orange;  text-align:center; text-transform: capitalize; font-size:large;">${message}</caption>
    <c:if test="${not empty list}">
        <tr>
            <th style="text-align: left">PRN NO.</th>
            <th style="text-align: left">ROLL NO.</th>
            <th style="text-align: left">EXAM YEAR</th>
            <th style="text-align: left">RESULT STATUS</th>
        </tr>
        <c:forEach items="${list}" var="rows">
            <tr>
                <td style="text-align: left">${rows.prnNo}</td>
                <td style="text-align: left">${rows.rollNo}</td>
                <td style="text-align: left">${rows.passYear}</td>
                <td style="text-align: left">${rows.result}</td>
            </tr>
        </c:forEach>
    </c:if>
</table>