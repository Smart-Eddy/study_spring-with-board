package org.spring.board.mappers;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("select SYSDATE from dual")
	String getTime();
}
