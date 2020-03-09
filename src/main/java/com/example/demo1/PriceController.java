package com.example.demo1;

import java.util.List;
import com.example.demo1.PriceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController {
	
	private final PriceRepository repository;
	
	public PriceController(PriceRepository repository) {
		this.repository = repository;
	}
	
	
	@GetMapping("/getPrice/showAll") 
	List<Price> all()
	{
		return (List<Price>) repository.findAll();
	}
	
	
	@GetMapping("/getPrice")
	public String[] getPrice(@RequestParam int inputusage) {
		List<Price> allPrice = all();
		double result = 0;
		String type = "";
		for(Price price : allPrice) {
			float priceStart = price.getRangeFrom();
			float priceEnd = price.getRangeTo();
			if (inputusage >= priceStart && inputusage < priceEnd) {
				double basicFee = price.getBasicFee();
				double unitRate = price.getUnitRate();
				type = price.getType();
				result = basicFee + (unitRate * inputusage);
			}
		}
		
		String[] ansLists = new String[2];
		ansLists[0] = Double.toString(result);
		ansLists[1] = type;
		return ansLists;
	}
	
	@GetMapping("/getPrice/fromType")
	public Price getPriceFromType(@RequestParam String type) {
		Price targetPrice = repository.findByType(type);
		return targetPrice;
	}
	
	
	@PostMapping("/postNewPriceModel")
	public String saveNewPriceModel(@RequestBody Price newPrice) {
		try {
			if (!newPrice.getType().isEmpty()) {
				List<Price> allPrice = all();
				for(Price price : allPrice) {
					if (price.getType().equals(newPrice.getType())) {
						return "Fail to save new price: this type is already exists.";
					}
				}
				repository.save(newPrice);
				return "Save new price model successfully.";
			} else {
				return "Fail to save new price: type not supported.";
			}
		}
		catch (Exception e) {
			return "Fail to save new price: type not supported.";
		}
	}
}
