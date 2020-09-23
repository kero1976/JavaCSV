package csv.domain.entities.csv;

import java.util.ArrayList;
import java.util.List;

import csv.domain.entities.SampleEntity1;
import csv.domain.repositories.ICsvWrite;

public class SampleEntity1Csv extends SampleEntity1 implements ICsvWrite {

	private SampleEntity1 entity;

	public SampleEntity1Csv(SampleEntity1 entity) {
		this.entity = entity;
	}

	@Override
	public List<Object> setData() {

		List<Object> list = new ArrayList<Object>();
		list.add(entity.getData1());
		list.add(entity.getData2());
		return list;
	}
}
