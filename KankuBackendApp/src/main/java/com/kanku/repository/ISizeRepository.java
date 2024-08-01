package com.kanku.repository;

import com.kanku.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISizeRepository extends JpaRepository<Size,Long> {

    Optional<Size> findByProduct_ProductIdAndSizeId(Long productId, Long sizeId);

    Size getSizeByProductProductId(Long id);
}
