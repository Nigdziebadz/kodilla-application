package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTestSuite {

    TaskMapper taskMapper = new TaskMapper();
    Task task = new Task(1L, "title", "test content");
    Task task1 = new Task(2L, "second title", "second test content");
    TaskDto taskDto = new TaskDto(1L, "title", "test content");


    @Test
    public void shouldMapToTask() {
        //Given
        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(Long.valueOf(1), task.getId());
        assertEquals("title", task.getTitle());
        assertEquals("test content", task.getContent());
    }

    @Test
    public void shouldMapToTaskDto() {
        //Given
        //When
        TaskDto task = taskMapper.mapToTaskDto(task1);

        //Then
        assertEquals(Long.valueOf(2), task.getId());
        assertEquals("second title", task.getTitle());
        assertEquals("second test content", task.getContent());
    }

    @Test
    public void shouldMapToTaskDtoList() {
        //Given
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        tasks.add(task1);

        //When
        List<TaskDto> task = taskMapper.mapToTaskDtoList(tasks);

        //Then
        assertEquals(2, task.size());
    }
}
