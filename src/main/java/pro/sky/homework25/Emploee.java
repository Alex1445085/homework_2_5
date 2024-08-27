package pro.sky.homework25;

import java.util.Objects;

public class Emploee {
    private String firstName;
    private String lastName;

    public Emploee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + ", ";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (this.hashCode() != obj.hashCode()) { return false; }
        if (this.getClass() != obj.getClass() || obj == null) return false;
        return (this.firstName.equals(((Emploee) obj).getFirstName()) &&
                this.lastName.equals(((Emploee) obj).getLastName()));
    }
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
