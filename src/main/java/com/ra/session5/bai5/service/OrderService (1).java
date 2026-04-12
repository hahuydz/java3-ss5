package com.ra.session5.bai5.service;

import com.ra.ptit_cntt2_it210_ss5_btvn.bai2.model.Dish;
import com.ra.ptit_cntt2_it210_ss5_btvn.bai5.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("SVbai5")
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<Dish> getMenu() {
        return repository.getAvailableDishes();
    }

    public double calculateTotal(List<Dish> items) {
        return items.stream().mapToDouble(Dish::getPrice).sum();
    }

    public double calculateTax(double subTotal) {
        return subTotal * 0.1;
    }
}