package com.Jenna.eshop.commondity.service.impl;

import com.Jenna.eshop.common.util.DateProvider;
import com.Jenna.eshop.goods.domain.GoodsSkuDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

/**
 * 商品中心对外接口service组件
 * @author Jenna C He
 * @date 2023/05/05 09:06
 */
@Service
public class CommodityFacadeServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(CommodityFacadeServiceImpl.class);

    /**
     * 根据商品id查询商品sku
     * @param goodsSkuId 商品sku id
     * @return 商品sku DTO
     */
    public GoodsSkuDTO getGoodsSkuById(Long goodsSkuId) throws Exception {
        try {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            GoodsSkuDTO goodsSkuDTO = new GoodsSkuDTO();

            goodsSkuDTO.setDiscountPrice(8900.00);
            goodsSkuDTO.setGmtCreate(dateFormatter.parse("2017-01-01 10:00:00"));
            goodsSkuDTO.setGmtModified(dateFormatter.parse("2017-01-01 10:00:00"));
            goodsSkuDTO.setGoodsHeight(59.50);
            goodsSkuDTO.setGoodsId(999L);
            goodsSkuDTO.setGoodsLength(125.90);
            goodsSkuDTO.setGoodsName("iPhone 8 plus");
            goodsSkuDTO.setGoodsSkuCode("FDL04300234");
            goodsSkuDTO.setGoodsWeight(29.60);
            goodsSkuDTO.setGrossWeight(599.80);
            goodsSkuDTO.setId(999L);
            goodsSkuDTO.setPurchasePrice(6856.70);
            goodsSkuDTO.setSalePrice(9599.00);
            goodsSkuDTO.setSaleProperties("机身颜色：白色，机身存储：256G");



            return goodsSkuDTO;
        }catch (Exception e) {
            logger.error("error",e);
        }
        return null;
    }
}
