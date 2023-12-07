package com.example.demo.Service;

import com.example.demo.DataTransferObject.Request.PostDto.Rate.RatePostDto;

public interface RateService
{
	void submitRating( RatePostDto dto ) throws Exception;
}
