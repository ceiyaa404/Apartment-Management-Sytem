package vaksDesign;



public class UserDataBP {
    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    private String role;
    private String unitType;
    private String TenantId;
    private String leaseOfStay;
    private String apartmentUnit;
    private String moveInDate;
    private String endDate;
    private String gender;
    private double monthRate;
    private double currentBalance;
    private int loginAttempts = 0;
    private boolean blocked = false;
   
    // Basic constructor for admin
    public UserDataBP(String fullName, String email, String password, String phoneNumber, String role) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    // Full tenant constructor
    public UserDataBP(String fullName, String email, String password, String phoneNumber, String role,
                      String unitType, String TenantId, String leaseOfStay,
                      String apartmentUnit, String moveInDate, String endDate, String gender, int monthRate) {
        
        this(fullName, email, password, phoneNumber, role); 
        this.TenantId = TenantId;
        this.leaseOfStay = leaseOfStay;
        this.apartmentUnit = apartmentUnit;
        this.moveInDate = moveInDate;
        this.endDate = endDate;
        this.gender = gender;
        this.monthRate = monthRate;
        
        // ANG current balance ay equal to monthly rent
    this.currentBalance = monthRate;
    }

    // Getters and Setters
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getUnitType() { return unitType; }
    public void setUnitType(String unitType) { this.unitType = unitType; }

    public String getTenantId() { return TenantId; }
    public void setTenantId(String residentId) { this.TenantId = residentId; }

    public String getLeaseOfStay() { return leaseOfStay; }
    public void setLeaseOfStay(String leaseOfStay) { this.leaseOfStay = leaseOfStay; }

    public String getApartmentUnit() { return apartmentUnit; }
    public void setApartmentUnit(String apartmentUnit) { this.apartmentUnit = apartmentUnit; }

    public String getMoveInDate() { return moveInDate; }
    public void setMoveInDate(String moveInDate) { this.moveInDate = moveInDate; }

    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }

    public double getMonthRate() { return monthRate; }
    public void setMonthRate(double monthRate) { this.monthRate = monthRate; }
    
    public String getGender() { 
    return gender; 
}

public void setGender(String gender) { 
    this.gender = gender; 
}
public double getCurrentBalance() {
    return currentBalance;
}

public void setCurrentBalance(double currentBalance) {
    this.currentBalance = currentBalance;
}
public int getLoginAttempts() {
    return loginAttempts;
}

public void setLoginAttempts(int loginAttempts) {
    this.loginAttempts = loginAttempts;
}

public boolean isBlocked() {
    return blocked;
}

public void setBlocked(boolean blocked) {
    this.blocked = blocked;
}
}

















































/*
package vaksDesign;

public class UserDataBP {

    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    private String role;
    private String unitType;
    private String residentId;
    private String leaseOfStay;
    private String apartmentUnit;
    private String moveInDate;
    private String endDate;
    private int monthRate;

    // 🔹 Basic constructor (minimum info)
    public UserDataBP(String fullName, String email, String password, String phoneNumber, String role) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    // 🔹 Full constructor (all fields)
    public UserDataBP(String fullName, String email, String password, String phoneNumber, String role,
                      String unitType, String residentId, String leaseOfStay,
                      String apartmentUnit, String moveInDate, String endDate, int monthRate) {
        
        
        this(fullName, email, password, phoneNumber, role);
        this.unitType = unitType;
        this.residentId = residentId;
        this.leaseOfStay = leaseOfStay;
        this.apartmentUnit = apartmentUnit;
        this.moveInDate = moveInDate;
        this.endDate = endDate;
        this.monthRate = monthRate;
    }

    // 🔹 Getters and Setters
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getUnitType() { return unitType; }
    public void setBirthDate(String birthDate) { this.unitType = birthDate; }

    public String getResidentId() { return residentId; }
    public void setResidentId(String residentId) { this.residentId = residentId; }

    public String getLeaseOfStay() { return leaseOfStay; }
    public void setLeaseOfStay(String leaseOfStay) { this.leaseOfStay = leaseOfStay; }

    public String getApartmentUnit() { return apartmentUnit; }
    public void setApartmentUnit(String apartmentUnit) { this.apartmentUnit = apartmentUnit; }

    public String getMoveInDate() { return moveInDate; }
    public void setMoveInDate(String moveInDate) { this.moveInDate = moveInDate; }

    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }
    
      public int getMonthRate() { return monthRate; }
    public void setMonthRate(String endDate) { this.monthRate = monthRate; }
    

}



















































/*
package vaksDesign;

import java.util.*;

public class UserDataBP {

    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    private String role;
    private String endDate;
    private String leaseOfStay;
    private String apartmentUnit;
    private String moveInDate;
    private String birthDate;
    private String residentId;

    UserDataBP(String fullName, String email, String password, String phoneNumber, String role) {

        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.residentId = residentId;
        this.apartmentUnit = apartmentUnit;
        this.leaseOfStay = leaseOfStay;
        this.moveInDate = moveInDate;
        this.endDate = endDate;
        this.role = role;

    }

    // Constructor with optional fields
    public UserDataBP(String fullName, String email, String password, String phoneNumber, String role, String birthDate, String residentId) {
        this(fullName, email, password, phoneNumber, role);
        this.birthDate = birthDate;
        this.residentId = residentId;
    }

    // Getters and setters
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getResidentId() {
        return residentId;
    }

    public void setResidentId(String residentId) {
        this.residentId = residentId;
    }

    // existing getters/setters...
    public String getFullname() {
        return fullName;

    }

    public void setFullname(String fullName) {
        this.fullName = fullName;

    }

    public String getEmail() {
        return email;

    }

    public void setEmail(String email) {
        this.email = email;

    }

    public String getPassword() {
        return password;

    }

    public void setPassword(String password) {
        this.password = password;

    }

    public String getPhoneNumber() {
        return phoneNumber;

    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;

    }

    public String getRole() {
        return role;

    }

    public void setRole(String role) {
        this.role = role;

    }
}
*/
