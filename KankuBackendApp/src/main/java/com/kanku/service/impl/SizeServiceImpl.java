package com.kanku.service.impl;

import com.kanku.model.BatchProductSize;
import com.kanku.model.Order;
import com.kanku.model.Product;
import com.kanku.model.Size;
import com.kanku.repository.ISizeRepository;
import com.kanku.service.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeServiceImpl implements ISizeService {

    @Autowired
    private ISizeRepository sizeRepository;
    @Override
    public Size addSize(BatchProductSize batchProductSize) {

        System.out.println(batchProductSize);


//        sizeRepository.saveAll(batchProductSize.getSizes());

        batchProductSize.getSizes().forEach(size -> {

            if (sizeRepository.findByProduct_ProductIdAndSizeId(batchProductSize.getProduct().getProductId(), size.getSizeId()).isEmpty()){
                size.setProduct(batchProductSize.getProduct());
                size.setTotalAmount(size.getProductPrice() * size.getTotalProductQuantity());
                size.setProductDropPrice(0.0);
                sizeRepository.save(size);
            }
            else{
                Size sz=sizeRepository.findByProduct_ProductIdAndSizeId(batchProductSize.getProduct().getProductId(), size.getSizeId()).get();

                sz.setTotalAmount(sz.getTotalAmount()+size.getTotalProductQuantity()*size.getProductPrice());
                sz.setTotalProductQuantity(sz.getTotalProductQuantity()+size.getTotalProductQuantity());
                sizeRepository.save(sz);
            }
        });
        return null;
    }

    @Override
    public void updateProductDetails(Order order) {
        Size size=sizeRepository.findById(order.getSize().getSizeId()).get();

        if(size.getProductDropPrice()>0.0) {

            Double totalOrderAmount = size.getProductDropPrice() * order.getOrderQuantity();
            size.setTotalAmount(size.getTotalAmount() - totalOrderAmount);
            size.setTotalProductQuantity(size.getTotalProductQuantity() - order.getOrderQuantity());
            sizeRepository.save(size);
        }
        else {
            Double totalOrderAmount = size.getProductPrice() * order.getOrderQuantity();
            size.setTotalAmount(size.getTotalAmount() - totalOrderAmount);
            size.setTotalProductQuantity(size.getTotalProductQuantity() - order.getOrderQuantity());
            sizeRepository.save(size);
        }
    }
}
