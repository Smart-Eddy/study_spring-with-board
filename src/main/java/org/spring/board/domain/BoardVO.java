package org.spring.board.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data // lombok Data ������̼��� getter, setter�� �ڵ����� �������ش�. 
public class BoardVO {
	
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private LocalDateTime regDate;
	private LocalDateTime updateDate;

}
