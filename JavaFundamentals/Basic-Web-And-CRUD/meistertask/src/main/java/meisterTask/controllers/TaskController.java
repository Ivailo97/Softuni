package meisterTask.controllers;
import meisterTask.BindingModels.TaskBindingModel;
import meisterTask.entities.Task;
import meisterTask.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TaskController {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {

        List<Task> openTasks = this.taskRepository.findAllByStatus("Open");
        List<Task> finishedTasks = this.taskRepository.findAllByStatus("Finished");
        List<Task> inProgressTasks = this.taskRepository.findAllByStatus("In Progress");

        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view", "task/index");
        modelAndView.addObject("openTasks", openTasks);
        modelAndView.addObject("finishedTasks", finishedTasks);
        modelAndView.addObject("inProgressTasks", inProgressTasks);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(ModelAndView modelAndView) {
        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view", "task/create");
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(Task task) {

        if (task.getStatus().isEmpty() || task.getTitle().isEmpty()){

            return "redirect:/";
        }

        this.taskRepository.saveAndFlush(task);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(ModelAndView modelAndView,
                             @PathVariable(value = "id") Integer id) {

        Task taskToEdit = this.taskRepository.findById(id).get();
        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view", "task/edit");
        modelAndView.addObject("task", taskToEdit);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String edit(TaskBindingModel taskBindingModel,
                       @PathVariable(value = "id") Integer id) {

        Task taskToEdit = this.taskRepository.findById(id).get();
        taskToEdit.setStatus(taskBindingModel.getStatus());
        taskToEdit.setTitle(taskBindingModel.getTitle());
        this.taskRepository.saveAndFlush(taskToEdit);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(ModelAndView modelAndView,
                               @PathVariable(value = "id") Integer id) {

        Task taskToDelete = this.taskRepository.findById(id).get();
        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view", "task/delete");
        modelAndView.addObject("task", taskToDelete);
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public String delete(Task task) {

        this.taskRepository.delete(task);
        return "redirect:/";
    }
}
