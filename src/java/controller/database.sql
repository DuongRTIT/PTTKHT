-- Tạo bảng nguoidung
CREATE TABLE tblnguoidung072 (
    id INT AUTO_INCREMENT PRIMARY KEY,
    taikhoan VARCHAR(255) NOT NULL UNIQUE,
    matkhau VARCHAR(255) NOT NULL,
	vaitro VARCHAR(10) NOT NULL,
    hoten NVARCHAR(50),
    ngaysinh Date,
    diachi NVARCHAR(50),
    email VARCHAR(50),
    sdt VARCHAR(50)
);
-- xoá bảng người dùng
DROP TABLE IF EXISTS tblnguoidung072;

-- Thêm dữ liệu người dùng
INSERT INTO tblnguoidung072 (taikhoan, matkhau, vaitro,hoten,ngaysinh,diachi,email,sdt) VALUES
('manager', 'manager', 'manager','Phạm Hải Dương','2003-03-21','Hà Nội','DuongPH.B21AT072@stu.ptit.edu.vn','0965355173'),
('customer1', 'customer1', 'customer','Nguyễn Minh Nghĩa','2003-01-14','Hà Nội','NghiaNM.B21AT144@stu.ptit.edu.vn','0986966116'),
('customer2', 'customer2', 'customer','Trần Văn Chính','2003-05-31','Nam Định','ChinhTV.B21AT048@stu.ptit.edu.vn','0838831503'),
('customer3', 'customer3', 'customer','Lê Tuấn Anh','2002-09-06','Hà Nội','AnhLT.B21AT028@stu.ptit.edu.vn','0329009381');

-- Tạo bảng khachhang kế thừa id từ nguoidung và có maKH tự động sinh ra
CREATE TABLE tblkhachhang072 (
    id INT PRIMARY KEY AUTO_INCREMENT,
    ten VARCHAR(50) NOT NULL,
    sdt VARCHAR(50),
    diachi VARCHAR(50),
    ngaySinh DATE,
    thethanhvien TINYINT DEFAULT 0,
    FOREIGN KEY (id) REFERENCES tblnguoidung072(id)
);

ALTER TABLE khachhang CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

DROP TABLE IF EXISTS tblkhachhang072

-- bảng quản lý
CREATE TABLE tblquanly072 (
    id INT PRIMARY KEY AUTO_INCREMENT,
    ten VARCHAR(50) NOT NULL,
    sdt VARCHAR(50),
    diachi VARCHAR(50),
    ngaySinh DATE,
    FOREIGN KEY (id) REFERENCES tblnguoidung072(id)
);

DROP TABLE IF EXISTS quanly

INSERT INTO tblquanly072 (id, ten, sdt, diachi, ngaySinh)
SELECT id, hoten, sdt, diachi, ngaySinh
FROM tblnguoidung072
WHERE vaitro = 'manager';



-- chèn dữ liệu khách hàng
INSERT INTO tblkhachhang072 (id, ten, sdt, diachi, ngaySinh, thethanhvien)
SELECT id, hoten, sdt, diachi, ngaySinh, 0 
FROM tblnguoidung072
WHERE vaitro = 'customer';


-- Xóa bảng khachhang
DROP TABLE IF EXISTS tblkhachhang072


-- thẻ thanh viên
CREATE TABLE tblthethanhvien072 (
    id VARCHAR(20) PRIMARY KEY, 
    idKhachHang INT,                
    chuThe VARCHAR(100),            
    ngayTao DATE,                  
    FOREIGN KEY (idKhachHang) REFERENCES tblkhachhang072(id)
);

-- Xóa bảng thethanhvien
DROP TABLE IF EXISTS thethanhvien


-- Bảng phim
CREATE TABLE tblphim072(
	id int primary key auto_increment,
    tenPhim nvarchar(50) not null,
    theLoai nvarchar(50) ,
    daoDien nvarchar(50) ,
    thoiLuong int,
    ngayPhatHanh DATE
);

-- xoá bảng phim
DROP TABLE IF EXISTS tblphim072

-- list phim
insert into tblphim072 (tenPhim,theLoai,daoDien,thoiLuong,ngayPhatHanh) VALUES
('Godzilla Vs Kong',' Khoa học viễn tưởng, quái vật','Adam Wingard',113,'2024-03-29'),
('Avatar 2',' Khoa học viễn tưởng, Hành Động, Phiêu Lưu','James Cameron',120,'2022-10-08'),
('Spider-Man: Far From Home',' Khoa học viễn tưởng, Hành Động, Phiêu Lưu','Jon Watts',120,'2019-01-01'),
(' Alien: Covenant',' Khoa học viễn tưởng, Hành Động, Quái Vật','Ridley Scott',110,'2017-10-14'),
('The Platform','Khoa học viễn tưởng, Vũ Trụ, Kinh Dị, Giật Gân','Galder Gaztelu-Urrutia',95,'2019-12-12');

-- bảng phòng chiếu
CREATE TABLE tblphongchieu072 (
    id INT PRIMARY KEY AUTO_INCREMENT,    
    tenPhong VARCHAR(50) NOT NULL,              
    sucChua INT NOT NULL,                          
    loaiPhong VARCHAR(50)                        
);

-- xoá bảng phòng chiếu
DROP TABLE IF EXISTS phongchieu

-- list phong chieu
insert into tblphongchieu072 (tenPhong,sucChua,loaiPhong) VALUES
('Phong 1',50,'VIP'),
('Phong 2',50,'VIP'),
('Phong 3',80,'3D'),
('Phong 4',80,'3D'),
('Phong 5',80,'3D'),
('Phong 6',80,'3D'),
('Phong 7',80,'3D');

-- bảng suất chiếu
CREATE TABLE tblsuatchieu072 (
    id INT PRIMARY KEY AUTO_INCREMENT,  
    idPhim INT NOT NULL,                        
    idPhong INT NOT NULL,                        
    ngayChieu DATE NOT NULL,                    
    gioBatDau TIME NOT NULL,                     
    gioKetThuc TIME,                                     
    FOREIGN KEY (idPhim) REFERENCES tblphim072(id) ,
    FOREIGN KEY (idPhong) REFERENCES tblphongChieu072(id) 
);
-- xoá bảng suatchieu
DROP TABLE IF EXISTS suatchieu

-- list suatchieu
insert into tblsuatchieu072(idPhim,idPhong,ngayChieu,gioBatDau,gioKetThuc) VALUES
(1,1,'2024-10-20','19:00:00','21:00:00'),
(1,1,'2024-10-20','21:30:00','23:30:00'),
(1,1,'2024-10-21','19:00:00','21:00:00'),
(1,1,'2024-10-22','19:00:00','21:00:00'),
(1,1,'2024-10-22','21:30:00','23:30:00'),
(1,2,'2024-10-22','19:00:00','21:00:00'),
(1,5,'2024-10-20','19:00:00','21:00:00'),
(1,6,'2024-10-21','19:00:00','21:00:00'),
(2,2,'2024-10-20','19:00:00','21:00:00'),
(2,2,'2024-10-25','19:00:00','21:00:00'),
(2,3,'2024-10-24','19:00:00','21:00:00'),
(2,1,'2024-10-21','21:30:00','23:30:00'),
(2,4,'2024-10-23','21:30:00','23:30:00'),
(3,3,'2024-10-21','21:30:00','23:30:00'),
(3,5,'2024-10-27','21:30:00','23:30:00'),
(3,1,'2024-10-27','21:30:00','23:30:00'),
(4,2,'2024-10-24','21:30:00','23:30:00'),
(4,6,'2024-10-24','21:30:00','23:30:00'),
(4,7,'2024-10-24','21:30:00','23:30:00'),
(4,7,'2024-10-25','19:00:00','21:00:00'),
(5,1,'2024-10-24','21:30:00','23:30:00'),
(5,2,'2024-10-27','21:30:00','23:30:00'),
(5,5,'2024-10-20','21:30:00','23:30:00'),
(5,6,'2024-10-26','21:30:00','23:30:00'),
(5,1,'2024-10-26','19:00:00','21:00:00');




-- bảng vé
CREATE TABLE tblve072 (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idSuatChieu INT NOT NULL,
    idKhachHang INT NOT NULL,
    idHoaDon INT NOT NULL,
    giaVe DOUBLE NOT NULL,   -- vip 200 ,3D 100
    soLuongVe INT NOT NULL,
    ngayMua DATE NOT NULL,
    FOREIGN KEY (idSuatChieu) REFERENCES tblsuatchieu072(id) ,
    FOREIGN KEY (idKhachHang) REFERENCES tblkhachhang072(id) ,
    FOREIGN KEY (idHoaDon) REFERENCES tblhoadon072(id) 
);

-- xoá bảng vé
DROP TABLE IF exists ve

-- list ve
INSERT INTO tblve072 (idSuatChieu, idKhachHang, giaVe, soLuongVe, ngayMua, idHoadon) 
select idSuatChieu,idKhachHang,tongTien,soLuongVe,ngayLap,id from tblhoadon072





-- bảng hoá đơn
CREATE TABLE tblhoadon072 (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idKhachHang INT NOT NULL,
    idSuatChieu INT NOT NULL,
    soLuongVe INT NOT NULL,
    tongTien DOUBLE NOT NULL,
    ngayLap DATE NOT NULL,
    FOREIGN KEY (idKhachHang) REFERENCES tblkhachhang072(id),
    FOREIGN KEY (idSuatChieu) REFERENCES tblsuatchieu072(id)
);
-- xoá hoá đơn
DROP TABLE IF exists tblhoadon072

-- hoá đơn 
insert into tblhoadon072(idKhachHang,soLuongVe,idSuatChieu,tongTien,ngayLap) VALUES
(2,1,1,200000,'2024-10-20'), -- 1x suatchieu 1
(3,2,3,400000,'2024-10-20'), -- 2x suatchieu 3
(2,3,5,300000,'2024-10-20'), -- 3x suatchieu 5
(4,3,7,300000,'2024-10-21'),-- 3x suatchieu 7
(2,1,10,200000,'2024-10-22'),-- 1x suatchieu 10
(4,1,14,100000,'2024-10-23'),-- 1x suat chieu 14
(2,5,15,1000000,'2024-10-23'),-- 5x suat chieu 15
(3,3,17,600000,'2024-10-24'), -- 3x suat chieu 17
(2,3,18,300000,'2024-10-24'),-- 3x suat chieu 18
(2,10,24,2000000,'2024-10-26'),-- 10x suat chieu 24
(3,4,24,800000,'2024-10-26'),-- 4x suat chieu 24
(4,1,25,100000,'2024-10-26');-- 1x suat chieu 25







-- test
select * from nguoidung
select * from khachhang
select * from tblthethanhvien072
select * from tblphim072
select * from tblphongchieu072
select *) from tblve072
select * from tblsuatchieu072
select * from tblhoadon072



BEGIN;
DELETE FROM thethanhvien WHERE idKhachhang =2;
UPDATE khachhang SET thethanhvien = 0 WHERE id = 2;
COMMIT;


SELECT p.id, p.tenPhim, SUM(h.tongTien) AS totalRevenue
FROM hoadon h nguoidung
JOIN suatchieu s ON h.idSuatChieu = s.id 
JOIN phim p ON s.idPhim = p.id
WHERE h.ngayLap BETWEEN STR_TO_DATE('10-20-2024', '%m-%d-%Y') AND STR_TO_DATE('10-29-2024', '%m-%d-%Y') 
GROUP BY p.id, p.tenPhim
ORDER BY totalRevenue DESC;



SELECT 
    s.id AS ShowTimeId, 
    s.gioBatDau, 
    CONCAT(s.ngayChieu, ' ', s.gioBatDau) AS ShowTime,  
    SUM(h.tongTien) AS totalRevenue
FROM 
    suatchieu s
LEFT JOIN 
    hoadon h ON s.id = h.idSuatChieu
WHERE 
    s.idPhim = 2 and h.tongTien != 0
GROUP BY 
    s.id, s.ngayChieu, s.gioBatDau;



