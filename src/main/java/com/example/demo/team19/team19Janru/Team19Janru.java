package com.example.demo.team19.team19Janru;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "team19_janru_tbl")
@Data
public class Team19Janru {
	@Id
	private String janruCd;
	private String janruNm;
}
