import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class MethodsDataBase {
    public static void showDataBase() throws IOException {

        if (General_HW30.taxDataBase.isEmpty()) {
            System.out.println("\nБаза данных пуста, создайте нового гражданина!\n");
        } else {
            System.out.println("\nБаза данных налоговой инспекции:");
            General_HW30.taxDataBase.entrySet().forEach(System.out::println);
        }
        General_HW30.showMenu();
    }

    public static void addFine() throws IOException {
        System.out.print("\nВведите идентификационный номер гражданина для добавления штрафа: ");
        long inputID = Long.parseLong(General_HW30.reader.readLine());
        if (General_HW30.taxDataBase.containsKey(inputID)) {
            System.out.print("\nВведите КОЛ-ВО штрафов: ");
            int countFines = Integer.parseInt(General_HW30.reader.readLine());
            General_HW30.taxDataBase.get(inputID).getTypeFines().addAll(CreateNewCitizen.createFines(countFines));
            System.out.println("Штрафы успешно добавлены!\n");
        } else {
            System.out.println("Такого идентификационного номера не существует!\n");
        }
        General_HW30.showMenu();
    }

    public static void deleteFine() throws IOException {
        System.out.print("\nВведите идентификационный номер гражданина для удаления штрафа: ");
        long inputID = Long.parseLong(General_HW30.reader.readLine());
        if (General_HW30.taxDataBase.containsKey(inputID)) {
            System.out.print(toStringForDeleteAndReplace(General_HW30.taxDataBase.get(inputID)));
            System.out.print("Укажите № штрафа для удаления: ");
            int choiceNumberFind = Integer.parseInt(General_HW30.reader.readLine());
            General_HW30.taxDataBase.get(inputID).getTypeFines().remove(choiceNumberFind - 1);
            System.out.println("Штраф успешно удален!\n");
        } else {
            System.out.println("Такого идентификационного номера не существует!\n");
        }
        General_HW30.showMenu();
    }

    public static String toStringForDeleteAndReplace(Citizen citizen) {
        StringBuilder str = new StringBuilder();
        AtomicInteger counter = new AtomicInteger(0);

        citizen.getTypeFines().forEach(el -> {
                str.append(counter.incrementAndGet());
                str.append(" - #");
                str.append(el.getIdFine());
                str.append(" - ");
                str.append(el.getValue());
                str.append(";\n");

        });
        return str.toString();
    }

    public static void replaceCitizen() throws IOException {
        System.out.print("\nВведите идентификационный номер гражданина для замены данных: ");
        long inputID = Long.parseLong(General_HW30.reader.readLine());
        if (General_HW30.taxDataBase.containsKey(inputID)) {
            System.out.print("Введите новые ФИО: ");
            General_HW30.taxDataBase.get(inputID).setFio(General_HW30.reader.readLine());

            System.out.print("Введите новый ГОРОД: ");
            General_HW30.taxDataBase.get(inputID).setCity(CreateNewCitizen.choiceCity());

            System.out.println(toStringForDeleteAndReplace(General_HW30.taxDataBase.get(inputID)));
            System.out.print("Укажите № штрафа для замены: ");
            int choiceNumberFind = Integer.parseInt(General_HW30.reader.readLine());
            General_HW30.taxDataBase.get(inputID).getTypeFines().set(choiceNumberFind - 1, CreateNewCitizen.createFines(1).get(0));

            System.out.println("Данные гражданина успешно изменены!\n");
        } else {
            System.out.println("Такого идентификационного номера не существует!\n");
        }
        General_HW30.showMenu();

    }

}
