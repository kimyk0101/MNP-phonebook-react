package himedia.phonebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.phonebook.mappers.PhonebookMapper;
import himedia.phonebook.repository.vo.PhonebookVo;

@Service
public class PhonebookService {
	@Autowired
	private PhonebookMapper phonebookMapper;
	
	// 목록 불러오기
	public List<PhonebookVo> selectAll() {
		List<PhonebookVo> list = phonebookMapper.selectAll();
		return list;
	}

	//	전화번호 추가
	public PhonebookVo insert(PhonebookVo phonebookVo) {
		phonebookMapper.insert(phonebookVo);
		Integer id = phonebookVo.getId();
		return phonebookMapper.selectOne(id);
	}

	// 전화번호 수정
	public PhonebookVo update(PhonebookVo phonebookVo) {
		phonebookMapper.update(phonebookVo);
		return phonebookVo;
	}
	
	// 전화번호 삭제
	public int delete(Integer id) {
		return phonebookMapper.delete(id);
	}

}
