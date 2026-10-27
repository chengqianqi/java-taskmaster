package org.example.taskmaster.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.taskmaster.entity.Task;

@Mapper
public interface TaskMapper extends BaseMapper<Task> {
    // 继承 BaseMapper 后，自动拥有了增删改查所有单表方法
}