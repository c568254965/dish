package com.huarui.service;

import com.huarui.config.DataDTO;
import com.huarui.dao.DishMapper;
import com.huarui.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sloan on 2019/7/13.
 */

@Service("dishService")
public class DishService {

    @Autowired
    private DishMapper dishMapper;

    public Dish findById(Long id){

        return dishMapper.findById(id);
    }

    public void inDB(DataDTO dto) {

        ArrayList<DataDTO.Data> data = dto.getResult().getData();
        List<Dish> list = new ArrayList<>();

        for (DataDTO.Data datum : data) {
            Dish dish = new Dish();
            dish.setId(Long.valueOf(datum.getId()));
            dish.setAlbums(datum.getAlbums().get(0));
            dish.setBurden(datum.getBurden());
            dish.setImtro(datum.getImtro());
            dish.setIngredients(datum.getIngredients());
            dish.setTags(datum.getTags());
            StringBuilder sb = new StringBuilder();
            for (DataDTO.Steps steps : datum.getSteps()) {
                sb.append(steps.getStep()+",");
            }
            dish.setSteps(sb.toString());
            dish.setTitle(datum.getTitle());

            dishMapper.insert(dish);

            System.out.println(dish.getId()+"~~~");
        }

    }

    public void inDBreturnId() {

        Dish dish = new Dish();
        dish.setTitle("test");
        dishMapper.insert(dish);
        System.out.println(dish.getId()+"自增Id..");
    }
}
