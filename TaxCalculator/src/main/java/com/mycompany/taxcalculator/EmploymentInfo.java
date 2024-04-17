/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taxcalculator;

/**
 *
 * @author hp
 */
public class EmploymentInfo {
    private String employeeId;
    private int yearJoined;
    private int monthJoined;
    private int dayJoined;
    private boolean isForeigner;

    public EmploymentInfo(String employeeId, int yearJoined, int monthJoined, int dayJoined, boolean isForeigner) {
        this.employeeId = employeeId;
        this.yearJoined = yearJoined;
        this.monthJoined = monthJoined;
        this.dayJoined = dayJoined;
        this.isForeigner = isForeigner;
    }

    // Getters and setters

    public String getEmployeeId() {
        return employeeId;
    }

    public int getYearJoined() {
        return yearJoined;
    }

    public int getMonthJoined() {
        return monthJoined;
    }

    public int getDayJoined() {
        return dayJoined;
    }

    public boolean isIsForeigner() {
        return isForeigner;
    }
}
