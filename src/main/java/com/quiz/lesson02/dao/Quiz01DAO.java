package com.quiz.lesson02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson02.model.Store;
@Repository
public interface Quiz01DAO {
	//3
	//�̰����� Store���� ������ ���� ����Ʈ �ȿ� ���� id,��ȭ��ȣ ���ı��� ���� ������.
	public List<Store> selectStoreList();

}
