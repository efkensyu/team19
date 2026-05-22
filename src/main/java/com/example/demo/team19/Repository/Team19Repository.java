package com.example.demo.team19.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.team19.entity.Bumon;

public interface Team19Repository extends JpaRepository<Bumon, String> {
	public List<Bumon> findByBumonCd(String code);
}
