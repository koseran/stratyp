package com.example.stratyp.user;

public enum Role {
    USER("Χρήστης"),
    MILITARY_OFFICE_MANAGER("(Γραφείο Στρατοπέδου)"),
    ADMIN("Διαχειριστής"),
    DEPARTMENT_MANAGER("(Τμηματάρχης ΣΥ (1ο Τμήμα))");


    private final String displayName;

    // Constructor to assign the custom display name to each role
    Role(String displayName) {
        this.displayName = displayName;
    }

    // Getter to access the display name
    public String getDisplayName() {
        return displayName;
    }
}