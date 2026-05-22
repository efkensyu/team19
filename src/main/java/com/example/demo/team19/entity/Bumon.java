package com.example.demo.team19.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "bumon_tbl")
@Data
public class Bumon {		
	@Id
	private String bumonCd;
	private String bumonNm;
}		
