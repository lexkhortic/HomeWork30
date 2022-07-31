import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class DataBaseFromTypeFines {
    public static void showDBFromTypeFines() throws IOException {
        System.out.print("\nВведите тип(номер) штрафа: ");
        int inputTypeFine = Integer.parseInt(General_HW30.reader.readLine());
        System.out.println("Граждане со штрафом: " + TypeFineEnum.createTypeFines(inputTypeFine));
        AtomicBoolean isNotFound = new AtomicBoolean(true);
        General_HW30.taxDataBase.forEach((key, value) -> {
            value.getTypeFines().forEach(el -> {
                if (el.getIdFine() == inputTypeFine) {
                    createVoid(value);
                    isNotFound.set(false);
                }
            });
        });

        if (isNotFound.get()) {
            System.out.println("Граждан со штрафами " + TypeFineEnum.createTypeFines(inputTypeFine) + " нет в БД!\n");
        }
        System.out.println();
        General_HW30.showMenu();
    }

    public static void createVoid(Citizen citizen) {
        System.out.println(
                "ID: " + citizen.getId() +
                ", ФИО: " + citizen.getFio() +
                ", Город: " + citizen.getCity().getCityValue());

    }

}
