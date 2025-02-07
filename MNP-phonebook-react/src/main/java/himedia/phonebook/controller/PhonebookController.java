package himedia.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import himedia.phonebook.repository.vo.PhonebookVo;
import himedia.phonebook.service.PhonebookService;

@RestController
@RequestMapping("/api/phonebook")
public class PhonebookController {
	@Autowired
	private PhonebookService phonebookService;
	
	//	GET: /api/phonebook -> 목록 불러오기
	@GetMapping
	public ResponseEntity <List<PhonebookVo>> getAll() {
		List<PhonebookVo> list = phonebookService.selectAll();
		return ResponseEntity.ok(list);
	}
	
	//	POST: /api/phonebook -> 전화번호 추가
	@PostMapping
	public ResponseEntity <PhonebookVo> insert(@RequestBody PhonebookVo phonebookVo) {
		PhonebookVo savedItem = phonebookService.insert(phonebookVo);
		return ResponseEntity.ok(savedItem);
	}
	
	//	PUT: /api/phonebook/{id} -> 전화번호 수정
	@PutMapping("/{id}")
	public ResponseEntity<PhonebookVo> update(@RequestBody PhonebookVo phonebookVo, @PathVariable("id") Integer id) {
		phonebookVo.setId(id);
		PhonebookVo update = phonebookService.update(phonebookVo);
		return ResponseEntity.ok(update);
	}
	
	//	DELETE: /api/phonebook/{id} -> 전화번호 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		phonebookService.delete(id);
		return ResponseEntity.ok().<Void>build();
	}
}
