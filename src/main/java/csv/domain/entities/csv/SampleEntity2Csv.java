package csv.domain.entities.csv;

import java.util.ArrayList;
import java.util.List;

import csv.domain.entities.SampleEntity2;
import csv.domain.repositories.ICsvWrite;

public class SampleEntity2Csv extends SampleEntity2 implements ICsvWrite {

	private SampleEntity2 entity;

	public SampleEntity2Csv(SampleEntity2 entity) {
		this.entity = entity;
	}

	@Override
	public List<Object> setData() {

		List<Object> list = new ArrayList<Object>();
		list.add(entity.getData1());
		list.add(entity.getData2());
		list.add(entity.getData3());
		list.add(entity.getData4());
		return list;
	}
}
