package com.sof_eng.Mapper;

import com.sof_eng.model.Feedback;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FeedbackMapper {
    void addFeedback(Feedback feedback);
}
