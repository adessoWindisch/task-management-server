package de.adesso.pdd.taskmanagement.service.impl;

import de.adesso.pdd.taskmanagement.dto.EmployeeDto;
import de.adesso.pdd.taskmanagement.dto.TaskDto;
import de.adesso.pdd.taskmanagement.dto.TaskStatusDto;
import de.adesso.pdd.taskmanagement.entity.Employee;
import de.adesso.pdd.taskmanagement.entity.Task;
import de.adesso.pdd.taskmanagement.entity.TaskStatus;
import de.adesso.pdd.taskmanagement.exception.ResourceAlreadyExistsException;
import de.adesso.pdd.taskmanagement.exception.ResourceNotFoundException;
import de.adesso.pdd.taskmanagement.mapper.EmployeesMapper;
import de.adesso.pdd.taskmanagement.mapper.TasksMapper;
import de.adesso.pdd.taskmanagement.repository.EmployeesRepository;
import de.adesso.pdd.taskmanagement.repository.TasksRepository;
import de.adesso.pdd.taskmanagement.service.IEmployeesService;
import de.adesso.pdd.taskmanagement.service.ITasksService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TasksService implements ITasksService {

    private TasksRepository tasksRepository;

    private static final String TASK = "Task";
    private static final String TASKID = "TaskId";

    @Override
    public TaskDto addTask(TaskDto taskDto) {
        Task task = TasksMapper.toTask(taskDto);
        Optional<Task> optionalTask = tasksRepository.findByTaskId(taskDto.getTaskId());

        if (optionalTask.isPresent()) {
            throw new ResourceAlreadyExistsException("Task already registered with given task id " + task.getTaskId());
        }

        Task savedTask = tasksRepository.save(task);
        TaskDto savedTaskDto = TasksMapper.toTaskDto(savedTask);

        return savedTaskDto;
    }

    @Override
    public boolean updateTask(TaskDto taskDto) {
        boolean isUpdated = false;
        Optional<Task> optionalTask = tasksRepository.findByTaskId(taskDto.getTaskId());

        if (optionalTask.isEmpty()) {
            throw new ResourceNotFoundException(TASK, TASKID, String.valueOf(taskDto.getTaskId()));
        }

        Task givenTask = TasksMapper.toGivenTask(optionalTask.get(), taskDto);
        Task updatedTask = tasksRepository.save(givenTask);
        isUpdated = true;
        return isUpdated;
    }

    @Override
    public boolean deleteTaskById(long id) {
        Task task = tasksRepository.findByTaskId(id).orElseThrow(
                () -> new ResourceNotFoundException(TASK, TASKID, String.valueOf(id)));

        tasksRepository.delete(task);
        return true;
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> tasks = tasksRepository.findAll();

        List<TaskDto> tasksDto = tasks.stream()
                .map(task -> TasksMapper.toTaskDto(task))
                .collect(Collectors.toList());

        return tasksDto;
    }

    @Override
    public List<TaskDto> getTasksByEmployeeId(long employeeId) {
        List<Task> tasks = tasksRepository.findByEmployeeId(employeeId);

        List<TaskDto> tasksDto = tasks.stream()
                .map(task -> TasksMapper.toTaskDto(task))
                .collect(Collectors.toList());

        return tasksDto;
    }

    @Override
    public TaskDto getTaskById(long id) {
        Task task = tasksRepository.findByTaskId(id).orElseThrow(
                () -> new ResourceNotFoundException(TASK, TASKID, String.valueOf(id)));

        TaskDto taskDto = TasksMapper.toTaskDto(task);
        return taskDto;
    }


    @Override
    public boolean updateTaskStatus(long taskId, TaskStatusDto status) {
        Optional<Task> taskOptional = tasksRepository.findById(taskId);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setStatus(status.getStatus());
            tasksRepository.save(task);
            return true;
        } else {
            throw new ResourceNotFoundException(TASK, TASKID, String.valueOf(taskId));
        }
    }

    public long calculateDaysBetweenDates(String startDate, String endDate) {
        long daysBetween = 0;
        try {
            Optional<LocalDate> startOptional = parseDate(startDate);
            Optional<LocalDate> endOptional = parseDate(endDate);

            if (startOptional.isPresent() && endOptional.isPresent()) {
                LocalDate start = startOptional.get();
                LocalDate end = endOptional.get();
                daysBetween = calculateDays(start, end);
            } else {
                throw new IllegalArgumentException("One of the dates could not be parsed");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("An error occurred while calculating days between dates: " + e.getMessage(), e);
        }
        return daysBetween;
    }

    protected Optional<LocalDate> parseDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            LocalDate parsedDate = LocalDate.parse(date, formatter);
            return Optional.of(parsedDate);
        } catch (DateTimeParseException e) {
            return Optional.empty();
        }
    }

    protected long calculateDays(LocalDate start, LocalDate end) {
        try {
            return ChronoUnit.DAYS.between(start, end);
        } catch (Exception e) {
            throw new IllegalArgumentException("An error occurred while calculating the difference in days: " + e.getMessage(), e);
        }
    }
}
