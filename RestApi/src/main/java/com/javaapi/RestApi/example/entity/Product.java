/**
 * 
 */
package com.javaapi.RestApi.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ravit
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Product_Tbl")

public class Product {
	@Id
    private int num;
	private int val;
	private int nxtval;
	
}

