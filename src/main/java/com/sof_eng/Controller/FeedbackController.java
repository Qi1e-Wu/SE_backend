package com.sof_eng.Controller;

import com.sof_eng.Mapper.FeedbackMapper;
import com.sof_eng.Mapper.UserMapper;
import com.sof_eng.Util.JwtTokenUtil;
import com.sof_eng.model.CommonResult;
import com.sof_eng.model.Feedback;
import com.sof_eng.model.User;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "历史记录接口")
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserMapper userMapper;
    @PostMapping("/add")
    public CommonResult<?> getAllUser(@RequestHeader("Authorization") String authHeader, @RequestParam("message") String message) {
        // 解析Authorization请求头中的JWT令牌 Bearer access_token
        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        User foundUser = userMapper.getUserByName(username);
        System.out.println(foundUser);
        Feedback feedback = new Feedback();
        feedback.setId(Math.toIntExact(foundUser.getId()));
        feedback.setMessage(message);
        feedback.setEmail(foundUser.getEmail());
        feedback.setUsername(foundUser.getUsername());
        feedbackMapper.addFeedback(feedback);
        return CommonResult.success(feedback);
    }
}
