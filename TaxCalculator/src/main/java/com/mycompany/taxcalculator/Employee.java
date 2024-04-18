/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taxcalculator;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hp
 */
public class Employee {
        private PersonalInfo personalInfo;
        private EmploymentInfo employmentInfo;
	
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	
	private FamilyMember spouse;
        private List<FamilyMember> children;
	
	public Employee(PersonalInfo personalInfo, EmploymentInfo employmentInfo) {
            this.personalInfo = personalInfo;
            this.employmentInfo = employmentInfo;
            
            children = new LinkedList<>();
        }
	
	//Mengihtung gaji berdasarkan grade pegawai
        /*
        -Grade 1, 3.000.000
        -Grade 2, 5.000.000
        -Grade 3, 7.000.000
        */
        //Khusus WNA, gaji lebih besar 50%
	public void setMonthlySalary(int grade) {	
		Map<Integer, Integer> gradeToSalary = new HashMap<>();
                gradeToSalary.put(1, 3000000);
                gradeToSalary.put(2, 5000000);
                gradeToSalary.put(3, 7000000);

                monthlySalary = gradeToSalary.getOrDefault(grade, 0);
                if (employmentInfo.isIsForeigner()) {
                    monthlySalary *= 1.5;
                }
	}
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	public void setSpouse(String spouseName, String spouseIdNumber) {
                this.spouse = new FamilyMember(spouseName, spouseIdNumber);
        }
	
	public void addChild(String childName, String childIdNumber) {
                children.add(new FamilyMember(childName, childIdNumber));
        }
	
	public int getAnnualIncomeTax() {
		
		//Menghitung pajak pekerja bedasarkan lama waktu kerja
                //Pekerja dari tahun sebelumnya, lama kerja otomatis menjadi setahun
                int monthWorkingInYear;
                LocalDate date = LocalDate.now();

                if (date.getYear() == employmentInfo.getYearJoined()) {
                    monthWorkingInYear = date.getMonthValue() - employmentInfo.getMonthJoined();
                } else {
                    monthWorkingInYear = 12;
                }

                return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouse == null, children.size());
	}
}
