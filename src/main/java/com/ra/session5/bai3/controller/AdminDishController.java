package com.ra.session5.bai3.controller;

import com.ra.ptit_cntt2_it210_ss5_btvn.bai3.service.AdminDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/bai3")
public class AdminDishController {

    @Autowired
    private AdminDishService adminDishService;

    @GetMapping("/dishes")
    public String list(Model model) {
        model.addAttribute("dishes", adminDishService.getAll());
        return "dish-list";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        return adminDishService.findById(id)
                .map(dish -> {
                    model.addAttribute("dish", dish);
                    return "edit-dish";
                })
                .orElseGet(() -> {
                    ra.addFlashAttribute("error", "Không tìm thấy món ăn yêu cầu!");
                    return "redirect:/bai3/dishes";
                });
    }
}