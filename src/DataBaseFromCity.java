import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class DataBaseFromCity {
    public static void showDBFromCity() throws IOException {
        System.out.print("\nВведите город поиска: ");
        String inputCity = General_HW30.reader.readLine().toUpperCase(Locale.ROOT);
        AtomicBoolean isNotFound = new AtomicBoolean(true);

        General_HW30.taxDataBase.forEach((key, value) -> {
            if (value.getCity().getCityValue().equals(inputCity)) {
                System.out.println(value + "\n");
                isNotFound.set(false);
            }
        });
        if (isNotFound.get()) {
            System.out.println("Граждан по такому городу нет!\n");
        }
        General_HW30.showMenu();
    }
}
