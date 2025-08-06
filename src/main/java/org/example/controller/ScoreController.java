package org.example.controller;

import org.example.pojo.User;
import org.example.mapper.UserRankMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ScoreController {

    private final UserRankMapper userRankMapper;

    public ScoreController(UserRankMapper userRankMapper) {
        this.userRankMapper = userRankMapper;
    }

    @GetMapping("/scores")
    public List<User> getRanking() {
        return userRankMapper.selectAllOrderByScoreDesc();
    }
}