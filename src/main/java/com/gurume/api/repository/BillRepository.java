package com.gurume.api.repository;

import com.gurume.api.entity.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Integer> {


    @Query(value = "SELECT * FROM gurume.bill WHERE user_info = ?1",
            countQuery = "SELECT count(*) FROM gurume.bill WHERE user_info = ?1",
            nativeQuery = true)
    public Page<Bill> findAllByUserInfo(Integer userInfo, Pageable pageable);

    public List<Bill> findAllByUserInfoAndStat(Integer userInfo, Integer stat);// 只找已经支付的
}
