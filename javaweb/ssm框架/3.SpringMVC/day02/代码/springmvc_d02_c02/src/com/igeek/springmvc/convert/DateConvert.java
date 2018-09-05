package com.igeek.springmvc.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * param1:原来的数据类型
 * param2:要转换的数据类型
 * @author cp
 *
 */
public class DateConvert implements Converter<String, Date>{

	@Override
	public Date convert(String s) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date d= sdf.parse(s);
			return d;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//转换不成功
		return null;
	}

}
