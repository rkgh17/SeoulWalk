package com.human.seoulroad.answer;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.human.seoulroad.question.Question;
import com.human.seoulroad.user.SiteUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {
	
	private final AnswerRepository answerRepository;

	// 답변 생성 매서드
    public Answer create(Question question, String content, SiteUser author) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        answer.setAuthor(author);
        this.answerRepository.save(answer);
        return answer;
    }
}
