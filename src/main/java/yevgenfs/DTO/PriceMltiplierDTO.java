package yevgenfs.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import yevgenfs.exceptions.NoSuchBookException;
import yevgenfs.model.PriceMultiplierEntity;
import yevgenfs.model.UserBankEntity;

public class PriceMltiplierDTO extends ResourceSupport {

    PriceMultiplierEntity priceMultiplier;
    public PriceMltiplierDTO(PriceMultiplierEntity priceMultiplier, Link selfLink) throws NoSuchBookException {
        this.priceMultiplier=priceMultiplier;
        add(selfLink);
    }

    public String getTypeOfBus() {
        return priceMultiplier.getTypeOfBus();

    }

    public Integer getPriceCountercol() {
        return priceMultiplier.getPriceCountercol();
    }


}
