package com.example.myutils.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @项目名： myutils
 * @包名： com.example.myutils
 * @类名： Launguage
 * @创建者： sam wong
 * @创建时间： 2016年12月28日 ,下午2:37:48
 * 
 * @描述： TODO
 */

// 将汉字转换为拼音字母
public class Launguage {
	// 将汉字转换为全拼
	public static StringBuilder getPingYin(String src)
	{

		char[] t1 = null;
		t1 = src.toCharArray();
		String[] t2 = new String[t1.length];
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
				// 判断是否为汉字字符
				if (Character.toString(t1[i]).matches(
						"[\\u4E00-\\u9FA5]+"))
				{
					t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
					t4.append(t2[0]);
				} else
					t4.append(Character.toString(t1[i]));
			}
			// System.out.println(t4);
			return t4;
		} catch (BadHanyuPinyinOutputFormatCombination e1)
		{
			e1.printStackTrace();
		}
		return t4;
	}

	// 返回中文的首字母
	public static StringBuilder getPinYinHeadChar(String str)
	{

		StringBuilder convert = new StringBuilder();
		for (int j = 0; j < str.length(); j++)
		{
			char word = str.charAt(j);
			String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
			if (pinyinArray != null)
			{
				convert.append(pinyinArray[0].charAt(0));
			} else
			{
				convert.append(word);
			}
		}
		return convert;
	}

	// 将字符串转移为ASCII码
	public static StringBuilder getCnASCII(String cnStr)
	{
		StringBuilder strBuf = new StringBuilder();
		byte[] bGBK = cnStr.getBytes();
		for (int i = 0; i < bGBK.length; i++)
		{
			strBuf.append(Integer.toHexString(bGBK[i] & 0xff));
		}
		return strBuf;
	}

	public static void main(String[] args)
	{
		System.out.println(getPingYin("綦江qq县"));
		System.out.println(getPinYinHeadChar("綦江县"));
		System.out.println(getCnASCII("綦江县"));
	}
}
