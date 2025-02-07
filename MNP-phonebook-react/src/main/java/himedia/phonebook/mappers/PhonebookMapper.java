package himedia.phonebook.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import himedia.phonebook.repository.vo.PhonebookVo;

public interface PhonebookMapper {
//	<select id="selectAll" resultType="phonebookVo"> 1:1 매칭
	List<PhonebookVo> selectAll();
	
//	<insert id="insert" parameterType="phonebookVo">
	int insert(PhonebookVo phonebookVo);
	
//	<select id="selectOne" parameterType="int" resultType="phonebookVo">
	PhonebookVo selectOne(Integer id);
	
//	<update id="update" parameterType="phonebookVo">
	int update(PhonebookVo phonebookVo);
	
//	<delete id="delete" parameterType="int">
	int delete(Integer id);
}
