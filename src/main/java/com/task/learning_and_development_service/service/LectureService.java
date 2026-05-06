package com.task.learning_and_development_service.service;

public interface LectureService {
    String startLecture(Long employeeId, Long lectureId);

    String markAsCompleteLecture(Long employeeId, Long lectureId);
}
