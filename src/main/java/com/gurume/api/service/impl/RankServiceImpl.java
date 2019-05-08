package com.gurume.api.service.impl;

import com.gurume.api.entity.Rank;
import com.gurume.api.repository.RankRepository;
import com.gurume.api.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName RankServiceImpl
 * @Description TODO
 * @Author huyue
 * @Date 2019/5/1 3:57 PM
 * @Version 1.0
 **/
@Service
public class RankServiceImpl implements RankService {
    @Autowired
    RankRepository rankRepository;

    @Override
    public Rank findByNum(Integer num) {
        return rankRepository.findByNum(num);
    }
}
