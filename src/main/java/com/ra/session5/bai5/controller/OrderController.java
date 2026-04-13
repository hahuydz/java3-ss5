package com.ra.session5.bai5.controller;

import com.ra.bai2.model.Dish;
import com.ra.bai5.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller("smartOrderControllerBai5")
@RequestMapping("/bai5")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public String showOrderPage(Model model) {
        List<Dish> menu = orderService.getMenu();
        double subTotal = orderService.calculateTotal(menu);
        double tax = orderService.calculateTax(subTotal);

        model.addAttribute("menu", menu);
        model.addAttribute("subTotal", subTotal);
        model.addAttribute("tax", tax);
        model.addAttribute("total", subTotal + tax);

        return "smart-order";
    }
}
