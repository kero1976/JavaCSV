package csv.infrastructure;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Writer {

	public <T> void Write(Path filePath, List<T> list) {
		// 空ファイルを作成する。
		try {
			Files.createFile(filePath);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
