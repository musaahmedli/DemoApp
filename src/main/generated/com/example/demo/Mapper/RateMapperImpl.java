package com.example.demo.Mapper;

import com.example.demo.DataTransferObject.Request.PostDto.Rate.RatePostDto;
import com.example.demo.Entity.Rate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-07T15:15:22+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class RateMapperImpl implements RateMapper {

    @Override
    public Rate mapToEntity(RatePostDto dto) {
        if ( dto == null ) {
            return null;
        }

        Rate rate = new Rate();

        rate.setRating( dto.getRating() );

        return rate;
    }

    @Override
    public RatePostDto mapToPostDto(Rate rate) {
        if ( rate == null ) {
            return null;
        }

        RatePostDto ratePostDto = new RatePostDto();

        ratePostDto.setRating( rate.getRating() );

        return ratePostDto;
    }
}
