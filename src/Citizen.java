import java.util.ArrayList;

public class Citizen {
    private long id;
    private String fio;
    private CityEnum city;
    private ArrayList<TypeFineEnum> typeFines;

    public Citizen() {
    }

    public Citizen(long id, String fio, CityEnum city, ArrayList<TypeFineEnum> typeFines) {
        this.id = id;
        this.fio = fio;
        this.typeFines = typeFines;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public ArrayList<TypeFineEnum> getTypeFines() {
        return typeFines;
    }

    public void setTypeFines(ArrayList<TypeFineEnum> typeFines) {
        this.typeFines = typeFines;
    }

    public CityEnum getCity() {
        return city;
    }

    public void setCity(CityEnum city) {
        this.city = city;
    }

    public String typeFinesToString() {
        StringBuilder str = new StringBuilder();
        typeFines.forEach(el -> {
            str.append("#");
            str.append(el.getIdFine());
            str.append(" - ");
            str.append(el.getValue());
            str.append(";\n");
        });
        return str.toString();
    }

    @Override
    public String toString() {
        return
                "ID: " + id +
                ", ФИО: " + fio +
                ", Город: " + city.getCityValue() +
                "\nШтрафы:\n" + typeFinesToString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Citizen citizen = (Citizen) o;

        if (id != citizen.id) return false;
        if (fio != null ? !fio.equals(citizen.fio) : citizen.fio != null) return false;
        if (typeFines != null ? !typeFines.equals(citizen.typeFines) : citizen.typeFines != null) return false;
        return city == citizen.city;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (typeFines != null ? typeFines.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
