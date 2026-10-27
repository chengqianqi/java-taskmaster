package org.example.taskmaster.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.taskmaster.entity.Task;
import org.example.taskmaster.mapper.TaskMapper;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskMapper taskMapper;

    public TaskService(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    // 分页 + 条件查询
    public Page<Task> getTasks(int page, int size, String keyword) {
        Page<Task> pageParam = new Page<>(page, size);
        QueryWrapper<Task> queryWrapper = new QueryWrapper<>();

        // 如果有搜索关键字，就按标题或描述模糊查询
        if (keyword != null && !keyword.isEmpty()) {
            queryWrapper.like("title", keyword).or().like("description", keyword);
        }
        queryWrapper.orderByDesc("id"); // 按 id 倒序

        return taskMapper.selectPage(pageParam, queryWrapper);
    }
    // 新增任务
    public void addTask(Task task) {
        if (task.getStatus() == null || task.getStatus().isEmpty()) {
            task.setStatus("TODO"); // 默认状态
        }
        taskMapper.insert(task); // MyBatis-Plus 自带的插入方法
    }
}