/*
 * StudentService.java 2021. 07. 08
 *
 * Copyright 2021 Naver Cloud Corp. All rights Reserved.
 * Naver Business Platform PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package me.potato.simplerestwithmongodb.services;

import java.util.List;

import me.potato.simplerestwithmongodb.models.Student;

/**
 * @author dongju.paek
 */
public interface StudentService {
	List<Student> findAll();

	Student findByStudentNumber(long studentNumber);

	Student findByEmail(String email);

	List<Student> findAllByOrderByGpaDesc();

	Student saveOrUpdateStudent(Student student);

	void deleteStudentById(String id);
}