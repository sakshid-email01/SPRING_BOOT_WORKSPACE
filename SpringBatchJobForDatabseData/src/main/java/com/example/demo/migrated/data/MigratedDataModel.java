package com.example.demo.migrated.data;

import com.example.demo.old.data.OldDataModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "migrated_data")
public class MigratedDataModel {
	
	public MigratedDataModel(OldDataModel item) {
		// TODO Auto-generated constructor stub
	}
	@Id
	private int id;
	private String emailId;
	private String name;
	private Boolean updatedInMigratedCode;
}
