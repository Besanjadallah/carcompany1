package test;


import io.cucumber.java.en.*;
import org.example.Main;
import car.*;

import java.util.ArrayList;
import java.util.List;

import static org.example.Main.getproductList;
import static org.example.Main.orderstep1;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static car.Installer.*;
import static car.Order.*;

public class OrdersManagement {
    Order order;
    Category category;
    private String name;
    public List<Product> orderedProducts1=new ArrayList<>();
    private List<Product> Products1;
    //
    public static List<Order> orderList=new ArrayList<>();
    public static List<Category> categoryList=new ArrayList<>();

    @Given("they choose Place Order")
    public void theyChoosePlaceOrder() {
        order.setPlaceOrder(true);
        assertTrue(isPlaceOrder());
    }
    @When("product name is {string}")
    public void productNameIs(String string) {
        this.name=string;
    }
    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        //orderedProducts1.add()
        Products1=getproductList();
        Product product=new Product("light",20,"light",20);
        int n=product.getAvailablity();
        //System.out.println(n);
        orderedProducts1.add(product);
        Order order1=new Order(1,orderedProducts1);
        Main.listProductsOrder();
        Main.listProducts(orderedProducts1);
        Main.productsearch(name);
        orderstep1(name,orderedProducts1);
    }

    @Given("they choose List Orders")
    public void theyChooseListOrders() {
        order.setListOrder(true);
        assertTrue(isListOrder());
    }
    @Then("they should see a list of placed orders")
    public void theyShouldSeeAListOfPlacedOrders() {
    }

    @Then("they should see a list of available product categories")
    public void theyShouldSeeAListOfAvailableProductCategories() {
        order.setListCategories(true);
        assertTrue(isListCategories());
    }


    @Given("they choose List Categories")
    public void theyChooseListCategories() {

    }
}

