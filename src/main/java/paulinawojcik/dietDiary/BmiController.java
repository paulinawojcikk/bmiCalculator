package paulinawojcik.dietDiary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class BmiController {

    @Autowired
    private UserDao userDao;
    private User user;


    @GetMapping("/")
    public String home() {
        return "hello";
    }


    @RequestMapping("/login")
    public String login() {
        return "login";
    }



    @GetMapping("/add")
    public String addNew(@ModelAttribute User user, ModelMap modelMap) {
        modelMap.put("weight",user.getWeight());
        modelMap.put("height",user.getHeight());
        modelMap.put("bmi",user.indexBmi());
        modelMap.put("info",user.info(user.indexBmi()));
        return "add";
    }


    @GetMapping("/all")
    public String all(ModelMap modelMap) {
        modelMap.put("scores", userDao.findAll());
        return "all";
    }

    @GetMapping("/result")
    public String add(@ModelAttribute User user,ModelMap modelMap){
        userDao.save(user);
        return "redirect:/all";
    }
}
