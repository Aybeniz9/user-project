package az.edu.turing.userproject.service;

import java.util.List;

import az.edu.turing.userproject.domain.dto.UserDto;
import az.edu.turing.userproject.domain.dto.UserDto;
import az.edu.turing.userproject.domain.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface  UserService {
    void  save(UserDto userDto);
    List<UserDto> findAll();
    void  deleteAll();
    void deleteById(UUID id);
    Optional<UserDto> findById(UUID id);
    UserDto update(UserDto userDto);
    UserDto updateAge(UserDto userDto, UUID id);
    long count();



//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    public void createUser(UserDto userDto) {
//        String sql = "INSERT INTO user1 (id, username, age, creat_at, update_at, profile_photo) VALUES (?, ?, ?, ?, ?, ?)";
//        jdbcTemplate.update(sql, UUID.randomUUID(), userDto.getUsername(), userDto.getAge(), userDto.getCreatAt(), userDto.getUpdateAt(), userDto.getProfilePhoto());
//    }
//
//    public List<UserDto> getAllUsers() {
//        String sql = "SELECT * FROM user1";
//        return jdbcTemplate.query(sql, new UserRowMapper());
//    }
//
//    public UserDto getUserById(UUID id) {
//        String sql = "SELECT * FROM user1 WHERE id = ?";
//        return jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
//    }
//
//    public void deleteUser(UUID id) {
//        String sql = "DELETE FROM user1 WHERE id = ?";
//        jdbcTemplate.update(sql, id);
//    }
//
//    private static class UserRowMapper implements RowMapper<UserDto> {
//        @Override
//        public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
//            return new UserDto(
//                    UUID.fromString(rs.getString("id")),
//                    rs.getString("username"),
//                    rs.getInt("age"),
//                    rs.getDate("creat_at"),
//                    rs.getDate("update_at"),
//                    rs.getBytes("profile_photo")
//            );
//        }
//    }
}

