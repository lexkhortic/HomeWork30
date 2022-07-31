import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class General_HW30 {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static HashMap<Long, Citizen> taxDataBase = new HashMap<>();

    public static void main(String[] args) throws IOException {
        ArrayList<TypeFineEnum> fine1 = new ArrayList<>();
        fine1.add(TypeFineEnum.PARKING);
        ArrayList<TypeFineEnum> fine2 = new ArrayList<>();
        fine2.add(TypeFineEnum.HIGH_SPEED);
        fine2.add(TypeFineEnum.BELT_NOT_FASTENED);
        fine2.add(TypeFineEnum.PARKING);
        ArrayList<TypeFineEnum> fine3 = new ArrayList<>();
        fine3.add(TypeFineEnum.HIGH_SPEED);
        fine3.add(TypeFineEnum.PARKING);

        taxDataBase.put(1L, new Citizen(1L, "Хорт Алексей Андреевич", CityEnum.MINSK, fine1));
        taxDataBase.put(2L, new Citizen(2L, "Стоянов Сергей Игоревич", CityEnum.MINSK_OBL, fine2));
        taxDataBase.put(3L, new Citizen(3L, "Трубило Егор Васильевич", CityEnum.MINSK_OBL, fine3));
        showMenu();
    }

    public static void showMenu() throws IOException {
        System.out.println(
                        "1 - Просмотреть БД\n" +
                        "2 - Вывод информации по ID\n" +
                        "3 - Вывод информации по типам штрафов\n" +
                        "4 - Вывод информации по городам\n" +
                        "5 - Добавление нового гражданина\n" +
                        "6 - Добавить штраф к существующему гражданину\n" +
                        "7 - Удалить штраф у соответствующего гражданина\n" +
                        "8 - Замена информации о человеке и его штрафах\n" +
                        "0 - ВЫХОД");
        System.out.print("Выбирете действие: ");
        int choice = Integer.parseInt(reader.readLine());
        switch (choice) {
            case 1:
                MethodsDataBase.showDataBase();
                break;
            case 2:
                DataBaseFromID.showDBFromID();
                break;
            case 3:
                DataBaseFromTypeFines.showDBFromTypeFines();
                break;
            case 4:
                DataBaseFromCity.showDBFromCity();
                break;
            case 5:
                CreateNewCitizen.addNewCitizen();
                break;
            case 6:
                MethodsDataBase.addFine();
                break;
            case 7:
                MethodsDataBase.deleteFine();
                break;
            case 8:
                MethodsDataBase.replaceCitizen();
                break;
            default:
                System.out.println("Программа закрывается...");
                break;
        }
    }
}
