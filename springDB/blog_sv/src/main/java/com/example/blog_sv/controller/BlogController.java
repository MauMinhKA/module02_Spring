package com.example.blog_sv.controller;

import com.example.blog_sv.model.BlogSV;
import com.example.blog_sv.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/")
    public ModelAndView getAllBlog() {
        return new ModelAndView("blog/index", "blog", blogService.getAllBlogSvs());
    }

    @GetMapping("/blog/view/{id}")
    public ModelAndView view(@PathVariable Long id) {
        return new ModelAndView("blog/view", "blog", blogService.getBlogSvById(id));
    }

    @GetMapping("/blog/create")
    public ModelAndView getCreateProduct() {
        return new ModelAndView("blog/create", "blog", new BlogSV());
    }

    //    @GetMapping("/blog/create")
//    public String create(Model model) {
//        model.addAttribute("blog", new BlogSV());
//        return "create";
//    }
    @PostMapping("blog/save")
    public String save(BlogSV blogSV, RedirectAttributes redirect) {
        blogSV.setId((long) (Math.random() * 100));
        blogService.saveBlogSv(blogSV);
        redirect.addFlashAttribute("message", "Create blogs successfully!");
        return "redirect:/";
    }

    @GetMapping("blog/delete/{id}")
    public String deleteBlog(@PathVariable Long id, RedirectAttributes redirect) {
        blogService.deleteBlogSvById(id);
        redirect.addFlashAttribute("message", "Delete blogs successfully!");
        return "redirect:/";
    }

    @GetMapping("blog/edit/{id}")
    public ModelAndView editBlog(@PathVariable Long id) {
        return new ModelAndView("/blog/edit", "blog", blogService.getBlogSvById(id));
    }
    @PostMapping("blog/update")
    public String updateBlog(BlogSV blogSV,RedirectAttributes redirect){
        blogService.updateBlogSv(blogSV.getId(),blogSV);
        redirect.addFlashAttribute("message", "Update blogs successfully!");
        return "redirect:/";
    }


}
