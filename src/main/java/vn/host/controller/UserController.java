package vn.host.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.host.entity.User;
import vn.host.service.UserService;

@Controller
@RequestMapping("/admin/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public String list(@RequestParam(defaultValue="0") int page,
                       @RequestParam(defaultValue="10") int size,
                       ModelMap model) {
        model.addAttribute("page", userService.findAll(PageRequest.of(page,size, Sort.by("id").descending())));
        return "admin/accounts/list";
    }

    @GetMapping("/add")
    public String add(ModelMap model){ model.addAttribute("user", new User()); return "admin/accounts/add"; }

    @PostMapping("/saveOrUpdate")
    public ModelAndView save(User user, ModelMap model){
        userService.save(user);
        return new ModelAndView("redirect:/admin/users", model);
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, ModelMap model){
        model.addAttribute("user", userService.findById(id));
        return "admin/accounts/add";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id, ModelMap model){
        userService.deleteById(id);
        return new ModelAndView("redirect:/admin/users", model);
    }

    @GetMapping("/search")
    public String search(@RequestParam(required=false) String q,
                         @RequestParam(defaultValue="0") int page,
                         @RequestParam(defaultValue="10") int size,
                         ModelMap model){
        model.addAttribute("page", userService.search(q, PageRequest.of(page,size, Sort.by("id").descending())));
        model.addAttribute("q", q);
        return "admin/accounts/search";
    }
}