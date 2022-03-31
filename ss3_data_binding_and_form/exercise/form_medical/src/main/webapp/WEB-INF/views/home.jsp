
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Medical</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
            crossorigin="anonymous"></script>
</head>
<body>
<div align="center">
    <h2>List Medical Form</h2>

    <table border="1" id="example" class="table table-striped table-bordered">
        <thead>

        <tr>
            <th>NO</th>
            <th>ID</th>
            <th>Họ tên</th>
            <th>Năm sinh</th>
            <th>Giới tính</th>
            <th>Quốc tịch</th>
            <th>Số CMND</th>
            <th>Thông tin đi lại</th>
            <th>Số hiệu phương tiện</th>
            <th>Số ghế</th>
            <th>Ngày khởi hành</th>
            <th>Ngày kết thúc</th>
            <th>Đi đâu trong 14 ngày lại</th>
            <th>Tỉnh/thành</th>
            <th>Quận/huyện</th>
            <th>Phường/xã</th>
            <th>Địa chỉ nơi ở</th>
            <th>Điện thoại</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="medicalObjb" items="${medicalList}" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td>${medicalObjb.id}</td>
                <td>${medicalObjb.hoTen}</td>
                <td>${medicalObjb.namSinh}</td>

                <c:if test="${medicalObjb.gioiTinh == 0}">
                    <td>Nữ</td>
                </c:if>
                <c:if test="${medicalObjb.gioiTinh == 1}">
                    <td>Nam</td>
                </c:if>

                <td>${medicalObjb.quocTich}</td>
                <td>${medicalObjb.cmnd}</td>
                <td>${medicalObjb.thongTinDiLai}</td>
                <td>${medicalObjb.soHieuPhuongTien}</td>
                <td>${medicalObjb.soGhe}</td>
                <td>${medicalObjb.ngayKhoiHanh}</td>
                <td>${medicalObjb.ngayKetThuc}</td>
                <td>${medicalObjb.diDauTrong14Ngay}</td>
                <td>${medicalObjb.tinhThanh}</td>
                <td>${medicalObjb.quanHuyen}</td>
                <td>${medicalObjb.phuongXa}</td>
                <td>${medicalObjb.diaChiNoiO}</td>
                <td>${medicalObjb.dienThoai}</td>
                <td>${medicalObjb.email}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <button type="button" class="btn btn-outline-warning"><a href="/create">Create New Form</a></button>
</div>
</body>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"
        integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2"
        crossorigin="anonymous"></script>
</html>
