package com.task.learning_and_development_service.service;

import com.task.learning_and_development_service.dto.request.CourseRequestDTO;
import com.task.learning_and_development_service.dto.request.UserRequestDTO;
import com.task.learning_and_development_service.mapper.CourseMapper;
import com.task.learning_and_development_service.mapper.UserMapper;
import com.task.learning_and_development_service.model.Course;
import com.task.learning_and_development_service.model.Lecture;
import com.task.learning_and_development_service.model.User;
import com.task.learning_and_development_service.repository.CourseRepository;
import com.task.learning_and_development_service.repository.LectureRepository;
import com.task.learning_and_development_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CourseMapper courseMapper;
    private final CourseRepository courseRepository;
    private final LectureRepository lectureRepository;

    @Override
    public String registerUser(UserRequestDTO userRequestDTO) {
        User user = userMapper.toEntity(userRequestDTO);
        try {
            userRepository.save(user);
        }
        catch (Exception ignored){
            // throw custom exception form here and put message
            return "Failed to Register";
        }

        return "User Registered Successfully";
    }

    @Override
    public String createCourse(CourseRequestDTO courseRequestDTO) {
        long count = 0L;
        try{
            Course course = courseMapper.toEntity(courseRequestDTO);
            course = courseRepository.save(course);

            List<Lecture> lectures = courseMapper.toLectures(courseRequestDTO, course);
            count = lectures.size();
            lectureRepository.saveAll(lectures);
//            count = lectures.stream()
//                        .map(lectureRepository::save)
//                        .count();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Course Registered Successfully with : " + count + " lectures";
    }
}
