<%-- 
    Document   : index
    Created on : Sep 23, 2017, 11:53:56 AM
    Author     : Devendra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <script language="javascript">
 
            function submitForm () {
                var myForm = document.getElementById("indexForm");
                myForm.submit(this);
            }
        </script>
    </head>
    <body>
    <center>
        <form action="index" id="indexForm" method="get"></form>

        <form action="PRNServlet" method="get">
            <table style="width: 50%; height: 100px; border-style:dotted; border-color: orange;" >
                <caption style="background: orange;  text-align:center; text-transform: capitalize; font-size:large;">Search PRN</caption>
                <tr>
                    <th>Enter your PRN&nbsp;:</th>
                    <th><input type="text" name="prnNo" value="${prnNo}" maxlength="100"/></th>
                </tr>

                <tr>
                    <td align="center" colspan="2">
                        <input type="submit" value="Search"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="button" value="Reset" onclick="submitForm()"/>
                    </td>
                </tr>
            </table>
        </form>

        <jsp:include flush="true" page="prnResult.jsp"/>

    </center>
</body>
</html>
