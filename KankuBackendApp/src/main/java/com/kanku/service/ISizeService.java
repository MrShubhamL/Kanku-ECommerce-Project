package com.kanku.service;

import com.kanku.model.BatchProductSize;
import com.kanku.model.Order;
import com.kanku.model.Size;

public interface ISizeService {
    Size addSize(BatchProductSize batchProductSize);

    void updateProductDetails(Order order);
}
