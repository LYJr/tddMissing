package mission.common;

public class Regex {
    //한글,숫자,영문 50자 이내
    //특수문자 불허
    public static final String TITLE = "^[a-zA-Z가-힣0-9]+$";

    //한글,숫자,영문 20자 이내
    //특수문자 불허, 단, '_'(underbar) 허용
    public static final String NAME = "^[a-zA-Z가-힣0-9_]+$";

    //핸드폰 양식
    public static final String PHONE = "^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$";

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final long START_PROJECT = 0;

    public static final long AMOUNT = 100000000;

    public static final long SPONSOR = 100000;

    public static final int PAGE_LIMIT = 10;
}
