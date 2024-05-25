package com.example.demo.old.data;

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
@Table(name = "old_data")
public class OldDataModel {

@Id
private int id;
private String emailId;
private String name;
private Boolean updatedInMigratedCode;

}
