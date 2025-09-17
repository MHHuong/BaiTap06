package vn.host.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.host.entity.Video;
import vn.host.service.VideoService;

@Controller
@RequestMapping("/admin/videos")
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;

    @GetMapping("")
    public String list(@RequestParam(defaultValue="0") int page,
                       @RequestParam(defaultValue="10") int size,
                       ModelMap model) {
        model.addAttribute("page", videoService.findAll(PageRequest.of(page,size, Sort.by("id").descending())));
        return "admin/products/list";
    }

    @GetMapping("/add")
    public String add(ModelMap model){ model.addAttribute("video", new Video()); return "admin/products/add"; }

    @PostMapping("/saveOrUpdate")
    public ModelAndView save(Video video, ModelMap model){
        videoService.save(video);
        return new ModelAndView("redirect:/admin/videos", model);
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, ModelMap model){
        model.addAttribute("video", videoService.findById(id));
        return "admin/products/add";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id, ModelMap model){
        videoService.deleteById(id);
        return new ModelAndView("redirect:/admin/videos", model);
    }

    @GetMapping("/search")
    public String search(@RequestParam(required=false) String q,
                         @RequestParam(defaultValue="0") int page,
                         @RequestParam(defaultValue="10") int size,
                         ModelMap model){
        model.addAttribute("page", videoService.search(q, PageRequest.of(page,size, Sort.by("id").descending())));
        model.addAttribute("q", q);
        return "admin/products/search";
    }
}