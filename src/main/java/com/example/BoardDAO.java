package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	private final String BOARD_INSERT = "insert into BOARD2 (category,title, writer, content) values (?,?,?,?)";
	private final String BOARD_UPDATE = "update BOARD2 set category=?,title=?, writer=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from BOARD2  where seq=?";
	private final String BOARD_GET = "select * from BOARD2  where seq=?";
	private final String BOARD_LIST = "select * from BOARD2 order by seq desc";

	public int insertBoard(BoardVO vo) {
		return jdbcTemplate.update(BOARD_INSERT,new Object[]{vo.getCategory(),vo.getTitle(),vo.getWriter(),vo.getContent()});
	}

	// 글 삭제
	public int deleteBoard(int seq) {
		return jdbcTemplate.update(BOARD_DELETE,new Object[]{seq});

	}
	public int updateBoard(BoardVO vo) {
		return jdbcTemplate.update(BOARD_UPDATE,new Object[]{vo.getCategory(), vo.getTitle(),vo.getWriter(),vo.getContent(),vo.getSeq()});

	}

	public BoardVO getBoard(int seq) {
		return jdbcTemplate.queryForObject(BOARD_GET,new Object[]{seq},new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
	}

	public List<BoardVO> getBoardList() {

		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
}

