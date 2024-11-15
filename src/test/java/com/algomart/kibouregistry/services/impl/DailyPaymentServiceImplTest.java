package com.algomart.kibouregistry.services.impl;//package com.algomart.kibouregistry.services.impl;
//import com.algomart.kibouregistry.entity.DailyPayments;
//import com.algomart.kibouregistry.enums.EventType;
//import com.algomart.kibouregistry.exceptions.DailyPaymentNotFoundException;
//import com.algomart.kibouregistry.models.DailyPaymentRequest;
//import com.algomart.kibouregistry.models.DailyPaymentResponse;
//import com.algomart.kibouregistry.repository.DailyPaymentsRepo;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.jpa.domain.Specification;
//
//import java.math.BigDecimal;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.Optional;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class DailyPaymentServiceImplTest {
//    @Mock
//    private DailyPaymentsRepo dailyPaymentsRepo;
//    @InjectMocks
//    private DailyPaymentServiceImpl dailyPaymentService;
//    private DailyPaymentRequest dailyPaymentRequest;
//    private DailyPayments dailyPayments;
//    private DailyPaymentResponse dailyPaymentResponse;
//
//    @BeforeEach
//    void setUp() {
//        dailyPaymentRequest = new DailyPaymentRequest(new Date(), BigDecimal.valueOf(100.00), EventType.REGULAR);
//    }
//
//    @Test
//
//    public void testFindAll() {
//        Page<DailyPayments> page = new PageImpl<>(Arrays.asList(dailyPayments));
//        when(dailyPaymentsRepo.findAll(any(Specification.class), any(PageRequest.class))).thenReturn(page);
//        Page<DailyPaymentResponse> result = dailyPaymentService.findAll(new Date(), new Date(), EventType.REGULAR, PageRequest.of(0, 10));
//        assertEquals(1, result.getTotalElements());
//        assertEquals(dailyPaymentResponse, result.getContent().get(0));
//
//        verify(dailyPaymentsRepo, times(1)).findAll(any(Specification.class), any(PageRequest.class));
//    }
//
//    @Test
//    void testFindById() {
//        when(dailyPaymentsRepo.findById(anyLong())).thenReturn(Optional.of(dailyPayments));
//        DailyPaymentResponse result = dailyPaymentService.findById(1L);
//        assertEquals(dailyPaymentResponse, result);
//        verify(dailyPaymentsRepo, times(1)).findById(anyLong());
//    }
//
//    @Test
//    void testFindById_NotFound() {
//        when(dailyPaymentsRepo.findById(anyLong())).thenReturn(Optional.empty());
//        assertThrows(DailyPaymentNotFoundException.class, () -> dailyPaymentService.findById(1L));
//        verify(dailyPaymentsRepo, times(1)).findById(anyLong());
//    }
//
//    @Test
//    void testSave() {
//        when(dailyPaymentsRepo.save(any(DailyPayments.class))).thenReturn(dailyPayments);
//        DailyPaymentResponse result = dailyPaymentService.save(dailyPaymentRequest);
//        assertEquals(dailyPaymentResponse, result);
//        verify(dailyPaymentsRepo, times(1)).save(any(DailyPayments.class));
//    }
//
//    @Test
//    void testUpdate() {
//        when(dailyPaymentsRepo.findById(anyLong())).thenReturn(Optional.of(dailyPayments));
//        when(dailyPaymentsRepo.save(any(DailyPayments.class))).thenReturn(dailyPayments);
//        DailyPaymentResponse result = dailyPaymentService.update(1L, dailyPaymentRequest);
//        assertEquals(dailyPaymentResponse, result);
//        verify(dailyPaymentsRepo, times(1)).findById(anyLong());
//        verify(dailyPaymentsRepo, times(1)).save(any(DailyPayments.class));
//    }
//
//    @Test
//    void testUpdate_NotFound() {
//        when(dailyPaymentsRepo.findById(anyLong())).thenReturn(Optional.empty());
//        assertThrows(DailyPaymentNotFoundException.class, () -> dailyPaymentService.update(1L, dailyPaymentRequest));
//        verify(dailyPaymentsRepo, times(1)).findById(anyLong());
//    }
//}