package com.practice.springdatajpa.dao;

import com.practice.springdatajpa.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Classname BookDao
 * @Description TODO
 * @Date 2020/9/3 8:08
 * @Created by nihongyu
 */

/**
 * 第一个参数：你需要操作的实体表
 * 第二个参数：对应实体表的主键类型
 */
public interface BookDao extends JpaRepository<Book,Integer> {

}
