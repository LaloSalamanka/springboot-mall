package com.lalochen.springbootmall.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class CreateOrderRequest {

    @NotEmpty
    private List<BuyItem> buyItemList; // BuyItem 是 class，接住前端傳的 json 格式資料
/*
      {
          "buyItemList": [
            {
              "productId": 9,
              "quantity": 1
            },
            {
              "productId": 10,
              "quantity": 2
            }

          ]
      }
 */
    public List<BuyItem> getBuyItemList() {
        return buyItemList;
    }

    public void setBuyItemList(List<BuyItem> buyItemList) {
        this.buyItemList = buyItemList;
    }
}
