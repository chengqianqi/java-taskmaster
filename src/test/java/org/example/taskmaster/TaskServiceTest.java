package org.example.taskmaster;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.taskmaster.entity.Task;
import org.example.taskmaster.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @Test
    void testPagination() {
        Page<Task> page = taskService.getTasks(1, 10, null);
        System.out.println("============= 分页查询结果 =============");
        System.out.println("总条数: " + page.getTotal());
        for (Task task : page.getRecords()) {
            System.out.println("任务标题: " + task.getTitle() + " | 状态: " + task.getStatus());
        }
    }
}