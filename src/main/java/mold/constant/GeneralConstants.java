package mold.constant;

public class GeneralConstants {
    public static final GeneralConstants INSTANCE = new GeneralConstants();
    public static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public GeneralConstants() {
        //Defeat Instantiation
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
