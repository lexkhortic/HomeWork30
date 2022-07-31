public enum CityEnum {
    BREST("БРЕСТ"),
    VITEBSK("ВИТЕБСК"),
    GOMEL("ГОМЕЛЬ"),
    GRODNO("ГРОДНО"),
    MINSK_OBL("МИНСКАЯ ОБЛ."),
    MOGILEV("МОГИЛЕВ"),
    MINSK("МИНСК"),
    OTHER("НЕИЗВЕСТНО");

    private String cityValue;

    CityEnum(String city) {
        this.cityValue = city;
    }

    public String getCityValue() {
        return cityValue;
    }
}
