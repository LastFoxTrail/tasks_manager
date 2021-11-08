<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>tasks-manager</title>

    <style>
        form {
            width: 20%;
            border-radius: 10px;
            height: auto;
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
            background-color: #a96ae4;
            color: white;
            text-align: center;
            margin: auto;
        }

        form header {
            background: #4a0864;
            box-shadow: 0 2px  4px 0 rgba(0,0,0,.3);
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            text-align: center;
            margin-bottom: 10px;
            font-size: 30px;
            padding: 10px;
        }

        .info {
            margin: auto;
        }

        .info label {
            margin-left: 10px;
            font-size: 17px;
            float: left;
        }

        .info .basicInfo {
            margin-right: 27px;
            float: right;
        }

        textarea {
            border-radius: 10px;
            border: 1px solid #4a0864;
            resize: none;
        }

        #btnSubmit {
            width: 100%;
            height: 40px;
            background-color: #4a0864;
            border: 1px solid #4a0864;
            border-radius: 10px;
            font-size: 15px;
            color: white;
        }

        #btnSubmit:hover {
            background-color: #762a94;
        }
    </style>

</head>
<body>
<form:form action="save" modelAttribute="newTask">
    <header>
        TASK INFO
    </header>
    <div class="info">
        <form:hidden path="id"/>

        <label>Title</label>
        <form:input class="basicInfo" type="text" placeholder="new title" path="title"/>
        <br>
        <form:errors path="title"/>
        <br><br>

        <form:textarea cols="32" rows="15" placeholder="some text" path="text"/>
        <br>
        <form:errors path="text"/>
        <br><br>

        <label>Dead line (yyyy-mm-dd)</label>
        <form:input class="basicInfo" type="text" path="deadLine"/>
        <br>
        <form:errors path="deadLine"/>
        <br><br>

        <label>Date of change</label>
        <jsp:text>${newTask.dateOfChange}</jsp:text>
        <br><br>

        <input id="btnSubmit" type="submit" value="OK"/>
    </div>
</form:form>
</body>
</html>