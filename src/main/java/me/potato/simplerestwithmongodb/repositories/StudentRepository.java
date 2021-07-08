/*
 * StudentRespository.java 2021. 07. 08
 *
 * Copyright 2021 Naver Cloud Corp. All rights Reserved.
 * Naver Business Platform PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package me.potato.simplerestwithmongodb.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import me.potato.simplerestwithmongodb.models.Student;

/**
 * @author dongju.paek
 */
public interface StudentRepository extends MongoRepository<Student, String> {

	Student findByStudentNumber(long studentNumber);

	Student findByEmail(String email);

	List<Student> findAllByOrderByGpaDesc();

}