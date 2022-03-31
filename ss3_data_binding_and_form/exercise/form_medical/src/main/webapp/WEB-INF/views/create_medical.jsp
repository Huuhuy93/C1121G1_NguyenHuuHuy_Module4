<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
            crossorigin="anonymous"></script>
</head>
<body>
<div style="text-align: center">
    <h3>TỜ KHAI Y TẾ</h3>
    <p><span style="color: red">Khuyến cáo : Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</span></p>
</div>

<div class="container">
    <%--@elvariable id="medical" type="java"--%>
    <form:form method="post" action="create" modelAttribute="medical">

        <div class="form-group">
            <form:label for="inputAddress" path="hoTen">Họ tên (ghi chữ in HOA) <span style="color: red">(*)</span></form:label>
            <form:input type="text" path="hoTen" class="form-control" id="inputAddress" placeholder="1234 Main St"/>
        </div>

        <div class="form-row">
            <div class="form-group col-md-4">
                <form:label path="namSinh" for="inputEmail4">Năm sinh <span style="color: red">(*)</span></form:label>
                <form:input path="namSinh" type="date" class="form-control" id="inputEmail4"/>
            </div>
            <div class="form-group col-md-4">
                <form:label path="gioiTinh" for="inputPassword4">Giới tính <span style="color: red">(*)</span></form:label>
                <form:input path="gioiTinh" type="password" class="form-control" id="inputPassword4"/>
            </div>
            <div class="form-group col-md-4">
                <form:label path="quocTich" for="inputPassword4">Quốc tịch <span style="color: red">(*)</span></form:label>
                <form:input path="quocTich" type="password" class="form-control" id="quocTich"/>
            </div>
        </div>

        <div class="form-group">
            <form:label path="cmnd" for="inputAddress2">Số hộ chiếu hoặc số CMND <span style="color: red">(*)</span></form:label>
            <form:input path="cmnd" type="text" class="form-control" id="inputAddress2"/>
        </div>

<%--        <div class="form-group">--%>
<%--            <form:label path="thongTinDiLai" for="inputPassword4">Thông tin đi lại <span style="color: red">(*)</span></form:label><br>--%>
<%--            <form:input path="thongTinDiLai" type="radio" items="${phuongTienList}">--%>
<%--            </form:input>--%>

<%--            --%>
<%--        </div>--%>

        <div class="form-row">
            <div class="form-group col-md-6">
                <form:label path="soHieuPhuongTien" for="inputEmail4">Số hiệu phương tiện</form:label>
                <form:input path="soHieuPhuongTien" type="email" class="form-control" id="inputEm"/>
            </div>
            <div class="form-group col-md-6">
                <form:label path="soGhe" for="inputEmail4">Số ghế</form:label>
                <form:input path="soGhe" type="password" class="form-control" id="inputPasswr"/>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <form:label path="ngayKhoiHanh" for="inputPassword4">Ngày khởi hành <span style="color: red">(*)</span></form:label><br>
                <form:input path="ngayKhoiHanh" type="date" class="form-control" id="inputPaswor"/>
            </div>
            <div class="form-group col-md-6">
                <form:label path="ngayKetThuc" for="inputPassword4">Ngày kết thúc <span style="color: red">(*)</span></form:label><br>
                <form:input path="ngayKetThuc" type="date" class="form-control" id="inputPasswor"/>
            </div>
        </div>

        <div class="form-group">
            <form:label path="diDauTrong14Ngay" for="inputAddress">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào ? <span style="color: red">(*)</span></form:label>
            <form:input path="diDauTrong14Ngay" type="text" class="form-control" id="inputdress"/>
        </div>

        <div>
            <label for="inputAddress">Địa chỉ liên lạc</label><br>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <form:label path="tinhThanh" for="inputEmail4">Tỉnh / thành <span style="color: red">(*)</span></form:label>
                    <form:input path="tinhThanh" type="email" class="form-control" id="inputail4"/>
                </div>
                <div class="form-group col-md-4">
                    <form:label path="quanHuyen" for="inputPassword4">Quận / huyện <span style="color: red">(*)</span></form:label>
                    <form:input path="quanHuyen" type="password" class="form-control" id="inputPaord4"/>
                </div>
                <div class="form-group col-md-4">
                    <form:label path="phuongXa" for="inputPassword4">Phường / xẫ <span style="color: red">(*)</span></form:label>
                    <form:input path="phuongXa" type="password" class="form-control" id="quocich"/>
                </div>
            </div>
        </div>

        <div class="form-group">
            <form:label path="diaChiNoiO" for="inputAddress">Địa chỉ nơi ở <span style="color: red">(*)</span></form:label>
            <form:input path="diaChiNoiO" type="text" class="form-control" id="inpuress"/>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <form:label path="dienThoai" for="inputEmail4">Điện thoại <span style="color: red">(*)</span></form:label>
                <form:input path="dienThoai" type="email" class="form-control" id="iutEm"/>
            </div>
            <div class="form-group col-md-6">
                <form:label path="email" for="inputEmail4">Email</form:label>
                <form:input path="email" type="password" class="form-control" id="inputasswr"/>
            </div>
        </div>


        <button type="submit" class="btn btn-primary">Sign in</button>
    </form:form>
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