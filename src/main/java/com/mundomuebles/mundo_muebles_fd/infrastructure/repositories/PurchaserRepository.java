package com.mundomuebles.mundo_muebles_fd.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface PurchaserRepository extends JpaRepository <Purchaser, BigInteger> {
}
