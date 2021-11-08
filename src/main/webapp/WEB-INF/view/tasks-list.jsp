<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>tasks-manager</title>

    <style>
        form {
            width: fit-content;
            height: fit-content;
            color: white;
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
            margin: auto;
        }

        table {
            background-color: #a96ae4;
            border: 1px solid #4a0864;
            text-align: center;
            margin: auto;
        }

        caption {
            background: #4a0864;
            box-shadow: 0 2px  4px 0 rgba(0,0,0,.3);
            font-size: 30px;
            padding: 10px;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            text-align: center;
        }

        td {
            padding: 10px;
            font-size: 15px;
        }

        th {
            border-bottom: 1px solid #4a0864;
            font-size: 17px;
            padding: 10px;
            text-align: center;
        }

        .btn {
            background-color: #762a94;
            display: inline-block;
            color: white;
            padding: 5px 10px;
            border: 1px solid #4a0864;
        }

        .btn:hover {
            background-color: white;
            color: #762a94;
        }

        #addBtn {
            width: 100%;
            height: 40px;
            background-color: #a96ae4;
            border: 1px solid #4a0864;
            color: white;
            font-size: 15px;
            margin-top: 5px;
        }

        #addBtn:hover {
            background-color: #762a94;
        }

        #date {
            background-color: #a96ae4;
            border: none;
            color: white;
            text-align: center;
        }
    </style>
</head>

<body>
<form>
    <table>
        <caption>MY TASKS</caption>
        <tr>
            <th>TITLE</th>
            <th>DONE</th>
            <th>DEAD LINE</th>
            <th>OPTIONS</th>
        </tr>
        <c:forEach var="task" items="${tasks}">

            <c:url var="btnDelete" value="/tasks/delete">
                <c:param name="id" value="${task.id}"/>
            </c:url>

            <c:url var="btnView" value="/tasks/edit">
                <c:param name="id" value="${task.id}"/>
            </c:url>

            <tr>
                <td>
                    <label>${task.title}</label>
                </td>
                <td>
                    <label id="date">${task.deadLine}</label>
                </td>
                <td>
                    <input class="btn" type="button" value="View" onclick="window.location.href='${btnView}'"/>
                    <input class="btn" type="button" value="Delete" onclick="window.location.href='${btnDelete}'"/>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input id="addBtn" type="button" value="Add new task" onclick="window.location.href='new'"/>
</form>
</body>

</html>