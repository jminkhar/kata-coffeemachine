package com.olbati;

import com.olbati.report.DailyReports;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;


public class CoffeeMachinReportingTest {
    @Mock
    DailyReports dailyReportsMock;
    @InjectMocks
    CoffeeMachineService coffeeMachineService = new CoffeeMachineService();

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReportWhenTheDrinkIsServed() {
        doReturn(true).when(dailyReportsMock).record(any());
        coffeeMachineService.command("T:1:0", 5.0);
        verify(dailyReportsMock).record(any());
    }
    @Test
    public void shouldNotReportWhenTheDrinkIsNotServed() {
        //doReturn(true).when(dailyReportsMock).record(any());
        coffeeMachineService.command("T:1:0", 0.0);
        verifyZeroInteractions(dailyReportsMock);
    }
}
