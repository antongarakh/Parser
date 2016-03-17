package by.websolutions.test.model;

/**
 * Created by Anton on 16.03.2016.
 */
public class ExtraData {
    String fieldName;
    String fieldType;
    String fieldValue;
    String fieldLevel;
    String fieldID;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getFieldLevel() {
        return fieldLevel;
    }

    public void setFieldLevel(String fieldLevel) {
        this.fieldLevel = fieldLevel;
    }

    public String getFieldID() {
        return fieldID;
    }

    public void setFieldID(String fieldID) {
        this.fieldID = fieldID;
    }

    public ExtraData(String fieldName, String fieldType, String fieldValue, String fieldLevel, String fieldID) {

        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.fieldValue = fieldValue;
        this.fieldLevel = fieldLevel;
        this.fieldID = fieldID;
    }
}
