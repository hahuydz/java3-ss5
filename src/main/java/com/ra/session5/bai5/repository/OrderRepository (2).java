package com.ra.session5.bai5.repository;


import com.ra.bai2.model.Dish;
import org.springframework.stereotype.Repository;
import java.util.Arrays;
import java.util.List;

@Repository("repobai5")
public class OrderRepository {

    public List<Dish> getAvailableDishes() {
        return Arrays.asList(
                new Dish(1L, "Súp Bào Ngư", 500000.0, true),
                new Dish(2L, "Tôm Hùm Bỏ Lò", 1200000.0, true),
                new Dish(3L, "Rượu Vang Đỏ", 850000.0, true)
        );
    }
}
