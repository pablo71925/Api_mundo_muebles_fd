package com.mundomuebles.mundo_muebles_fd.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product,String> {
}
