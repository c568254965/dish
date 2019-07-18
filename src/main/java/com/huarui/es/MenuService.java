package com.huarui.es;

import com.huarui.es.repository.MenuRepository;
import com.huarui.es.type.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sloan on 2019/7/15.
 */

@Service
public class MenuService {

    @Autowired
    MenuRepository menuRepository;

    public List<Menu> selectByName(String name){

        return  menuRepository.findMenuByStepsAndTitle("适量盐","羊肉");
    }
}
