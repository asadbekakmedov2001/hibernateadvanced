package uz.smartup.academy.studentmanagementsystem.service;


import uz.smartup.academy.studentmanagementsystem.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> getAllRewiews();

    ReviewDTO getReviewsById(int id);

    void deleteReviewById(int id);
}
