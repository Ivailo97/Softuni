package todoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import todoList.bindingModel.TaskBindingModel;
import todoList.entity.Task;
import todoList.repository.TaskRepository;

@Controller
public class TaskController {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {

        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {

        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view", "task/index");
        modelAndView.addObject("tasks", this.taskRepository.findAll());
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

        if (task.getComments().isEmpty() || task.getTitle().isEmpty()) {
            return "redirect:/";
        }
        this.taskRepository.saveAndFlush(task);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id, ModelAndView modelAndView) {

        Task oldTask = this.taskRepository.findById(id).orElse(null);

        if (oldTask == null) {

            modelAndView.setViewName("base-layout");
            modelAndView.addObject("view", "task/index");
            modelAndView.addObject("tasks", this.taskRepository.findAll());
            return modelAndView;
        }

        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view", "task/edit");
        modelAndView.addObject("task", oldTask);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, TaskBindingModel taskBindingModel) {

        Task oldTask = this.taskRepository.findById(id).orElse(null);

        if (oldTask == null) {

            return "redirect:/";
        }

        oldTask.setComments(taskBindingModel.getComments());
        oldTask.setTitle(taskBindingModel.getTitle());
        this.taskRepository.saveAndFlush(oldTask);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView toDelete(@PathVariable Integer id, ModelAndView modelAndView) {

        Task oldTask = this.taskRepository.findById(id).orElse(null);

        if (oldTask == null) {

            modelAndView.setViewName("base-layout");
            modelAndView.addObject("view", "task/index");
            modelAndView.addObject("tasks", this.taskRepository.findAll());
            return modelAndView;
        }

        modelAndView.setViewName("base-layout");
        modelAndView.addObject("task", oldTask);
        modelAndView.addObject("view", "task/delete");
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {

        Task oldTask = this.taskRepository.findById(id).get();
        this.taskRepository.deleteById(id);
        return "redirect:/";
    }
}
