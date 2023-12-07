package com.example.demo.Controller;

import com.example.demo.Core.CustomResponse.ResponseHandler;
import com.example.demo.DataTransferObject.Request.PostDto.Rate.RatePostDto;
import com.example.demo.Service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1/Rate")
public class RateController
{
	private final RateService rateService;

	@Autowired

	public RateController ( RateService rateService )
	{
		this.rateService = rateService;
	}

	@PostMapping("/submitRating")
	public ResponseEntity<Object> submitRating( @RequestBody RatePostDto dto )
	{
		try
		{
			rateService.submitRating ( dto );
			return ResponseHandler.generateResponse("submitted successfully",HttpStatus.OK,null);
		}
		catch ( NoSuchElementException exception )
		{
			return ResponseHandler.generateResponse(exception.getMessage(),HttpStatus.NOT_FOUND,null);
		}
		catch ( Exception exception )
		{
			return ResponseHandler.generateResponse( exception.getMessage (), HttpStatus.INTERNAL_SERVER_ERROR,null );
		}
	}

}
