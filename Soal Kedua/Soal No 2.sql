use SoalQueryMega;

SELECT 
	Karyawan.Valuta,
	COUNT(*) AS [Total Karyawan],
	SUM(Gaji * Kurs) AS [Total Gaji (dalam rupiah)]
FROM 
	Karyawan
JOIN
	Kurs ON Karyawan.Valuta = Kurs.Valuta
WHERE 
	Karyawan.Valuta IN ('IDR', 'USD')
GROUP BY Karyawan.Valuta