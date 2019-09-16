package com.bingley.dbapplicaion.db.test.dbconverter;

import com.bingley.dbapplicaion.db.test.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.List;


/**
 * @author bingley
 * @date 2019/9/12.
 */
public class StudentConverter implements PropertyConverter<List<Student>,String> {
    @Override
    public List<Student> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        }
        // 先得获得这个，然后再typeToken.getType()，否则会异常
        TypeToken<List<Student>> typeToken = new TypeToken<List<Student>>(){};
        return new Gson().fromJson(databaseValue, typeToken.getType());
    }

    @Override
    public String convertToDatabaseValue(List<Student> entityProperty) {
        if (entityProperty == null||entityProperty.size()==0) {
            return null;
        } else {
            String sb = new Gson().toJson(entityProperty);
            return sb;

        }
    }
}
