package csv.infrastructure;

import static java.nio.file.StandardOpenOption.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import csv.domain.repositories.ICsvWrite;
public class Writer {


	public <T> void Write(Path filePath, List<ICsvWrite> list) {

		List<String> lines = list.stream().map( o -> o.csvWrite()).collect(Collectors.toList());
		try {
			Files.write(filePath, lines, CREATE, WRITE, APPEND);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
