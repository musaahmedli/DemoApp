package com.example.demo.Mapper;

import com.example.demo.DataTransferObject.Request.PostDto.CourseTransaction.CourseTransactionPostDto;
import com.example.demo.DataTransferObject.Response.GetDto.CourseTransaction.CourseTransactionGetResponseDto;
import com.example.demo.Entity.CourseTransaction;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-07T15:15:22+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class CourseTransactionMapperImpl implements CourseTransactionMapper {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public CourseTransactionGetResponseDto mapToGetDto(CourseTransaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        CourseTransactionGetResponseDto courseTransactionGetResponseDto = new CourseTransactionGetResponseDto();

        courseTransactionGetResponseDto.setId( transaction.getId() );
        courseTransactionGetResponseDto.setTransactedUser( userMapper.mapToGetDto( transaction.getTransactedUser() ) );
        courseTransactionGetResponseDto.setTransactedCourse( courseMapper.mapToGetOneDto( transaction.getTransactedCourse() ) );

        return courseTransactionGetResponseDto;
    }

    @Override
    public List<CourseTransactionGetResponseDto> mapToGetListDto(List<CourseTransaction> transactions) {
        if ( transactions == null ) {
            return null;
        }

        List<CourseTransactionGetResponseDto> list = new ArrayList<CourseTransactionGetResponseDto>( transactions.size() );
        for ( CourseTransaction courseTransaction : transactions ) {
            list.add( mapToGetDto( courseTransaction ) );
        }

        return list;
    }

    @Override
    public CourseTransaction mapToEntity(CourseTransactionPostDto transaction) {
        if ( transaction == null ) {
            return null;
        }

        CourseTransaction courseTransaction = new CourseTransaction();

        return courseTransaction;
    }
}
