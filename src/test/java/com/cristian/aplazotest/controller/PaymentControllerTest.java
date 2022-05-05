package com.cristian.aplazotest.controller;

import com.cristian.aplazotest.constants.AplazoConstants;
import com.cristian.aplazotest.models.dto.CreditDto;
import com.cristian.aplazotest.models.dto.RequestDto;
import com.cristian.aplazotest.models.dto.ResponseDto;
import com.cristian.aplazotest.models.exception.AplazoErrorMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PaymentControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;

    private static final String CALCULATE_URL = "/api/v1/calculate";
    private static final String PAYMENTS_URL = "/api/v1/payments";

    @Test
    public void  calculateEndPointTest() throws Exception {
        RequestDto
                requestDto = RequestDto.builder().amount(10d).rate(.1).term(10).build();
        ResponseEntity<ResponseDto[]> response = restTemplate.postForEntity(CALCULATE_URL,requestDto, ResponseDto[].class);
        assertEquals(HttpStatus.CREATED,response.getStatusCode());

    }

    @Test
    public void calculateEndPontBadResponseTest() throws Exception{
        RequestDto requestDto = RequestDto.builder().amount(10d).term(10).build();
        ResponseEntity<AplazoErrorMessage> response = restTemplate.postForEntity(CALCULATE_URL,requestDto, AplazoErrorMessage.class);
        assertEquals(HttpStatus.BAD_REQUEST ,response.getStatusCode());
        assertEquals(AplazoConstants.INVALID_RATE, response.getBody().getMessage());
    }

    @Test
    public void paymentEndPointTest() throws Exception{
        RequestDto
                requestDto = RequestDto.builder().amount(10d).rate(.1).term(10).build();
        restTemplate.postForEntity(CALCULATE_URL,requestDto, ResponseDto[].class);

        ResponseEntity<CreditDto[]> response = restTemplate.getForEntity(PAYMENTS_URL, CreditDto[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().length);

    }



}
