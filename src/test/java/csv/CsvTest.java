package csv;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import csv.domain.entities.SampleEntity1;
import csv.domain.entities.SampleEntity2;
import csv.domain.entities.csv.SampleEntity1Csv;
import csv.domain.entities.csv.SampleEntity2Csv;
import csv.domain.repositories.ICsvWrite;
import csv.infrastructure.Writer;
import kero.exception.KeroException;
import kero.testutil.file.FileTestUtil;

class CsvTest {

	Path path = Paths.get("test.csv");

	@BeforeEach
	void 前処理() {
		File file = path.toFile();
		file.delete();
	}

	@Test
	void test1() throws KeroException {


		// 最初はファイルがないはず。あればエラーとする。
		assertFalse("ファイルが消えていない", Files.exists(path));

		SampleEntity1 entity1_1 = new SampleEntity1("A","B");
		SampleEntity1 entity1_2 = new SampleEntity1("C","D");
		List<SampleEntity1> list = new ArrayList<SampleEntity1>();
		list.add(entity1_1);
		list.add(entity1_2);
		List<ICsvWrite> list2 = list.stream().map(o -> new SampleEntity1Csv(o)).collect(Collectors.toList());
		Writer writer = new Writer();

		writer.Write(path, list2);

		// ファイルができているはず。なければエラーとする。
		assertTrue("ファイルが作成されていない",Files.exists(path));
		assertTrue(FileTestUtil.FileToDataEqualsUTF8(path,"\"A\" , \"B\"\r\n" +
				"\"C\" , \"D\"\r\n" +
				"" ));
	}

	@Test
	void test2() {


		// 最初はファイルがないはず。あればエラーとする。
		assertFalse("ファイルが消えていない", Files.exists(path));

		SampleEntity2 entity2_1 = new SampleEntity2("A\"B C","",1,1.2);
		SampleEntity2 entity2_2 = new SampleEntity2(null,"D",2,2.2);
		List<SampleEntity2> list = new ArrayList<SampleEntity2>();
		list.add(entity2_1);
		list.add(entity2_2);
		List<ICsvWrite> list2 = list.stream().map(o -> new SampleEntity2Csv(o)).collect(Collectors.toList());
		Writer writer = new Writer();

		writer.Write(path, list2);

		// ファイルができているはず。なければエラーとする。
		assertTrue("ファイルが作成されていない",Files.exists(path));
	}

}
