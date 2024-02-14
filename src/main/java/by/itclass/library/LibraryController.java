package by.itclass.library;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LibraryController {
    private LibraryRepository repository;

    @Autowired

    public void setRepository(LibraryRepository repository) {
        this.repository = repository;
    }

   // @GetMapping(value = "/") одно и тоже, но один раз
    @GetMapping
    public String getAll(Model model){
        var libraries = repository.findAll();
        model.addAttribute("libraries",libraries);
        return "index";
    }

    @GetMapping(value = "/view/{id}")
    public String view (
            @PathVariable(name = "id") int id,
            Model model){
        var library = repository.findById(id).get();// нашлт библиотеку
        model.addAttribute("library", library);
        return "library";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable(name = "id") int id){
        repository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping(value = "/add")
    public ModelAndView add(){
        return new ModelAndView("add-library","library",new Library());
    }

    @PostMapping("/save")
    public String save(@ModelAttribute(name = "library") Library library){
        repository.save(library);
        return "redirect:/";
    }

    @GetMapping(value = "/update/{id}")
    public ModelAndView update(@PathVariable("id")int id){
        var library = repository.findById(id).get();
        return new ModelAndView("upd-library","library", library);
    }
}
