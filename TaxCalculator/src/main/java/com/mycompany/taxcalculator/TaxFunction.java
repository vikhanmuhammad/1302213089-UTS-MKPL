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
    
        private static final double TAX_RATE = 0.05;
        private static final int NON_TAXABLE_INCOME_SINGLE = 54000000;
        private static final int NON_TAXABLE_INCOME_MARRIED = 54000000 + 4500000;
        private static final int NON_TAXABLE_CHILD_ALLOWANCE = 1500000;

	
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
            validateInput(numberOfMonthWorking, numberOfChildren);
            int taxableIncome = calculateTaxableIncome(monthlySalary, otherMonthlyIncome, numberOfMonthWorking, deductible, isMarried, numberOfChildren);
            int nonTaxableIncome = isMarried ? NON_TAXABLE_INCOME_MARRIED : NON_TAXABLE_INCOME_SINGLE;
            int tax = (int) Math.round(TAX_RATE * (taxableIncome - nonTaxableIncome));
            return Math.max(tax, 0);
        }
        
        // Metode untuk menghitung penghasilan yang dapat dikenakan pajak
        private static int calculateTaxableIncome(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int annualDeductible, boolean isMarried, int numberOfChildren) {
            int totalMonthlyIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
            int totalDeductible = annualDeductible;

            if (isMarried) {
                // Memastikan bahwa jumlah anak yang diperhitungkan tidak lebih dari 3
                int childrenCount = Math.min(numberOfChildren, 3);
                totalDeductible += childrenCount * NON_TAXABLE_CHILD_ALLOWANCE;
            }

            return totalMonthlyIncome - totalDeductible;
        }
        
        // Metode untuk validasi input
        private static void validateInput(int numberOfMonthWorking, int numberOfChildren) {
            if (numberOfMonthWorking > 12 || numberOfMonthWorking < 0) {
                throw new IllegalArgumentException("Jumlah bekerja harus di antara 0 - 12");
            }

            if (numberOfChildren < 0) {
                throw new IllegalArgumentException("Jumlah anak tidak bisa negatif");
            }
        }
}
