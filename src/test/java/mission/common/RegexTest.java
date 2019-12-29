package mission.common;

import org.junit.Test;

import javax.validation.constraints.Email;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {


    @Test
    public void 제목_확인 () {
        Pattern pattern = Pattern.compile(Regex.TITLE);
        Matcher matches = pattern.matcher("aaabadfa");
        Matcher matches1 = pattern.matcher("aaa_dfa!!");

        System.out.println(matches.find());
        System.out.println(matches1.find());
    }

    @Test
    public void 이름_확인 () {
        Pattern pattern = Pattern.compile(Regex.NAME);
        Matcher matches = pattern.matcher("aaa");
        Matcher matches1 = pattern.matcher("aaa!!");
        Matcher matches2 = pattern.matcher("aaa_");

        System.out.println(matches.find());
        System.out.println(matches1.find());
        System.out.println(matches2.find());
    }

    @Test
    public void 핸드폰_확인 () {
        Pattern pattern = Pattern.compile(Regex.PHONE);
        Matcher matches = pattern.matcher("01012341234");
        Matcher matches1 = pattern.matcher("010234134a");
        Matcher matches2 = pattern.matcher("012123412341341");

        System.out.println(matches.find());
        System.out.println(matches1.find());
        System.out.println(matches2.find());
    }
}