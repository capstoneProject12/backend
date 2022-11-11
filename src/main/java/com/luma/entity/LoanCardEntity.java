package com.luma.entity;


import javax.persistence.*;


@Entity
@Table(name="loan_card_master")
public class LoanCardEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "loan_id")
    private Long loan_id;
	
	@Column(name = "loan_type")
    private String loan_type;
	
	@Column(name = "duration_in_years")
    private int duration_in_years;

	public Long getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(Long loan_id) {
		this.loan_id = loan_id;
	}

	public String getLoan_type() {
		return loan_type;
	}

	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}

	public int getDuration_in_years() {
		return duration_in_years;
	}

	public void setDuration_in_years(int duration_in_years) {
		this.duration_in_years = duration_in_years;
	}
	
}
