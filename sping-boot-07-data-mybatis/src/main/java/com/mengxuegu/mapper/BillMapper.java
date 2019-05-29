package com.mengxuegu.mapper;

import com.mengxuegu.entities.Bill;

public interface BillMapper {

    Bill getBillByBid(Integer bid);

    int addBill(Bill bill);



}
