package pro.sky.homework25;

public interface EmploeeServise {
    String addEmploee(String firstName, String lastName);
    String findEmploee(String firstName, String lastName);
    String delEmploee(String firstName, String lastName);
    void emploeesAbOvo();
}
