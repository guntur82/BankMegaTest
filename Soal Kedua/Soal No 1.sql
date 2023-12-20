use SoalQueryMega;

SELECT
    '21-30 tahun' AS [Range Umur],
    COUNT(*) AS [Total Karyawan],
    SUM(Gaji * Kurs) AS [Total Gaji(dalam rupiah)]
FROM
    Karyawan
JOIN
    Kurs ON Karyawan.Valuta = Kurs.Valuta
WHERE 
	Umur BETWEEN 21 AND 30
UNION
SELECT
	'31-40 tahun' AS [Range Umur],
	COUNT(*) AS [Total Karyawan],
    SUM(Gaji * Kurs) AS [Total Gaji(dalam rupiah)]
FROM
    Karyawan
JOIN
    Kurs ON Karyawan.Valuta = Kurs.Valuta
WHERE 
	Umur BETWEEN 31 AND 40
UNION
SELECT
	'Lain - Lain' AS [Range Umur],
	COUNT(*) AS [Total Karyawan],
    SUM(Gaji * Kurs) AS [Total Gaji(dalam rupiah)]
FROM
    Karyawan
JOIN
    Kurs ON Karyawan.Valuta = Kurs.Valuta
WHERE 
	Umur NOT BETWEEN 21 AND 40