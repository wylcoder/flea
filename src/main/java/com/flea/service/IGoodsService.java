package com.flea.service;

import com.flea.pojo.GoodsInfo;

import java.util.HashMap;

public interface IGoodsService {
    List<GoodsInfo> displayGoods(int pageIndex, int pageSize, HashMap userPosition);
}
