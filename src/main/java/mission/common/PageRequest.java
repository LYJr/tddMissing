package mission.common;

import org.springframework.data.domain.Sort;

public class PageRequest {
    private static final int DEFAULT_SIZE = 1;
    private static final int MAX_SIZE = 10;

    private int page;
    private int size;
//    private Sort.Direction direction;

    public void page(int page) {
        this.page = page <=0 ? 1: page;
    }

    public void size(int size){
        this.size = size > MAX_SIZE ? DEFAULT_SIZE : size;
    }
    // 사용자는 프로젝트 리스트를 시작일 순, 마감일 순, 목표액 순, 후원액 순으로
    // 정렬해서 볼 수 있습니다.
//    public void setDirection()


}
