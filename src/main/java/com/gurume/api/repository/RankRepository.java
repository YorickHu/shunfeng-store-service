package com.gurume.api.repository;

import com.gurume.api.entity.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankRepository extends JpaRepository<Rank, Integer>{

    Rank findByNum(Integer num);


}
