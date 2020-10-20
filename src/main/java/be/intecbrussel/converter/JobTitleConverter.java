package be.intecbrussel.converter;

import be.intecbrussel.enums.JobTitle;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class JobTitleConverter implements AttributeConverter<JobTitle,String> {

    @Override
    public String convertToDatabaseColumn(JobTitle title) {
        return title.getJobTitle();
    }

    @Override
    public JobTitle convertToEntityAttribute(String dbData) {
        switch (dbData){
            case "Sales Rep":
                return JobTitle.SALES_REP;
            case "President":
                return JobTitle.PRESIDENT;
            case "Sales Manager (APAC)":
                return JobTitle.SALES_MANAGER_APAC;
            case "Sales Manager (EMEA)":
                return JobTitle.SALES_MANAGER_EMEA;
            case "Sales Manager (NA)":
                return JobTitle.SALES_MANAGER_NA;
            case "Vp Marketing":
                return JobTitle.VP_MARKETING;
            case "VP sales":
                return JobTitle.VP_SALES;
            default:
                throw new IllegalArgumentException("Job title [" + dbData + "] not suported");
        }
    }
}
