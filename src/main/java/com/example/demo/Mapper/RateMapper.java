package com.example.demo.Mapper;

import com.example.demo.DataTransferObject.Request.PostDto.Rate.RatePostDto;
import com.example.demo.Entity.Rate;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface RateMapper
{
	Rate mapToEntity( RatePostDto dto );
	RatePostDto mapToPostDto(Rate rate);
}
