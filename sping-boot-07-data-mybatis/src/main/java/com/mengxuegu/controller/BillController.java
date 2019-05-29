package com.mengxuegu.controller;


import com.mengxuegu.entities.Bill;
import com.mengxuegu.mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {
    @Autowired
    private BillMapper billMapper;

    @GetMapping("/getBill/{bid}")
    public Bill getBill(@PathVariable("bid") Integer bid){
        Bill bill = billMapper.getBillByBid(bid);
        return bill;
    }


    @GetMapping("/addBill")
    public Bill addBill(Bill bill){
        billMapper.addBill(bill);
        return bill;
    }
}
