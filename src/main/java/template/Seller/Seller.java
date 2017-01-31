package template.Seller;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Seller {
    @NotNull
    @Size(min=32, max=32)
    private String id;

    @NotNull
    @Size(min=32, max=32)
    private String sellerId;

    @NotNull
    @Size(min=32, max=32)
    private String bookId;

    public Seller(String id, String sellerId, String bookId) {
        this.id = id;
        this.sellerId = sellerId;
        this.bookId = bookId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public boolean validate() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(this).size() == 0;
    }
}
