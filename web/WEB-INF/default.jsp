<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<c:set value="${pageContext.request.contextPath}" var="contextPath"/>
<c:set value="${contextPath}/resources" var="resPath"/>
<!DOCTYPE >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<table id="students" class="table">
    <thead>

    <tr class="sub-head">
        <th>Имя</th>
        <th>Возраст</th>
        <th>Редактирование</th>
        <th>Удаление</th>
    </tr>
    </thead>
    <tbody>
    <tr th:each="student : ${studentList}">
        <td th:utext="${student.name}"></td>
        <td th:utext="${student.age}"></td>
        <td>
            <form th:action="@{/edit}" th:th:object="${student}" method="POST">
                <button class="btn btn-success" type="submit" name="taskId" th:value="${student.id}">
                    <i class="far fa-edit"></i>
                </button>
            </form>
        </td>
        <td>
            <form th:action="@{/delete}" th:method="post">
                <button class="btn btn-success" type="submit" name="taskId" th:value="${student.id}">
                    <i class="fas fa-trash-alt"></i>
                </button>
            </form>
        </td>
    </tr>
    </tbody>
</table>
<div class="d-flex justify-content-end">
    <a th:href="@{/add}" class="btn btn-success" th:utext="'Добавить'"></a>
</div>
</body>
</html>