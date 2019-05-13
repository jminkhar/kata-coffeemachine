package com.olbati;

import com.olbati.beans.OrderBean;
import com.olbati.services.CoffeeMachine;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EmptyCoffeeMachineTest {
    @Mock
    CoffeeMachine CoffeeMachineCoreMock;
    @InjectMocks
    CoffeeMachineService coffeeMachineService = new CoffeeMachineService();

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void shouldSendMailWhenItIsEmpty() {
        doReturn(true).when(CoffeeMachineCoreMock).isEmpty(any(OrderBean.class));
        coffeeMachineService.command("T:1:0", 5.0);
        verify(CoffeeMachineCoreMock).notifyMissingDrink(any(OrderBean.class));
    }
    @Test
    public void shouldNotSendMailWhenItIsNotEmpty() {
        doReturn(false).when(CoffeeMachineCoreMock).isEmpty(any(OrderBean.class));
        coffeeMachineService.command("T:1:0", 5.0);
        verify(CoffeeMachineCoreMock).isEmpty(any(OrderBean.class));
        verifyNoMoreInteractions(CoffeeMachineCoreMock);
    }
}
