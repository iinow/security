package com.ha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@Table(name = "users")
@ToString
@EqualsAndHashCode(callSuper = false)
public class UserModel extends BaseModel{
	private static final long serialVersionUID = 4945396672311655552L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, length = 20)
	private String name;
}
