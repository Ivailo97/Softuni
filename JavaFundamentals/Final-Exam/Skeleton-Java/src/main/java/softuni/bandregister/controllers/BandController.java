package softuni.bandregister.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.bandregister.bindingModels.BandBindingModel;
import softuni.bandregister.entities.Band;
import softuni.bandregister.repositories.BandRepository;

import java.util.List;

@Controller
public class BandController {
    private final BandRepository bandRepository;

    @Autowired
    public BandController(BandRepository bandRepository) {
        this.bandRepository = bandRepository;
    }


    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {

        modelAndView.setViewName("base-layout");
        modelAndView.addObject("bands", this.bandRepository.findAll());
        modelAndView.addObject("view", "band/index");

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(ModelAndView modelAndView) {
        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view", "band/create");
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(Band band) {
        this.bandRepository.saveAndFlush(band);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(ModelAndView modelAndView,
                             @PathVariable(value = "id") Integer id) {

        Band bandToEdit = this.bandRepository.findById(id).orElse(null);
        modelAndView.setViewName("base-layout");

        if (bandToEdit == null) {


            modelAndView.addObject("bands", this.bandRepository.findAll());
            modelAndView.addObject("view", "band/index");

            return modelAndView;
        }

        modelAndView.addObject("view","band/edit");
        modelAndView.addObject("band",bandToEdit);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") Integer id, BandBindingModel bandBindingModel) {
        Band bandToEdit = this.bandRepository.findById(id).get();
        bandToEdit.setName(bandBindingModel.getName());
        bandToEdit.setMembers(bandBindingModel.getMembers());
        bandToEdit.setGenre(bandBindingModel.getGenre());
        bandToEdit.setHonorarium(bandBindingModel.getHonorarium());
        this.bandRepository.saveAndFlush(bandToEdit);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(ModelAndView modelAndView,
                             @PathVariable(value = "id") Integer id) {
        Band bandToDelete = this.bandRepository.findById(id).orElse(null);

        modelAndView.setViewName("base-layout");
        if (bandToDelete == null) {

            modelAndView.addObject("bands", this.bandRepository.findAll());
            modelAndView.addObject("view", "band/index");

            return modelAndView;
        }

        modelAndView.addObject("view","band/delete");
        modelAndView.addObject("band",bandToDelete);

        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public String delete(Band band) {
        this.bandRepository.delete(band);
        return "redirect:/";
    }
}
