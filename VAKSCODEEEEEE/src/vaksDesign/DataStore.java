package vaksDesign;

import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class DataStore {

    public static DefaultTableModel tenantModel;
    public static DefaultTableModel unitModel;
    public static DefaultTableModel transactionModel;
    public static DefaultTableModel paymentHistoryModel;
    public static DefaultTableModel tenantPaymentHistoryModel;
    public static DefaultTableModel paymentModel;
    public static DefaultTableModel adminRecentTransactionModel;

    public static DefaultComboBoxModel<String> paymentComboModel;

    public static void addPayment(String date, String unit, String tenant, String method, String amount, String status) {
        transactionModel.addRow(new Object[]{date, unit, tenant, method, amount});

        tenantPaymentHistoryModel.addRow(new Object[]{date, method, amount, status, tenant});
        paymentHistoryModel.addRow(new Object[]{date, unit, tenant, method, amount, status});

        //Idagdag lang sa Admin Recent Transaction kapag ang status ay "Paid"
        if ("Paid".equalsIgnoreCase(status)) {
            //Idagdag ito para mag-update din ang admin table mo (Date, Tenant, Method, Amount)
            adminRecentTransactionModel.addRow(new Object[]{date, tenant, method, amount});
        }
    }

    public static void updatePaymentStatus(int rowIndex, String newStatus) {
        // Siguraduhing pantay na na-uupdate ang status sa parehong tables
        if (rowIndex >= 0 && rowIndex < tenantPaymentHistoryModel.getRowCount()) {
            tenantPaymentHistoryModel.setValueAt(newStatus, rowIndex, 3); // Column 3 = Status
        }

        if (rowIndex >= 0 && rowIndex < paymentHistoryModel.getRowCount()) {
            paymentHistoryModel.setValueAt(newStatus, rowIndex, 5); // Column 5 = Status
        }

        // Kapag naging "Paid", idagdag sa Admin Recent Transactions
        if ("Paid".equalsIgnoreCase(newStatus) && rowIndex < paymentHistoryModel.getRowCount()) {
            String date = (String) paymentHistoryModel.getValueAt(rowIndex, 0);
            String tenant = (String) paymentHistoryModel.getValueAt(rowIndex, 2);
            String method = (String) paymentHistoryModel.getValueAt(rowIndex, 3);
            String amount = (String) paymentHistoryModel.getValueAt(rowIndex, 4);

            adminRecentTransactionModel.addRow(new Object[]{date, tenant, method, amount});
        }
    }

    // Delete payment
    public static void deletePayment(int rowIndex) {
        transactionModel.removeRow(rowIndex);
        paymentHistoryModel.removeRow(rowIndex);
        tenantPaymentHistoryModel.removeRow(rowIndex);
    }
    //update payment

    public static void updatePaymentMethod(int rowIndex, String method) {
        tenantPaymentHistoryModel.setValueAt(method, rowIndex, 1); // column 1 = Method (sa tenant table)
        paymentHistoryModel.setValueAt(method, rowIndex, 3);       // column 3 = Method (sa admin paymentHistoryModel)
    }

    public static void updatePaymentAmount(int rowIndex, String amount) {
        tenantPaymentHistoryModel.setValueAt(amount, rowIndex, 2); // column 2 = Amount (sa tenant table)
        paymentHistoryModel.setValueAt(amount, rowIndex, 4);       // column 4 = Amount (sa admin paymentHistoryModel)
    }

    static {
        tenantModel = new DefaultTableModel(//tenant management
                new Object[][]{},
                new String[]{"ID", "Name", "Unit No.", "Email Address"}
        );

        unitModel = new DefaultTableModel(//apartment unit
                new Object[][]{},
                new String[]{"Unit No.", "Type", "Area (sqm)", "Rent (₱)", "Status"}
        );

        transactionModel = new DefaultTableModel(
                new Object[][]{
                    {"2026-10-01", "U001", "Juan Dela Cruz", "Maya", "₱8000"},},
                new String[]{"Date", "Unit No.", "Tenant Name", "Method", "Amount"}
        );

        paymentHistoryModel = new DefaultTableModel( //transac
                new Object[][]{},
                new String[]{"Date", "Unit No.", "Tenant Name", "Method", "Amount", "Status"}
        );

        tenantPaymentHistoryModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Date", "Method", "Amount", "Status", "TenantEmail"}
        );

        paymentComboModel = new DefaultComboBoxModel<>(
                new String[]{"🏦 Bank Transfers", "💳 Credit Card", "💳 Debit Card", "🖩 GCash", "📱 Pay Maya"}
        );
        adminRecentTransactionModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Date", "Tenant", "Method", "Amount"}
        );
    }

    // Auto-sync ng Tenant Name at Email sa lahat ng tables at history kapag pinalitan ni Admin
    public static void updateTenantDetails(String oldName, String oldEmail, String newName, String newEmail) {
        // 1. I-update ang paymentHistoryModel (Column 2 = Tenant Name)
        for (int i = 0; i < paymentHistoryModel.getRowCount(); i++) {
            String tenantInHistory = (String) paymentHistoryModel.getValueAt(i, 2);
            if (tenantInHistory != null && tenantInHistory.equalsIgnoreCase(oldName)) {
                paymentHistoryModel.setValueAt(newName, i, 2);
            }
        }

        //I-update ang transactionModel (Column 2 = Tenant Name)
        for (int i = 0; i < transactionModel.getRowCount(); i++) {
            String tenantInTrans = (String) transactionModel.getValueAt(i, 2);
            if (tenantInTrans != null && tenantInTrans.equalsIgnoreCase(oldName)) {
                transactionModel.setValueAt(newName, i, 2);
            }
        }

        //I-update ang tenantPaymentHistoryModel (Column 4 = TenantEmail)
        for (int i = 0; i < tenantPaymentHistoryModel.getRowCount(); i++) {
            String emailInTenantHist = (String) tenantPaymentHistoryModel.getValueAt(i, 4);
            if (emailInTenantHist != null && emailInTenantHist.equalsIgnoreCase(oldEmail)) {
                tenantPaymentHistoryModel.setValueAt(newEmail, i, 4);
            }
        }

        //I-update ang adminRecentTransactionModel (Column 1 = Tenant Name)
        for (int i = 0; i < adminRecentTransactionModel.getRowCount(); i++) {
            String tenantInRecent = (String) adminRecentTransactionModel.getValueAt(i, 1);
            if (tenantInRecent != null && tenantInRecent.equalsIgnoreCase(oldName)) {
                adminRecentTransactionModel.setValueAt(newName, i, 1);
            }
        }
    }
    //Automatic na ginagawang "Overdue" ang mga "Pending" kapag lumagpas na sa Due Date

    public static void checkAndUpdateOverdueStatus(String tenantEmail, LocalDate dueDate) {
        if (LocalDate.now().isAfter(dueDate)) {
            for (int i = 0; i < tenantPaymentHistoryModel.getRowCount(); i++) {
                String email = (String) tenantPaymentHistoryModel.getValueAt(i, 4); 
                String status = (String) tenantPaymentHistoryModel.getValueAt(i, 3); 

                if (tenantEmail.equalsIgnoreCase(email) && "Pending".equalsIgnoreCase(status)) {
                    // I-update sa "Overdue" sa parehong tables
                    tenantPaymentHistoryModel.setValueAt("Overdue", i, 3);

                    // Hanapin at i-update din sa admin paymentHistoryModel kung tumutugma
                    if (i < paymentHistoryModel.getRowCount()) {
                        paymentHistoryModel.setValueAt("Overdue", i, 5);
                    }
                }
            }
        }
    }
}
