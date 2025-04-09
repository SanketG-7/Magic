package net.homey.services;

import net.homey.models.Review;
import net.homey.respositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // View all reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Reply to a review
    public Review replyToReview(Long reviewId, String reply) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);
        if (optionalReview.isPresent()) {
            Review review = optionalReview.get();
            review.setReply(reply);
            return reviewRepository.save(review);
        }
        return null; // Handle case when review is not found
    }
}
