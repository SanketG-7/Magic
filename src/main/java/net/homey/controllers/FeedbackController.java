package net.homey.controllers;

import net.homey.models.feedback;
import net.homey.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/submit")
    public feedback submitFeedback(@RequestBody feedback feedback) {
        return feedbackService.submitFeedback(feedback);
    }

    @GetMapping("/all")
    public List<feedback> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }
}
