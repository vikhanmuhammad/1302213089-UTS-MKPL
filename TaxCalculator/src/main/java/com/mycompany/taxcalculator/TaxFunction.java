/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taxcalculator;

/**
 *
 * @author hp
 */
class TaxFunction {

	
	/*
        * Menghitung jumlah pajak penghasilan pegawai setahun.
        * 
        * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan
        * (gaji bulanan dan pemasukan lain dikalikan jumlah bulan bekerja, dikurangi pemotongan)
        * dikurangi penghasilan tidak kena pajak.
        * 
        * Penghasilan tidak kena pajak:
        * - Belum menikah: Rp 54.000.000
        * - Sudah menikah: tambah Rp 4.500.000
        * - Setiap anak (maks. 3 anak): tambah Rp 4.500.000 per anak.
        */
	
	
	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
		
		int tax = 0;
		
		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}
		
		if (numberOfChildren > 3) {
			numberOfChildren = 3;
		}
		
		if (isMarried) {
			tax = (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - (54000000 + 4500000 + (numberOfChildren * 1500000))));
		}else {
			tax = (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - 54000000));
		}
		
		if (tax < 0) {
			return 0;
		}else {
			return tax;
		}
			 
	}
}
