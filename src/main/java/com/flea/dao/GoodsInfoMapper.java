package com.flea.dao;

import com.flea.pojo.GoodsInfo;

public interface GoodsInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flea_goods_info
     *
     * @mbg.generated Sat Mar 30 18:13:01 CST 2019
     */
    int deleteByPrimaryKey(String goodsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flea_goods_info
     *
     * @mbg.generated Sat Mar 30 18:13:01 CST 2019
     */
    int insert(GoodsInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flea_goods_info
     *
     * @mbg.generated Sat Mar 30 18:13:01 CST 2019
     */
    int insertSelective(GoodsInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flea_goods_info
     *
     * @mbg.generated Sat Mar 30 18:13:01 CST 2019
     */
    GoodsInfo selectByPrimaryKey(String goodsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flea_goods_info
     *
     * @mbg.generated Sat Mar 30 18:13:01 CST 2019
     */
    int updateByPrimaryKeySelective(GoodsInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flea_goods_info
     *
     * @mbg.generated Sat Mar 30 18:13:01 CST 2019
     */
    int updateByPrimaryKey(GoodsInfo record);
}