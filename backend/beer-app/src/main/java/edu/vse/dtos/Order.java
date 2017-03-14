package edu.vse.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.vse.utils.UriConstants;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.WRAPPER_OBJECT;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;
import static org.springframework.util.Assert.notNull;

@JsonTypeInfo(include = WRAPPER_OBJECT, use = NAME)
@JsonTypeName("order")
@JsonInclude(NON_NULL)
public class Order {

    private final Integer id;
    private final String user;
    private final String status;
    private final String paymentType;
    private final String shipping;
    private final String shippingAddress;
    private final String billingAddress;
    private final Links links;

    public Order(Integer id, Integer user, String status, String paymentType, Integer shipping, Integer shippingAddress, Integer billingAddress) {
        this.id = id;
        this.user = UriConstants.user.expand(user).toString();
        this.status = status;
        this.paymentType = paymentType;
        this.shipping = UriConstants.shipping.expand(shipping).toString();
        this.shippingAddress = UriConstants.address.expand(shipping).toString();
        this.billingAddress = billingAddress == null ? null : UriConstants.address.expand(billingAddress).toString();
        this.links = new Links(id);
    }

    public Integer getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getStatus() {
        return status;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getShipping() {
        return shipping;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public Links getLinks() {
        return links;
    }

    public static class Links {
        private final String self;
        private final String ordersPackages;

        public Links(Integer id) {
            notNull(id, "Id is mandatory");

            this.self = UriConstants.order.expand(id).toString();
            this.ordersPackages = UriConstants.ordersPackages.expand(id).toString();
        }

        public String getSelf() {
            return self;
        }

        public String getOrdersPackages() {
            return ordersPackages;
        }
    }
}
