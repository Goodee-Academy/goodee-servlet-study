package com.gn.dto;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Planet {
	private String name;
	private double distance;
	private boolean canLive;
}
