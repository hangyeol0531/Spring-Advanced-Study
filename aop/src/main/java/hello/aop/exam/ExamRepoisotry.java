package hello.aop.exam;

import org.springframework.stereotype.Repository;

@Repository
public class ExamRepoisotry {

    private static int seq = 0;

    /**
     * 5번에 1번 실패
     */
    public String save(String itemId) {
        seq++;
        if (seq % 5 == 0) {
            throw new IllegalStateException("exception!!");
        }
        return "ok";
    }
}
