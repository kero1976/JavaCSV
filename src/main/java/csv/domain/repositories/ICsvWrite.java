package csv.domain.repositories;

import java.util.ArrayList;
import java.util.List;

public interface ICsvWrite {

	public List<Object> setData();

	default String csvWrite() {
		List<String> result = new ArrayList<String>();
		for(Object o : setData()) {
			if(isNumber(o)) {
				result.add(o.toString());
			}else {
				result.add(escapeString(o));
			}
		}
		return String.join(" , ", result);
	}

	/**
	 * Object型が数値項目かを判定。
	 * わからなければ数値ではないと判定する。
	 * @param o
	 * @return
	 */
	static boolean isNumber(Object o) {
		if(o instanceof Integer) {
			return true;
		}
		if(o instanceof Double) {
			return true;
		}
		if(o instanceof String) {
			return false;
		}
		return false;
	}

	/**
	 * ダブルクォートで囲い、値にダブルクォートがあればダブルクォートでエスケースする
	 * nullの場合は空文字として扱う
	 * 例) A"B → "A""B"
	 * @param o
	 * @return
	 */
	static String escapeString(Object o) {
		if(o == null) {
			return "\"\"";
		}
		String s = o.toString();
		return "\"" + s.replace("\"", "\"\"") + "\"";
	}
}
