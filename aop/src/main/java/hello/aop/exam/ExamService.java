package hello.aop.exam;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final ExamRepoisotry examRepoisotry;

    public void request(String itemId) {
        examRepoisotry.save(itemId);
    }
}
