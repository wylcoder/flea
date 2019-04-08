package com.flea.controller.portal;

import com.flea.pojo.GoodsInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {

    @RequestMapping(value = "/display.do")
    public List<GoodsInfo> displayGoods(@RequestParam("pageIndex") int pageIndex, @RequestParam("pageSize") int pageSize, @RequestParam("userPosition") HashMap userPosition){

    }
}
