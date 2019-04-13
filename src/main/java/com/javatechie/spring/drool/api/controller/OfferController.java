package com.javatechie.spring.drool.api.controller;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.drool.api.pojo.CreditCard;

@RestController
public class OfferController {

	@Autowired
	private KieSession session;

	@PostMapping("/getDiscountStatus")
	public String getOfferAmmount(@RequestBody CreditCard card) {
		session.insert(card);
		session.fireAllRules();
		System.out.println("Request Count : " + session.getFactCount());
		return "Discount Applied for " + card.getCardType() + " : " + card.getDiscount();
	}

}
