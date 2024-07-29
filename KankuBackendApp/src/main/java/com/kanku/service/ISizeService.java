package com.kanku.service;

import com.kanku.model.BatchProductSize;
import com.kanku.model.ProductOrder;
import com.kanku.model.Size;

public interface ISizeService {
    Size addSize(BatchProductSize batchProductSize);

    void updateProductDetails(ProductOrder productOrder);
}
