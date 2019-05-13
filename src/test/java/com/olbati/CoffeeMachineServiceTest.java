package com.olbati;

import com.olbati.beans.DrinkBean;
import com.olbati.beans.OrderBean;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoffeeMachineServiceTest {
    private CoffeeMachineService coffeeMachineService = new CoffeeMachineService();

    @Test
    public void drink_maker_should_make_1_tea_with_1_sugar_and_a_stick() {
        //Arrange
        DrinkBean drinkExpected = new DrinkBean();
        drinkExpected.setDrink("TEA");
        drinkExpected.setSugar(1);
        drinkExpected.setStick(true);
        //Act
        coffeeMachineService.command("T:1:0",5.0);
        DrinkBean drink = coffeeMachineService.getDrinkRequested();
        //Assert
        assertThat(drink.toString()).isEqualTo(drinkExpected.toString());
    }

    @Test
    public void drink_maker_should_make_1_chocolate_with_0_sugar_and_no_stick() {
        //Arrange
        DrinkBean drinkExpected = new DrinkBean();
        drinkExpected.setDrink("CHOCOLATE");
        drinkExpected.setSugar(0);
        drinkExpected.setStick(false);
        //Act
        coffeeMachineService.command("H::",5.0);
        DrinkBean drink = coffeeMachineService.getDrinkRequested();
        //Assert
        assertThat(drink.toString()).isEqualTo(drinkExpected.toString());
    }

    @Test
    public void drink_maker_should_make_1_coffee_with_2_sugar_and_a_stick() {
        //Arrange
        DrinkBean drinkExpected = new DrinkBean();
        drinkExpected.setDrink("COFFEE");
        drinkExpected.setSugar(2);
        drinkExpected.setStick(true);
        //Act
        coffeeMachineService.command("C:2:0",5.0);
        DrinkBean drink = coffeeMachineService.getDrinkRequested();
        //Assert
        assertThat(drink.toString()).isEqualTo(drinkExpected.toString());
    }

    @Test
    public void drink_maker_should_return_message_entered() {
        //Arrange
        DrinkBean drinkExpected = new DrinkBean();
        drinkExpected.setDrink("M");
        drinkExpected.setMessage("Error while making drink");
        //Act
        coffeeMachineService.command("M:Error while making drink",0.0);
        DrinkBean drink = coffeeMachineService.getDrinkRequested();
        //Assert
        assertThat(drink.toString()).isEqualTo(drinkExpected.toString());
    }

    //One tea is 0,4 euro, a coffee is 0,6 euro, a chocolate is 0,5 euro.
    @Test
    public void drink_maker_should_make_tea_only_if_amount_bigger_than_04() {
        //Arrange
        DrinkBean drinkExpected = new DrinkBean();
        drinkExpected.setDrink("M");
        drinkExpected.setMessage("Not enough money is given, please add : " +Double.valueOf(0.4-0.3));
        //Act
        coffeeMachineService.command("T:2:0",0.3);
        DrinkBean drink = coffeeMachineService.getDrinkRequested();
        //Assert
        assertThat(drink.toString()).isEqualTo(drinkExpected.toString());
        assertThat(drink.isServed()).isEqualTo(false);
    }
    @Test
    public void drink_maker_should_make_coffee_only_if_amount_bigger_than_06() {
        //Arrange
        DrinkBean drinkExpected = new DrinkBean();
        drinkExpected.setDrink("M");
        drinkExpected.setMessage("Not enough money is given, please add : " +Double.valueOf(0.6-0.3));
        //Act
        coffeeMachineService.command("C:2:0",0.3);
        DrinkBean drink = coffeeMachineService.getDrinkRequested();
        //Assert
        assertThat(drink.toString()).isEqualTo(drinkExpected.toString());
        assertThat(drink.isServed()).isEqualTo(false);
    }
    @Test
    public void drink_maker_should_make_chocolate_only_if_amount_bigger_than_05() {
        //Arrange
        DrinkBean drinkExpected = new DrinkBean();
        drinkExpected.setDrink("M");
        drinkExpected.setMessage("Not enough money is given, please add : " +Double.valueOf(0.5-0.3));
        //Act
        coffeeMachineService.command("H::",0.3);
        DrinkBean drink = coffeeMachineService.getDrinkRequested();
        //Assert
        assertThat(drink.toString()).isEqualTo(drinkExpected.toString());
        assertThat(drink.isServed()).isEqualTo(false);
    }
    @Test
    public void drink_maker_should_make_1_orange_juice() {
        //Arrange
        DrinkBean drinkExpected = new DrinkBean();
        drinkExpected.setDrink("ORANGE");
        //Act
        coffeeMachineService.command("O::",0.6);
        DrinkBean drink = coffeeMachineService.getDrinkRequested();
        //Assert
        assertThat(drink.toString()).isEqualTo(drinkExpected.toString());
    }

    @Test
    public void drink_maker_should_make_1_extra_hot_tea_with_1_sugar_and_a_stick() {
        //Arrange
        DrinkBean drinkExpected = new DrinkBean();
        drinkExpected.setDrink("EXTRA_HOT_TEA");
        drinkExpected.setSugar(1);
        drinkExpected.setStick(true);
        //Act
        coffeeMachineService.command("Th:1:0",5.0);
        DrinkBean drink = coffeeMachineService.getDrinkRequested();
        //Assert
        assertThat(drink.toString()).isEqualTo(drinkExpected.toString());
    }

    @Test
    public void drink_maker_should_make_1_extra_hot_chocolate_with_0_sugar_and_no_stick() {
        //Arrange
        DrinkBean drinkExpected = new DrinkBean();
        drinkExpected.setDrink("EXTRA_HOT_CHOCOLATE");
        drinkExpected.setSugar(0);
        drinkExpected.setStick(false);
        //Act
        coffeeMachineService.command("Hh::",5.0);
        DrinkBean drink = coffeeMachineService.getDrinkRequested();
        //Assert
        assertThat(drink.toString()).isEqualTo(drinkExpected.toString());
    }

    @Test
    public void drink_maker_should_make_1_extra_hot_offee_with_2_sugar_and_a_stick() {
        //Arrange
        DrinkBean drinkExpected = new DrinkBean();
        drinkExpected.setDrink("EXTRA_HOT_COFFEE");
        drinkExpected.setSugar(2);
        drinkExpected.setStick(true);
        //Act
        coffeeMachineService.command("Ch:2:0",5.0);
        DrinkBean drink = coffeeMachineService.getDrinkRequested();
        //Assert
        assertThat(drink.toString()).isEqualTo(drinkExpected.toString());
    }

}
