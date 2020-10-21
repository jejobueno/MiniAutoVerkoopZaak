package be.intecbrussel.converter;

import be.intecbrussel.enums.Status;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status,String> {

    @Override
    public String convertToDatabaseColumn(Status status) {
        return status.getStatus();
    }

    @Override
    public Status convertToEntityAttribute(String dbData) {
        switch (dbData){
            case "Resolved":
                return Status.RESOLVED;
            case "Cancelled":
                return Status.CANCELLED;
            case "Disputed":
                return Status.DISPUTED;
            case "In Process":
                return Status.IN_PROCESS;
            case "On Hold":
                return Status.ON_HOLD;
            case "Shipped":
                return Status.SHIPPED;
            default:
                throw new IllegalArgumentException("Status [" + dbData + "] not suported");
        }
    }
}
