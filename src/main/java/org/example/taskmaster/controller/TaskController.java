package org.example.taskmaster.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.validation.Valid; // 新加的
import org.example.taskmaster.entity.Task;
import org.example.taskmaster.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult; // 新加的
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "1") int page,
                        @RequestParam(defaultValue = "5") int size,
                        @RequestParam(required = false) String keyword,
                        Model model) {

        System.out.println("查询参数: " + keyword);

        Page<Task> taskPage = taskService.getTasks(page, size, keyword);
        model.addAttribute("page", taskPage);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    // === 下面是新增的代码 ===

    // 1. 跳转到新增页面
    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("task", new Task()); // 空对象供表单绑定
        return "add";
    }

    // 2. 处理表单提交（带校验）
    @PostMapping("/add")
    public String addTask(@Valid Task task, BindingResult result) {
        // 如果校验不通过，打回原页面
        if (result.hasErrors()) {
            return "add";
        }
        taskService.addTask(task);
        return "redirect:/"; // 保存成功，重定向回首页
    }
}