package com.task.learning_and_development_service.controller;

import com.task.learning_and_development_service.dto.request.EnrollCourseRequestDTO;
import com.task.learning_and_development_service.dto.response.ApplicationResponse;
import com.task.learning_and_development_service.service.LectureService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/lecture")
@RequiredArgsConstructor
public class LectureController {

    private final LectureService lectureService;

    @PostMapping("/start")
    ResponseEntity<ApplicationResponse<String>> startLecture(@RequestParam Long employeeId, @RequestParam Long lectureId){
        ApplicationResponse<String> response = new ApplicationResponse<>(lectureService.startLecture(employeeId, lectureId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/complete")
    ResponseEntity<ApplicationResponse<String>> markAsCompleteLecture(@RequestParam Long employeeId, @RequestParam Long lectureId){
        ApplicationResponse<String> response = new ApplicationResponse<>(lectureService.markAsCompleteLecture(employeeId, lectureId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
