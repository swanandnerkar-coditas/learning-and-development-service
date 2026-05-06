package com.task.learning_and_development_service.service;

import com.task.learning_and_development_service.dto.request.EmployeeRequestDTO;
import com.task.learning_and_development_service.model.EmployeeDetails;
import com.task.learning_and_development_service.model.User;
import com.task.learning_and_development_service.repository.EmployeeDetailsRepository;
import com.task.learning_and_development_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeDetailsRepository employeeDetailsRepository;
    private final UserRepository userRepository;

    @Override
    public String registerEmployeeDetails(EmployeeRequestDTO employeeRequestDTO) {

        User user = userRepository.findById(employeeRequestDTO.getUserId())
                        .orElseThrow(()-> new UsernameNotFoundException("User not found for provided Id"));
        try {
            EmployeeDetails employeeDetails = EmployeeDetails.builder()
                    .employeeStatus(employeeRequestDTO.getEmployeeStatus())
                    .enrolledStatus(employeeRequestDTO.getEnrolledStatus())
                    .user(user)
                    .build();

            employeeDetailsRepository.save(employeeDetails);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Employee Details Saved Successfully";
    }
}
