package pro.sky.homework25;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmploeeServiceImpl implements EmploeeServise {

    int maxEmploee = 15;
    Map<Emploee, Integer> emploees = new HashMap<>();

    @Override
    public String addEmploee(String firstName, String lastName) {
        if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new FirstNameOrLastNameIsEmptyException();
        }
        if (!(StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName))) {
            throw new BadRequestException();
        }
        firstName = StringUtils.capitalize(firstName);
        lastName = StringUtils.capitalize(lastName);
        if (emploees.size() >= maxEmploee) {
            throw new EmployeeStorageIsFullException();
        }
        Emploee temp = new Emploee(firstName, lastName);
        String word = "";
        if (emploees.containsKey(temp)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            emploees.put(temp, temp.getId());
            word = "Success, сотрудник " + temp.toString() + ", id = " + temp.getId() + " добавлен.";
        }
        return word;
    }

    @Override
    public String findEmploee(String firstName, String lastName) {
        Emploee temp = new Emploee(firstName, lastName);
        if (!emploees.containsKey(temp)) {
            throw new EmployeeNotExistException();
        } else { return "Сотрудник " + temp.toString() + ", id = " + emploees.get(temp) + " находится в штате."; }
    }

    @Override
    public String delEmploee(String firstName, String lastName) {
        Emploee temp = new Emploee(firstName, lastName);
        if (!emploees.containsKey(temp)) {
            throw new EmployeeNotExistException();
        } else {
            emploees.remove(temp);
            return "Сотрудник " + temp.toString() + " удален из списка.";
         }
    }

    public Map listOfEmploee() { return emploees; }

    @Override
    public void emploeesAbOvo() {
        Emploee temp = new Emploee("Ivanov", "Goga");
        buildEmploee(temp);
        temp = new Emploee("Gamov", "Petr");
        buildEmploee(temp);
        temp = new Emploee("Kukin", "Andr");
        buildEmploee(temp);
        temp = new Emploee("Vasin", "Alex");
        buildEmploee(temp);
        temp = new Emploee("Soev", "Igor");
        buildEmploee(temp);
        temp = new Emploee("Sonin", "Petr");
        buildEmploee(temp);
        temp = new Emploee("Virdjn", "Ant");
        buildEmploee(temp);
    }

    public void buildEmploee(Emploee temp) { emploees.put(temp, temp.getId()); }
}

