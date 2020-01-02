package mission.common;

import org.junit.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegexTest {


    @Test
    public void 제목_성공() {
        Pattern pattern = Pattern.compile(Regex.TITLE);
        Matcher matches = pattern.matcher("aaabadfa");

        assertThat(matches.find()).isEqualTo(true);
    }

    @Test
    public void 제목_실패() {
        Pattern pattern = Pattern.compile(Regex.TITLE);
        Matcher matches = pattern.matcher("aaa_dfa!!");

        assertThat(matches.find()).isEqualTo(false);
    }

    @Test
    public void 이름_성공() {
        Pattern pattern = Pattern.compile(Regex.NAME);
        Matcher matches = pattern.matcher("aaa");
        Matcher matches1 = pattern.matcher("aaa123");
        Matcher matches2 = pattern.matcher("aaa_");

        assertThat(matches.find()).isEqualTo(true);
        assertThat(matches1.find()).isEqualTo(true);
        assertThat(matches2.find()).isEqualTo(true);
    }

    @Test
    public void 이름_실패() {
        Pattern pattern = Pattern.compile(Regex.NAME);
        Matcher matches = pattern.matcher("aaa!!");

        assertThat(matches.find()).isEqualTo(false);
    }

    @Test
    public void 핸드폰_성공() {
        Pattern pattern = Pattern.compile(Regex.PHONE);
        Matcher matches = pattern.matcher("01012341234");

        assertThat(matches.find()).isEqualTo(true);
    }

    @Test
    public void 핸드폰_실패() {
        Pattern pattern = Pattern.compile(Regex.PHONE);
        Matcher matches = pattern.matcher("010234134a");
        Matcher matches1 = pattern.matcher("012123412341341");

        assertThat(matches.find()).isEqualTo(false);
        assertThat(matches1.find()).isEqualTo(false);
    }
}