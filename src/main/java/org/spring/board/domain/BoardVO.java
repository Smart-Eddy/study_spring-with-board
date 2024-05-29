package org.spring.board.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data // lombok Data 어노테이션은 getter, setter를 자동으로 생성해준다. 
public class BoardVO {
	
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private LocalDateTime regDate;
	private LocalDateTime updateDate;

}
