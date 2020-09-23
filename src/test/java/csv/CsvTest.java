package csv;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import csv.domain.entities.SampleEntity1;
import csv.infrastructure.Writer;

class CsvTest {

	Path path = Paths.get("test.csv");

	@BeforeEach
	void 前処理() {
		File file = path.toFile();
		file.delete();
	}

	@Test
	void test() {


		// 最初はファイルがないはず。あればエラーとする。
		assertFalse("ファイルが消えていない", Files.exists(path));

		SampleEntity1 entity1_1 = new SampleEntity1("A","B");
		SampleEntity1 entity1_2 = new SampleEntity1("C","D");
		List<SampleEntity1> list = new ArrayList<SampleEntity1>();
		list.add(entity1_1);
		list.add(entity1_2);
		Writer writer = new Writer();

		writer.Write(path, list);

		// ファイルができているはず。なければエラーとする。
		assertTrue("ファイルが作成されていない",Files.exists(path));
	}

}
