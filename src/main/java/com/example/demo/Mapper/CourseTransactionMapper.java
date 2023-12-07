package com.example.demo.Mapper;

import com.example.demo.DataTransferObject.Request.PostDto.CourseTransaction.CourseTransactionPostDto;
import com.example.demo.DataTransferObject.Response.GetDto.CourseTransaction.CourseTransactionGetResponseDto;
import com.example.demo.Entity.CourseTransaction;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(uses = {UserMapper.class,CourseContentMapper.class,CourseMapper.class},
		componentModel = "spring",
		nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CourseTransactionMapper
{
	CourseTransactionGetResponseDto mapToGetDto( CourseTransaction transaction );
	List<CourseTransactionGetResponseDto> mapToGetListDto(List<CourseTransaction> transactions);
	CourseTransaction mapToEntity (CourseTransactionPostDto transaction);
}
