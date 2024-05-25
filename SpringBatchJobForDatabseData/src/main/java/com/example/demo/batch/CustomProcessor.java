package com.example.demo.batch;

import org.springframework.batch.item.ItemProcessor;

import com.example.demo.migrated.data.MigratedDataModel;
import com.example.demo.old.data.OldDataModel;

public class CustomProcessor implements ItemProcessor<OldDataModel, MigratedDataModel> {

	@Override
	public MigratedDataModel process(OldDataModel item) throws Exception {
		// TODO Auto-generated method stub
		MigratedDataModel migratedDataModel = new MigratedDataModel();
		migratedDataModel.setId(item.getId());
		migratedDataModel.setName(item.getName());
		migratedDataModel.setEmailId(item.getEmailId());
		if (item.getUpdatedInMigratedCode() == false) {
			migratedDataModel.setUpdatedInMigratedCode(true);
		}

		return migratedDataModel;
	}
}
