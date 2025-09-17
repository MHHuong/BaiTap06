package vn.host.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.host.entity.Category;
import vn.host.service.CategoryService;

@Controller
@RequestMapping("/admin/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("")
    public String list(@RequestParam(defaultValue="0") int page,
                       @RequestParam(defaultValue="10") int size,
                       ModelMap model) {
        Page<Category> p = categoryService.findAll(PageRequest.of(page, size, Sort.by("id").descending()));
        model.addAttribute("page", p);
        return "admin/categories/list";
    }

    @GetMapping("/add")
    public String add(ModelMap model) {
        model.addAttribute("category", new Category());
        return "admin/categories/add";
    }

    @PostMapping("/saveOrUpdate")
    public ModelAndView save(Category category, ModelMap model) {
        categoryService.save(category);
        model.addAttribute("message","Saved!");
        return new ModelAndView("redirect:/admin/categories", model);
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, ModelMap model) {
        model.addAttribute("category", categoryService.findById(id));
        return "admin/categories/add";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Integer id, ModelMap model) {
        model.addAttribute("category", categoryService.findById(id));
        return "admin/categories/view";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Integer id, ModelMap model) {
        categoryService.deleteById(id);
        model.addAttribute("message","Category is deleted!");
        return new ModelAndView("redirect:/admin/categories", model);
    }

    @GetMapping("/search")
    public String search(@RequestParam(required=false) String name,
                         @RequestParam(defaultValue="0") int page,
                         @RequestParam(defaultValue="10") int size,
                         ModelMap model) {
        Page<Category> p = categoryService.search(name, PageRequest.of(page, size, Sort.by("id").descending()));
        model.addAttribute("page", p);
        model.addAttribute("name", name);
        return "admin/categories/search";
    }
}