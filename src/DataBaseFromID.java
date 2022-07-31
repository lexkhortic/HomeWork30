import java.io.IOException;

public class DataBaseFromID {
    public static void showDBFromID() throws IOException {
        System.out.print("\nВведите идентификационный номер гражданина: ");
        long inputID = Long.parseLong(General_HW30.reader.readLine());

        if (General_HW30.taxDataBase.containsKey(inputID)) {
            System.out.println(General_HW30.taxDataBase.get(inputID));
            System.out.println();
        } else {
            System.out.println("Гражданина с таким ID не существует!\n");
        }
        General_HW30.showMenu();
    }
}
