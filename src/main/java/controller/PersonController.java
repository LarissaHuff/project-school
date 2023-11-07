package controller;

import com.projectschool.dto.DtoPerson;
import com.projectschool.model.Person;
import com.projectschool.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping
    @Transactional
    public void register(@RequestBody DtoPerson dtoPerson){
        personService.registerPerson(dtoPerson);
    }

    @GetMapping
    public List<Person> getAll(){
       return personService.getAll();
    }

    @GetMapping
    public List<Person> getByName(@RequestParam String name){
        return personService.getByName(name);
    }

    @GetMapping
    public Person getById(@RequestParam Long id){
        return personService.getByid(id);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id){
        personService.deleteById(id);
    }
}
