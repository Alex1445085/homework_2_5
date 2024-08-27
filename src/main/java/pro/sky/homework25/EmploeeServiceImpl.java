package pro.sky.homework25;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmploeeServiceImpl implements EmploeeServise {

    int maxEmploee = 15;
    List<Emploee> emploees = new ArrayList<>();

    @Override
    public String addEmploee(String firstName, String lastName) {
        Emploee temp = new Emploee(firstName, lastName);
        String word = "";
        if (emploees.size() >= maxEmploee) {
            throw new EmployeeStorageIsFullException();
        }
        if (findPerson(temp)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            emploees.add(temp);
            word = "success, сотрудник " + temp.toString() + " добавлен.";
        }
        return word;
    }

    @Override
    public String findEmploee(String firstName, String lastName) {
        Emploee temp = new Emploee(firstName, lastName);
        if (!findPerson(temp)) {
            throw new EmployeeNotExistException();
        } else { return "Сотрудник " + temp.toString() + " находится в штате."; }
    }

    @Override
    public String delEmploee(String firstName, String lastName) {
        Emploee temp = new Emploee(firstName, lastName);
        if (!findPerson(temp)) {
            throw new EmployeeNotExistException();
        } else {
            emploees.remove(temp);
            return "Сотрудник " + temp.toString() + " удален из списка.";
         }
    }

    public String listOfEmploee() {
        String temporary = "";
        for (Emploee temp : emploees) {
            temporary = temporary + ("\n" + temp.toString());
        }
        return temporary;
    }

    @Override
    public void emploeesAbOvo() {
        emploees.add(new Emploee("Ivanov", "Goga"));
        emploees.add(new Emploee("Gamov", "Petr"));
        emploees.add(new Emploee("Kukin", "Andr"));
        emploees.add(new Emploee("Vasin", "Alex"));
        emploees.add(new Emploee("Soev", "Igor"));
        emploees.add(new Emploee("Sonin", "Petr"));
        emploees.add(new Emploee("Virko", "Ant"));
    }

    public boolean findPerson(Emploee temp) {
        boolean tr = false;
        for (int i = 0; i < emploees.size(); i++) {
            if (temp.equals(emploees.get(i))) { tr = true; }
        }
        return tr;
    }
}

