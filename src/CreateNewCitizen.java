import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CreateNewCitizen {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void addNewCitizen() throws IOException {
        Citizen newCitizen = new Citizen();
        newCitizen.setId(General_HW30.taxDataBase.size() + 1);
        System.out.print("Введите ФИО: ");
        newCitizen.setFio(reader.readLine());
        System.out.print("Введите ГОРОД: ");
        newCitizen.setCity(choiceCity());
        System.out.print("\nВведите КОЛ-ВО штрафов: ");
        int countFines = Integer.parseInt(reader.readLine());
        newCitizen.setTypeFines(createFines(countFines));

        General_HW30.taxDataBase.put(newCitizen.getId(), newCitizen);
        System.out.println("Новый гражданин добавлен в БД!\n");
        General_HW30.showMenu();
    }

    public static ArrayList<TypeFineEnum> createFines(int countFines) throws IOException {
        ArrayList<TypeFineEnum> fines = new ArrayList<>();
        System.out.println(
                        "#100: Неправильная парковка\n" +
                        "#200: Превышение скорости\n" +
                        "#300: Нет техосмотра\n" +
                        "#400: Создание аварийной ситуации\n" +
                        "#500: Алкогольное опьянение\n" +
                        "#600: Непрестегнутый ремень\n" +
                        "#700: Отсутствует детское кресло");

        while (countFines != 0) {
            System.out.println("Вид штрафа(осталось " + countFines + "): ");
            int typeFine = Integer.parseInt(reader.readLine());
            switch (typeFine) {
                case 100:
                    fines.add(TypeFineEnum.PARKING);
                    break;
                case 200:
                    fines.add(TypeFineEnum.HIGH_SPEED);
                    break;
                case 300:
                    fines.add(TypeFineEnum.TECHNICAL_INSPECTION);
                    break;
                case 400:
                    fines.add(TypeFineEnum.CREATE_AN_EMERGENCY);
                    break;
                case 500:
                    fines.add(TypeFineEnum.ALCOHOL_DRUNK);
                    break;
                case 600:
                    fines.add(TypeFineEnum.BELT_NOT_FASTENED);
                    break;
                case 700:
                    fines.add(TypeFineEnum.NO_CHILD_SEAT);
                    break;
            }
            countFines--;
        }
        return fines;
    }

    public static CityEnum choiceCity() throws IOException {
        System.out.println(
                "\n1 - БРЕСТ\n" +
                        "2 - ВИТЕБСК\n" +
                        "3 - ГОМЕЛЬ\n" +
                        "4 - ГРОДНО\n" +
                        "5 - МИНСКАЯ ОБЛ.\n" +
                        "6 - МОГИЛЕВ\n" +
                        "7 - МИНСК");
        System.out.print("Укажите город: ");
        int city = Integer.parseInt(reader.readLine());
        switch (city) {
            case 1:
                return CityEnum.BREST;
            case 2:
                return CityEnum.VITEBSK;
            case 3:
                return CityEnum.GOMEL;
            case 4:
                return CityEnum.GRODNO;
            case 5:
                return CityEnum.MINSK_OBL;
            case 6:
                return CityEnum.MOGILEV;
            case 7:
                return CityEnum.MINSK;
            default:
                return CityEnum.OTHER;
        }
    }
}
