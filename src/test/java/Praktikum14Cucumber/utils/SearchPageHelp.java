package Praktikum14Cucumber.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class SearchPageHelp {

    public void selectSorting(WebElement element, String value){
        Select displaySorting = new Select(element);
        displaySorting.selectByVisibleText(value);
    }

    public List<Integer> getListPrice(List<WebElement> list) {
        List<Integer> prices = new ArrayList<>();
        for (WebElement price:list){
         prices.add(Integer.parseInt(price.getText().replaceAll("\\D+",""))/100);
        }
        return prices;
    }

    public List<String> getListNameProduct(List<WebElement> list){
    List<String> namesProduct = new ArrayList<>();
    for(WebElement name:list){
        namesProduct.add(name.getText());
    }
    return  namesProduct;
    }

    public int getAmountProductByCategory(WebElement element){
        return Integer.parseInt(element.getText());
    }

    public String getMaxAmountProductDisplayed(WebElement element){
        String amountDisplayed;
        int amount = getAmountProductByCategory(element);
        if(amount<=12){
            amountDisplayed = "12";
        } else if (amount<=25) {
            amountDisplayed = "25";
        } else if (amount<=50) {
            amountDisplayed = "50";
        } else if (amount<=75) {
            amountDisplayed = "75";
        }else {
            amountDisplayed ="100";
        }
        return amountDisplayed;
    }

    public int randomizer(List<WebElement> list){
        Random random = new Random();
        return random.nextInt( list.size());
    }

    public int getIndexProductInListByName(List<WebElement> list, String name){
        int index=0;
        for(WebElement ind:list){
            if(name.equals(ind.getAttribute("title"))){
                break;
            }else{
                index++;
            }
        }
        return index;
    }

    public int getAmountByValue(List<WebElement> list, String value){
        int amount = 0;
        for(WebElement element:list){
            if(element.getText().contains(value)){
                amount++;
            }
        }
        return amount;
    }

    public String buildDynamicMessage(String message, String nameProduct){
        return String.format(ConfigurationReader.get(message),nameProduct);
    }

    public List<String> getAmountBySelect(List<WebElement> amounts){
        List <String> amountsProduct = new ArrayList<>();
        for (WebElement amount:amounts){
            Select amountProductSelect = new Select(amount);
            amountsProduct.add(amountProductSelect.getFirstSelectedOption().getText());
        }
        return amountsProduct;
    }

    public Map<String, String> getMapProductInCart(List<WebElement> names, List<String> amounts){
        Map<String,String> mapProductInCart = new HashMap<>();

        for (int i = 0; i < names.size(); i++) {
            mapProductInCart.put(names.get(i).getText(),amounts.get(i));
        }
        return mapProductInCart;
    }
}
