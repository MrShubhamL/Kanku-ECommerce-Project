package com.kanku.service.impl;

import com.kanku.model.Order;
import com.kanku.model.Product;
import com.kanku.model.Size;
import com.kanku.repository.IOrderRepository;
import com.kanku.repository.IProductRepository;
import com.kanku.repository.ISizeRepository;
import com.kanku.service.IOrderService;
import com.kanku.service.IProductService;
import com.kanku.service.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

//    @Autowired
//    private IStockRepository stockRepository;

    @Autowired
    private ISizeRepository sizeRepository;


    @Autowired
    private ISizeService sizeService;
    @Override
    public Order orderProduct(Order order) {


        Size size =sizeRepository.findById(order.getSize().getSizeId()).get();
        System.out.println(size);
        System.out.println(order.getProduct());

        if(order.getOrderQuantity()<=size.getTotalProductQuantity()){

              sizeService.updateProductDetails(order);
              order.setOrderDate(LocalDate.now());
              return orderRepository.save(order);

        }
        return null;
    }
}
