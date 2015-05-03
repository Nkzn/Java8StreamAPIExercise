package jp.water_cell.java.rxsample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jp.water_cell.java.rxsample.collections.models.City;
import jp.water_cell.java.rxsample.collections.models.Customer;
import jp.water_cell.java.rxsample.collections.ICollectionUtils;
import jp.water_cell.java.rxsample.collections.models.Order;
import jp.water_cell.java.rxsample.collections.models.Product;
import jp.water_cell.java.rxsample.collections.models.Shop;
import rx.Observable;

public interface ITestBase extends ICollectionUtils {

    //products
    Product idea = new Product("IntelliJ IDEA Ultimate", 199.0);
    Product reSharper = new Product("ReSharper", 149.0);
    Product dotTrace = new Product("DotTrace", 159.0);
    Product dotMemory = new Product("DotTrace", 129.0);
    Product dotCover = new Product("DotCover", 99.0);
    Product appCode = new Product("AppCode", 99.0);
    Product phpStorm = new Product("PhpStorm", 99.0);
    Product pyCharm = new Product("PyCharm", 99.0);
    Product rubyMine = new Product("RubyMine", 99.0);
    Product webStorm = new Product("WebStorm", 49.0);
    Product teamCity = new Product("TeamCity", 299.0);
    Product youTrack = new Product("YouTrack", 500.0);

    //customers
    String lucas = "Lucas";
    String cooper = "Cooper";
    String nathan = "Nathan";
    String reka = "Reka";
    String bajram = "Bajram";
    String asuka = "Asuka";

    //cities
    City Canberra = new City("Canberra");
    City Vancouver = new City("Vancouver");
    City Budapest = new City("Budapest");
    City Ankara = new City("Ankara");
    City Tokyo = new City("Tokyo");

    default Shop shop() {


        List<Customer> customers = new ArrayList<>();

        customers.add(customer(lucas, Canberra,
                order(reSharper),
                order(reSharper, dotMemory, dotTrace)
        ));
        customers.add(customer(cooper, Canberra));
        customers.add(customer(nathan, Vancouver,
                order(rubyMine, webStorm)
        ));
        customers.add(customer(reka, Budapest,
                order(false, idea),
                order(false, idea),
                order(idea)
        ));
        customers.add(customer(bajram, Ankara,
                order(reSharper)
        ));
        customers.add(customer(asuka, Tokyo,
                order(idea)
        ));

        return new Shop("test shop", customers);
    }

    default Customer customer(String name, City city, Order... orders) {
        return new Customer(name, city, Arrays.asList(orders));
    }

    default Order order(boolean isDelivered, Product... products) {
        return new Order(Arrays.asList(products), isDelivered);
    }

    default Order order(Product... products) {
        return order(true, products);
    }

    default Map<String, Customer> customers() {
        return Observable.from(shop().getCustomers())
                .toMap(Customer::getName)
                .toBlocking()
                .single();
    }

    default Set<Product> orderedProducts() {
        return setOf(idea, reSharper, dotTrace, dotMemory, rubyMine, webStorm);
    }

    default List<Customer> sortedCustomers() {
        return namesToCustomers(cooper, nathan, bajram, asuka, lucas, reka);
    }

    default Map<City, List<Customer>> groupByCities() {
        Map<City, List<Customer>> map = new HashMap<>();

        map.put(Canberra, namesToCustomers(lucas, cooper));
        map.put(Vancouver, namesToCustomers(nathan));
        map.put(Budapest, namesToCustomers(reka));
        map.put(Ankara, namesToCustomers(bajram));
        map.put(Tokyo, namesToCustomers(asuka));

        return map;
    }

    default List<Customer> namesToCustomers(String... names) {
        return Observable.from(names)
                .map(name -> customers().get(name))
                .toList()
                .toBlocking()
                .single();
    }
}
