package net.homey.controllers;

import net.homey.models.Review;
import net.homey.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // View all reviews
    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    // Reply to a review
    @PostMapping("/{reviewId}/reply")
    public Review replyToReview(@PathVariable Long reviewId, @RequestParam String reply) {
        return reviewService.replyToReview(reviewId, reply);
    }
}
