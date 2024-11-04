<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng ký thẻ thành viên</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style>
        .information-form {
            width: 100%;
            max-width: 200px;
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <div class="infomation-form">
        <div class="container mt-5">
            <h2 class="text-center mb-4">Đăng ký thẻ thành viên</h2>

            

            <form action="registerMember" method="post" accept-charset="UTF-8">
                <div class="form-group">
                    <label for="name">Tên khách hàng:</label>
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>

                <div class="form-group">
                    <label for="day_of_birth">Ngày sinh:</label>
                    <input type="date" class="form-control" id="day_of_birth" name="day_of_birth" required>
                </div>

                <div class="form-group">
                    <label for="address">Địa chỉ:</label>
                    <input type="text" class="form-control" id="address" name="address" required>
                </div>

                <div class="form-group">
                    <label for="phone">Số điện thoại:</label>
                    <input type="text" class="form-control" id="phone" name="phone" required>
                </div>

                <div class="form-group">
                    <label for="createDate">Ngày tạo thẻ:</label>
                    <input type="text" class="form-control" id="createDate" name="createDate" value="<%= java.time.LocalDate.now() %>" readonly>
                </div>

                <div class="d-flex justify-content-between mt-4">
                    <button type="submit" class="btn btn-primary">Đăng ký</button>
                    <a href="Home.jsp" class="btn btn-danger">Quay lại</a>
                </div>
            </form>
        </div>
     </div>
</body>
</html>
