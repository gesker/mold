package mold.constant;


public class LoginCodes implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	public static final LoginCodes INSTANCE = new LoginCodes();
    public static final int LOGIN_CODE_SUCCESS = 1;
    public static final int LOGIN_CODE_FAIL_ACCOUNT_DISABLED = 2;
    public static final int LOGIN_CODE_FAIL_PASSWORD = 3;
    public static final int LOGIN_CODE_FAIL_USERNAME = 4;
    public static final int LOGIN_CODE_LOGOUT = 5;
    public static final int LOGIN_CODE_TIMEOUT = 6;


    public LoginCodes() {
        //Defeat Instantiation
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
