CREATE DATABASE SoalQueryMega

use SoalQueryMega;

CREATE TABLE Karyawan (
	NIP char(3) PRIMARY KEY NOT NULL,
	Nama varchar(50) NOT NULL,
	Umur int NOT NULL,
	Gaji money NOT NULL,
	Valuta varchar(3) NOT NULL
)

CREATE TABLE Kurs (
	Valuta varchar(3) PRIMARY KEY NOT NULL,
	Kurs money NOT NULL
)


INSERT INTO Karyawan (NIP,Nama,Umur,Gaji,Valuta)
VALUES ('001', 'Anton', 25, 650, 'USD');
GO
INSERT INTO Karyawan (NIP,Nama,Umur,Gaji,Valuta)
VALUES ('002', 'Budi', 35, 545, 'EUR');
GO
INSERT INTO Karyawan (NIP,Nama,Umur,Gaji,Valuta)
VALUES ('003', 'Charles', 30, 7000000, 'IDR');
GO
INSERT INTO Karyawan (NIP,Nama,Umur,Gaji,Valuta)
VALUES ('004', 'Dodi', 27, 900, 'USD');
GO
INSERT INTO Karyawan (NIP,Nama,Umur,Gaji,Valuta)
VALUES ('005', 'Edwin', 41, 10000000, 'IDR');
GO
INSERT INTO Karyawan (NIP,Nama,Umur,Gaji,Valuta)
VALUES ('006', 'Fajar', 20, 750, 'EUR');
GO

INSERT INTO Kurs (Valuta,Kurs)
VALUES ('IDR',1);
GO
INSERT INTO Kurs (Valuta,Kurs)
VALUES ('USD',10000);
GO
INSERT INTO Kurs (Valuta,Kurs)
VALUES ('EUR',9000);
GO
INSERT INTO Kurs (Valuta,Kurs)
VALUES ('CNY',150);
GO
INSERT INTO Kurs (Valuta,Kurs)
VALUES ('JPY',200);
GO
