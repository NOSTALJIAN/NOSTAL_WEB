<%@ page language="java" contentType="text/html; charset=UTF-8" import=" java.util.*,t_member.*" pageEncoding="UTF-8"
  isELIgnored="false" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <% request.setCharacterEncoding("UTF-8"); %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
          <c:choose>
            <c:when test='${msg=="addMember" }'>
              <script>
                window.onload = function () {
                  alert("회원 등록 성공");
                }
              </script>
            </c:when>
            <c:when test='${msg=="modified" }'>
              <script>
                window.onload = function () {
                  alert("회원 정보 수정 완료");
                }
              </script>
            </c:when>
            <c:when test='${msg=="delMember" }'>
              <script>
                window.onload = function () {
                  alert("회원 정보 삭제 완료");
                }
              </script>
            </c:when>
          </c:choose>
          <meta charset="UTF-8">
          <meta http-equiv="X-UA-Compatible" content="IE=edge">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
          <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
            crossorigin="anonymous"></script>
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
            integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
            crossorigin="anonymous"></script>
          <!-- Fontawesome -->
          <script src="https://kit.fontawesome.com/591ebcb214.js" crossorigin="anonymous"></script>
          <!-- jQuery -->
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
          <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/jquery-ui.min.js"
            integrity="sha512-57oZ/vW8ANMjR/KQ6Be9v/+/h6bq9/l3f0Oc7vn6qMqyhvPd1cvKBRWWpzu0QoneImqr2SkmO4MSqU+RpHom3Q=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
          <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/themes/base/jquery-ui.min.css"
            integrity="sha512-ELV+xyi8IhEApPS/pSj66+Jiw+sOT1Mqkzlh8ExXihe4zfqbWkxPRi8wptXIO9g73FSlhmquFlUOuMSoXz5IRw=="
            crossorigin="anonymous" referrerpolicy="no-referrer" />
          <title>회원 리스트</title>
          <link href="/jw/t_member/table.css" rel="stylesheet">
          <link href="/jw/t_member/font.css" rel="stylesheet">
          <style>
            a {
              text-decoration: none;
            }
          </style>
        </head>

        <body>
          <div class="container-fluid a">
            <h1 class="mt-3" style="text-align: center; color: white; font-size: 50px;">MEMBER LIST</h1><br>
          </div>

          <div class="container-fluid" style="max-width: 1000px;">
            <table>
              <thead>
                <tr>
                  <td style="text-align: center;">ID</td>
                  <td style="text-align: center;">PW</td>
                  <td style="text-align: center;">이름</td>
                  <td style="text-align: center;">생년월일</td>
                  <td style="text-align: center; max-width: 180px;">E-MAIL</td>
                  <td style="text-align: center;">성별</td>
                  <td style="text-align: center; max-width: 250px;">취미</td>
                  <td style="text-align: center;">가입일</td>
                  <td style="text-align: center;"></td>
                </tr>
              </thead>

              <tbody>
                <c:choose>
                  <c:when test="${ empty membersList}">
                    <tr>
                      <td colspan="10" style="text-align: center;">
                        <b style="font-size: 16px;">등록된 회원이 없습니다.</b>
                      </td>
                    </tr>
                  </c:when>
                  <c:when test="${!empty membersList }">
                    <c:forEach var="mem" items="${membersList }">
                      <tr class="r">
                        <td style="text-align: center;">${mem.uid }</td>
                        <td style="text-align: center;">${mem.pwd }</td>
                        <td style="text-align: center;">${mem.uname}</td>
                        <td style="text-align: center;">${mem.birth }</td>
                        <td style="text-align: center; max-width: 180px;">${mem.email }</td>
                        <td style="text-align: center;">${mem.gender }</td>
                        <td style="text-align: center; max-width: 250px;">${mem.hobby }</td>
                        <td style="text-align: center;">${mem.joinDate}</td>
                        <td class="me-5">
                          <a href="${contextPath}/jw/t_member/member/modMemberForm.do?uid=${mem.uid }">수정</a>
                          <a href="${contextPath}/jw/t_member/member/delMember.do?uid=${mem.uid }">삭제</a>
                        </td>
                      </tr>
                    </c:forEach>
                  </c:when>
                </c:choose>
              </tbody>
            </table>
          </div>

          <div align="center">
            <button class="mt-4 btn btn-danger b" onclick="location.href='login.jsp'">로그인</button>
            <button class="mt-4 btn btn-success b" onclick="location.href='${contextPath}/jw/t_member/member/memberForm.do'">회원 가입</button>
          </div>

        </body>

        </html>