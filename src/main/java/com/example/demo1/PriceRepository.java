package com.example.demo1;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

interface PriceRepository extends CrudRepository<Price, String> {
	Price findByType(String type);
}
