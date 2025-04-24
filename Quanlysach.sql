

CREATE TABLE SACH (
    MASACH      NVARCHAR2(20) PRIMARY KEY,   -- Tăng chiều dài mã sách nếu cần
    TENSACH     NVARCHAR2(100),
    TACGIA      NVARCHAR2(50),
    NXB         NVARCHAR2(50),
    GIA         NUMBER(10, 0)                 -- Không cần số thập phân cho giá sách
);

Select * from SACH;

INSERT INTO SACH (MASACH, TENSACH, TACGIA, NXB, GIA) VALUES ('S001', 'Trong gia đình', 'Hector Malot', 'NXB Văn Học', 150000);
INSERT INTO SACH (MASACH, TENSACH, TACGIA, NXB, GIA) VALUES ('S002', 'Không gia đình', 'Hector Malot', 'NXB Văn Học', 120000);
INSERT INTO SACH (MASACH, TENSACH, TACGIA, NXB, GIA) VALUES ('S003', 'Nếu em không phải giấc mơ', 'Marc Levy', 'NXB Trẻ', 200000);
INSERT INTO SACH (MASACH, TENSACH, TACGIA, NXB, GIA) VALUES ('S004', 'Gặp lại', 'Marc Levy', 'NXB Văn Học', 180000);
INSERT INTO SACH (MASACH, TENSACH, TACGIA, NXB, GIA) VALUES ('S005', 'Con Bim trắng tai đen', 'Gavriil Troyepolsky', 'NXB Kim Đồng', 90000);
INSERT INTO SACH (MASACH, TENSACH, TACGIA, NXB, GIA) VALUES ('S006', 'Cây cam ngọt của tôi', 'JoSé Mauro de Vasconcelos', 'NXB Hội Nhà Văn', 120000);
INSERT INTO SACH (MASACH, TENSACH, TACGIA, NXB, GIA) VALUES ('S007', 'Chú bé mang Pyjama sọc', 'John Boyne', 'NXB Dân trí', 140000);
INSERT INTO SACH (MASACH, TENSACH, TACGIA, NXB, GIA) VALUES ('S008', 'Hoàng tử bé', 'Antoine de Saint-Exupéry', 'NXB Văn học', 100000);
INSERT INTO SACH (MASACH, TENSACH, TACGIA, NXB, GIA) VALUES ('S009', 'Kiêu hãnh và định kiến', 'Jane Austen', 'NXB Thế giới', 220000);
INSERT INTO SACH (MASACH, TENSACH, TACGIA, NXB, GIA) VALUES ('S010', 'Người đua diều', 'Khaled Hosseini', 'NXB Hà Nội', 250000);
INSERT INTO SACH (MASACH, TENSACH, TACGIA, NXB, GIA) VALUES ('S011', 'Lại thằng nhóc Emil', 'Astrid Lindgren', 'NXB Trẻ', 230000);
INSERT INTO SACH (MASACH, TENSACH, TACGIA, NXB, GIA) VALUES ('S012', 'Pipi tất dài', 'Astrid Lindgren', 'NXB Kim Đồng', 95000);
INSERT INTO SACH (MASACH, TENSACH, TACGIA, NXB, GIA) VALUES ('S013', 'Rừng Nauy', 'Haruki Murakami', 'NXB Trẻ', 180000);
INSERT INTO SACH (MASACH, TENSACH, TACGIA, NXB, GIA) VALUES ('S014', 'Giết con chim nhạn', 'Harper Lee', 'NXB Hội Nhà Văn', 210000);
INSERT INTO SACH (MASACH, TENSACH, TACGIA, NXB, GIA) VALUES ('S015', 'Anne tóc đỏ dưới chái nhà xanh', 'Lucy Maud Montgomery', 'NXB Trẻ', 170000);
INSERT INTO SACH (MASACH, TENSACH, TACGIA, NXB, GIA) VALUES ('S016', 'Tiệm sách cũ Biblia', 'Mikami En', 'NXB Sách Hay', 150000);
INSERT INTO SACH (MASACH, TENSACH, TACGIA, NXB, GIA) VALUES ('S017', 'Những tấm lòng cao cả', 'Edmondo De Amicis', 'NXB Đà Nẵng', 110000);
INSERT INTO SACH (MASACH, TENSACH, TACGIA, NXB, GIA) VALUES ('S018', 'Đảo giấu vàng', 'David McKee', 'NXB Kim Đồng', 130000);
INSERT INTO SACH (MASACH, TENSACH, TACGIA, NXB, GIA) VALUES ('S019', 'Cuốn theo chiều gió', 'Margaret Mitchell', 'NXB Dân Trí', 250000);
INSERT INTO SACH (MASACH, TENSACH, TACGIA, NXB, GIA) VALUES ('S020', 'Mắt biếc', 'Nguyễn Nhật Ánh', 'NXB Trẻ', 120000);