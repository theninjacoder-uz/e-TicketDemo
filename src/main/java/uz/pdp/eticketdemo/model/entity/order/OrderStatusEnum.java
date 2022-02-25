package uz.pdp.eticketdemo.model.entity.order;

public enum OrderStatusEnum {
    PENDING(1),
    PURCHASED_AND_ACTIVE(2),
    PURCHASED_AND_EXPIRED(4),
    PURCHASED_AND_ARCHIVED(8);
    //TODO enum may be extended

    OrderStatusEnum(int i) {
    }
}
