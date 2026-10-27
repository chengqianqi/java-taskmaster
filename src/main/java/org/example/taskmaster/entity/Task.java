package org.example.taskmaster.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import jakarta.validation.constraints.NotBlank; // 新加的
import lombok.Data;

@Data
public class Task {
    @TableId(type = IdType.AUTO)
    private Long id;

    @NotBlank(message = "任务标题不能为空！") // 新加的校验注解
    private String title;

    private String description;
    private String status;
}