package az.edu.turing.userproject.service.impl;

import az.edu.turing.userproject.domain.dto.UserDto;
import az.edu.turing.userproject.domain.entity.User;
import az.edu.turing.userproject.domain.repository.UserRepository;
import az.edu.turing.userproject.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public void save(UserDto userDto) {
        User user = User.builder().
                id(userDto.getId()).
                username(userDto.getUsername()).
                age(userDto.getAge()).
                creatAt(userDto.getCreatAt()).
                updateAt(userDto.getUpdateAt()).
                profilePhoto(userDto.getProfilePhoto())
                .build();
        userRepository.save(user);

    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();

    }

    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UserDto> findById(UUID id) {
        return userRepository.findById(id).map(this::convertToDto);
    }

    @Override
    public UserDto update(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).orElse(null);
        user.setUsername(userDto.getUsername());
        user.setAge(userDto.getAge());
        user.setUpdateAt(new Date());
        user.setProfilePhoto(userDto.getProfilePhoto());
        User updateUser = userRepository.save(user);
        return convertToDto(updateUser);
    }

    @Override
    public UserDto updateAge(UserDto userDto, UUID id) {
        User user = userRepository.findById(id).orElse(null);
        user.setAge(userDto.getAge());
        user.setUpdateAt(new Date());
        User updateUser = userRepository.save(user);

        return convertToDto(updateUser);
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    private UserDto convertToDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getAge(),
                user.getCreatAt(),
                user.getUpdateAt(),
                user.getProfilePhoto()
        );
    }
}
