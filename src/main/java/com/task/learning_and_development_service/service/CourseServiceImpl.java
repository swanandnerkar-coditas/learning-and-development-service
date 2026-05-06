package com.task.learning_and_development_service.service;

import com.task.learning_and_development_service.dto.request.CourseRequestDTO;
import com.task.learning_and_development_service.mapper.CourseMapper;
import com.task.learning_and_development_service.model.Course;
import com.task.learning_and_development_service.model.Lecture;
import com.task.learning_and_development_service.repository.CourseRepository;
import com.task.learning_and_development_service.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseMapper courseMapper;
    private final CourseRepository courseRepository;
    private final LectureRepository lectureRepository;

    @Override
    public String createCourse(CourseRequestDTO courseRequestDTO) {
        long count;
        try{
            Course course = courseMapper.toEntity(courseRequestDTO);
            course = courseRepository.save(course);

            List<Lecture> lectures = courseMapper.toLectures(courseRequestDTO, course);
            count = lectures.size();
            lectureRepository.saveAll(lectures);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Course Registered Successfully with : " + count + " lectures";
    }
}
