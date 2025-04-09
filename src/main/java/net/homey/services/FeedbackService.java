package net.homey.services;

import net.homey.models.feedback;
import net.homey.respositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public feedback submitFeedback(feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public List<feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }
}
