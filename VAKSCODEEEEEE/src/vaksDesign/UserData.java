package vaksDesign;

import java.util.*;

public class UserData {

    private static ArrayList<UserDataBP> Data = new ArrayList<>();

    public UserData() {

        Data.add(new UserDataBP(
                "Vaks Bautista", // Full Name
                "VaksBautista@gmail.com", // Email
                "123456", // Password
                "09123456789", // Phone Number
                "tenant", // Role`
                "Studio", // Unit Type
                "T012", // Tenant id
                "1 Year", // Lease of Stay
                "U010", // Apartment Unit
                "2026-9-23", // Move-in Date
                "2027-10-01", // End Date
                "Female",
                10000 // Monthly Rent
        ));
        Data.add(new UserDataBP(
                "Kaito pro", // Full Name
                "KaitoPro@gmail.com", // Email
                "123456", // Password
                "09123456789", // Phone Number
                "tenant", // Role`
                "Studio", // Unit Type
                "T112", // Tenant ID
                "1 Year", // Lease of Stay
                "U105", // Apartment Unit
                "2026-8-23", // Move-in Date
                "2027-10-01", // End Date
                "male",
                10000 // Monthly Rent
        ));

        Data.add(new UserDataBP(
                "Mary Jane", // Full Name
                "Mary@gmail.com", // Email
                "123456", // Password
                "09123456789", // Phone Number
                "tenant", // Role
                "Studio", // Unit Type
                "T012", // Tenant ID
                "1 Year", // Lease of Stay
                "U101", // Apartment Unit
                "2026-10-20", // Move-in Date
                "2027-10-01", // End Date
                "Female",
                8000 // Monthly Rent
        ));
        Data.add(new UserDataBP(
                "Kai Tolentino", // Full Name
                "Kaito@gmail.com", // Email
                "654321", // Password
                "09121212121", // Phone Number
                "tenant", // Role
                "Studio", // Unit Type
                "T112", // Tenant ID
                "1 Year", // Lease of Stay
                "U105", // Apartment Unit
                "2026-08-23", // Move-in Date
                "2027-10-01", // End Date
                "Male",
                10000 // Monthly Rent
        ));

    }

    public void addUser(UserDataBP user) {
        Data.add(user);
    }

    public ArrayList<UserDataBP> getUsers() {
        return Data;
    }

    // method to para sa login and checking
    public boolean login(String email, String password) {
        for (UserDataBP u : Data) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    //para sa change pass
    public boolean changePassword(String email, String oldPass, String newPass) {
        for (UserDataBP u : Data) {
            if (u.getEmail().equals(email) && u.getPassword().equals(oldPass)) {
                u.setPassword(newPass); 
                return true; 
            }
        }
        return false; 
    }

    //to remove tenant
    public void removeUser(String tenantId) {

        Data.removeIf(user
                -> user.getTenantId().equals(tenantId));
    }

}
