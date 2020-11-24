package hanziToPinyin;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class ConvertSpellUtil
{
	/**
	 * 传入中文汉字字符串，转换出对应拼音字符串
	 *   注：如果传入的中文中有任一同音字都会返回字符串信息：false
	 * @param src 中文汉字字符串
	 * @param hasBlank 是否需要有空格
	 * @return 对应拼音字符串
	 */
	public static String convertToSpell(String src,boolean hasBlank)
	{
		char[] t1 = src.toCharArray();
		String[] t2 ;
		// 设置汉字拼音输出的格式
		HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
		t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		t3.setVCharType(HanyuPinyinVCharType.WITH_V);
		StringBuilder t4 = new StringBuilder();
		int t0 = t1.length;
		try
		{
			for (int i = 0; i < t0; i++)
			{
				// 判断能否为汉字字符
				if (Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+"))
				{
					// 将汉字的几种全拼都存到t2数组中，由于汉字会有多音字，所以就只取第一个元素
					t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
					if (t2 != null)
					{
						if(!hasBlank)
						{
							t4.append(t2[0]); // 取数组第一个元素拼接成拼音字符串
						}
						else
						{
							if(i == 0 || i == t0 - 1)
							{
								t4.append(t2[0]); //第一个和最后一个不加空格
							}
							else
							{
								t4.append(" ").append(t2[0]);
							}
						}
					}
				}
				else
				{
					// 如果不是汉字字符，间接取出字符并连接到字符串t4后
					t4.append(Character.toString(t1[i]));
				}
			}
		}
		catch (BadHanyuPinyinOutputFormatCombination e)
		{
			e.printStackTrace();
		}

		// 返回拼音字符串(如果全是大写的非中文的字符可以转成全小写，具体看需要)
		return t4.toString().toLowerCase();
	}

	public static void main(String[] args)
	{
		// 结果：false: diedaimeigehanzidepinyin！！！
		//        true: die dai meige han zi de pin yin！！!
		String polyphone = ConvertSpellUtil.convertToSpell("全生命周期系统",true);
		System.out.println(polyphone);

		// 结果：全字母true和false结果一样：    helloworld,i love java!!!
		String polyphone2 = ConvertSpellUtil.convertToSpell("    HELLOWORLD,I LOVE JAVA!!!     ",true);
		System.out.println(polyphone2);

		// 结果：true结果：     ni hao shi jie,i love java!!!
		//      false结果：    nihaoshijie,i love java!!!
		String polyphone3 = ConvertSpellUtil.convertToSpell("    你好世界,I LOVE JAVA!!!     ",false);
		System.out.println(polyphone3);
	}
}