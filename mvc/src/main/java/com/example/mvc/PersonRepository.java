package com.example.mvc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author qiuchangdong
 * @Type PersonRepository
 * @Desc 。
 * @date 2021-03-10 14:45:47
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
