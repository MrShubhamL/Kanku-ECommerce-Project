package com.kanku.service.impl;

import com.kanku.model.BatchProductSize;
import com.kanku.model.ProductOrder;
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
    public Size getSizeByProductId(Size size) {
        return sizeRepository.getSizeByProductProductId(size.getProduct().getProductId());
    }

    @Override
    public void updateProductDetails(ProductOrder productOrder) {
        Size size=sizeRepository.findById(productOrder.getSize().getSizeId()).get();

        if(size.getProductDropPrice()>0.0) {

            Double totalOrderAmount = size.getProductDropPrice() * productOrder.getOrderQuantity();
            size.setTotalAmount(size.getTotalAmount() - totalOrderAmount);
            size.setTotalProductQuantity(size.getTotalProductQuantity() - productOrder.getOrderQuantity());
            sizeRepository.save(size);
        }
        else {
            Double totalOrderAmount = size.getProductPrice() * productOrder.getOrderQuantity();
            size.setTotalAmount(size.getTotalAmount() - totalOrderAmount);
            size.setTotalProductQuantity(size.getTotalProductQuantity() - productOrder.getOrderQuantity());
            sizeRepository.save(size);
        }
    }
}
