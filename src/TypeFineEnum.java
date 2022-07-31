public enum TypeFineEnum {
    PARKING("Неправильная парковка", 100),
    HIGH_SPEED("Превышение скорости", 200),
    TECHNICAL_INSPECTION("Нет техосмотра", 300),
    CREATE_AN_EMERGENCY("Создание аварийной ситуации", 400),
    ALCOHOL_DRUNK("Алкогольное опьянение", 500),
    BELT_NOT_FASTENED("Непрестегнутый ремень", 600),
    NO_CHILD_SEAT("Отсутствует детское кресло", 700),
    ;

    private final String value;
    private final int idFine;

    TypeFineEnum(String value, int idFine) {
        this.value = value;
        this.idFine = idFine;
    }

    public String getValue() {
        return value;
    }

    public int getIdFine() {
        return idFine;
    }

    public static String createTypeFines(int typeFine)  {
        String typeString = "";
        switch (typeFine) {
            case 100:
                typeString = "#" + TypeFineEnum.PARKING.getIdFine() + " - " + TypeFineEnum.PARKING.getValue();
                break;
            case 200:
                typeString = "#" + TypeFineEnum.HIGH_SPEED.getIdFine() + " - " + TypeFineEnum.HIGH_SPEED.getValue();
                break;
            case 300:
                typeString = "#" + TypeFineEnum.TECHNICAL_INSPECTION.getIdFine() + " - " + TypeFineEnum.TECHNICAL_INSPECTION.getValue();
                break;
            case 400:
                typeString = "#" + TypeFineEnum.CREATE_AN_EMERGENCY.getIdFine() + " - " + TypeFineEnum.CREATE_AN_EMERGENCY.getValue();
                break;
            case 500:
                typeString = "#" + TypeFineEnum.ALCOHOL_DRUNK.getIdFine() + " - " + TypeFineEnum.ALCOHOL_DRUNK.getValue();
                break;
            case 600:
                typeString = "#" + TypeFineEnum.BELT_NOT_FASTENED.getIdFine() + " - " + TypeFineEnum.BELT_NOT_FASTENED.getValue();
                break;
            case 700:
                typeString = "#" + TypeFineEnum.NO_CHILD_SEAT.getIdFine() + " - " + TypeFineEnum.NO_CHILD_SEAT.getValue();
                break;
        }
        return typeString;
    }
}
