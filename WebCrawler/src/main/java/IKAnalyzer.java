

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Stream;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

/***
 * 
 * 
 * @author Haomeng,Wang
 *
 * 分词烦算法测试
 */
public class IKAnalyzer {

	public static void main(String[] args) {

		List<String> lists = new ArrayList<String>();

		StringReader re = new StringReader(
				"中国核工业集团有限公司（下称中核集团）电子商务平台于6月23日披露的一则招标公告显示，上海中核浦原有限公司受中核海洋核动力发展有限公司的委托，就“核动力破冰综合保障船示范工程技术咨询与服务外委项目”进行公开招标。该项目将“基于成熟技术的基础上，制造我国首艘核动力破冰综合保障船，须具备破冰、开辟极地航道能力，同时兼顾供电、海上补给保障及救援等功能。”\r\n"
						+ "\r\n"
						+ "　　公告显示，上述项目资金来源已落实，已具备招标条件。招标范围包括：在核动力破冰综合保障船示范工程的立项、可研、设计、审评、取证、建造、调试等工作过程中，为招标人（即中核海洋核动力发展有限公司）提供船舶与核动力装置的设计验证、设计审查、技术咨询等多方面的技术支持，解决示范工程推进过程中的技术问题。服务期从合同生效后到示范工程核动力破冰综合保障船调试结束，交付使用方。\r\n"
						+ "\r\n" + "　　中国核动力平台研发已有近50年历史\r\n" + "\r\n"
						+ "　　上海中核浦原有限公司和中核海洋核动力发展有限公司均为中核集团下属企业。其中，浦原公司的定位是中核集团统一的招投标与集中采购平台。中核海洋核动力发展有限公司则颇为年轻：2017年8月10日，中核集团旗下上市公司中国核能电力股份有限公司（中国核电，601985.SH）公告，拟与关联方浙江浙能电力股份有限公司及其他投资方上海国盛（集团）有限公司、江南造船（集团）有限责任公司、上海电气集团股份有限公司共同出资设立中核海洋核动力发展有限公司。中国核电出资5.1亿元，持股比例51%。\r\n"
						+ "\r\n" + "　　工商资料显示，中核海洋核动力发展有限公司于2017年8月15日在上海成立，经营范围包括海洋核动力装备开发等。\r\n" + "\r\n"
						+ "　　值得注意的是，中核海洋核动力发展有限公司参股方中的江南造船（集团）有限责任公司，在极地科考破冰船领域的作业经验颇丰。该公司目前正在建造中国新一代万吨级极地科考破冰船。该船是中国首艘国产极地破冰船，计划于2019年年初交船，交付后将与“雪龙”号组成极地考察船队，极大提升中国在极地海洋区域的综合考察能力。1993年中国从乌克兰引进并改造“雪龙”号后，江南造船多次承担“雪龙”号的维修改造工作。");
		IKSegmenter ik = new IKSegmenter(re, true);
		Lexeme lex;
		try {
			while ((lex = ik.next()) != null) {
				
				lists.add(lex.getLexemeText());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Map<String, Integer> res = wordCount(lists);

		for (Entry<String, Integer> entry : res.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}

	public static Map<String, Integer> wordCount(List<String> lists) {

		Map<String, Integer> wordsCount = new TreeMap<String, Integer>(); // 存储单词计数信息，key值为单词，value为单词数

		// 单词的词频统计
		for (String li : lists) {
			if(li.length()<=1)
				continue;
			if (wordsCount.get(li) != null) {
				wordsCount.put(li, wordsCount.get(li) + 1);
			} else {
				wordsCount.put(li, 1);
			}

		}

		// 对map利用key排序
		Map<String, Integer> resMap = sortByValue(wordsCount);

		return resMap;

	}

	/**
	 * 让 Map按key进行排序
	 */
	public static Map<String, Integer> sortMapByKey(Map<String, Integer> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}
		Map<String, Integer> sortMap = new TreeMap<String, Integer>(new MapKeyComparator());
		sortMap.putAll(map);
		return sortMap;
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		Map<K, V> result = new LinkedHashMap<>();
		Stream<Entry<K, V>> st = map.entrySet().stream();

		st.sorted(Comparator.comparing(e -> e.getValue())).forEach(e -> result.put(e.getKey(), e.getValue()));

		return result;
	}
}

class MapKeyComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		return s1.compareTo(s2); // 从小到大排序
	}
}
