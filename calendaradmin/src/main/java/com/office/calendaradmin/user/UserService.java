package com.office.calendaradmin.user;

import com.office.calendaradmin.user.jpa.UserEntity;
import com.office.calendaradmin.user.jpa.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    final private UserRepository userRepository;

    public Map<String, Object> users() {
        log.info("users()");

        Map<String, Object> resultMap = new HashMap<>();

        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDto> users = userEntities.stream()
                .map(UserEntity::toDto)
                .collect(Collectors.toList());

        log.info("users: {}", users);

        resultMap.put("users", users);

        return resultMap;

    }

}
