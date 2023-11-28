package com.gofar.citzenswsclient.repository.impl;

import com.gofar.citzenswsclient.entity.Citizen;
import com.gofar.citzenswsclient.repository.CustomRepository;
import com.gofar.citzenswsclient.utils.CitizenDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Slf4j
public class CustomerRepositoryImpl implements CustomRepository {

    private MongoTemplate mongoTemplate;

    @Override
    public Citizen updateCitizen(String cin, CitizenDto citizenDto) {
        Query query = new Query(Criteria.where("cin").is(cin));
        Map<String, String> map = filterSearchField(citizenDto);
        Update update = new Update();
        map.keySet().forEach(key -> update.set(key, map.get(key)));
        mongoTemplate.updateFirst(query, update, Citizen.class);
        return mongoTemplate.findOne(new Query(Criteria.where("cin").is(cin)), Citizen.class);
    }

    @Override
    public Citizen updateCitizen(Citizen citizen) {
        Citizen old;
        Query query = new Query(Criteria.where("cin").is(citizen.getCin()));
        old = Objects.requireNonNull(mongoTemplate.findOne(query, Citizen.class));
        Objects.requireNonNull(old);
        old = mapping(citizen);
        Update update = new Update();
        update.set("citizen", old);
        mongoTemplate.save(old);
        return null;
    }

    @Override
    public List<Citizen> search(CitizenDto dto) {
        Query query = new Query();
        List<String> fields = getNonNullFields(dto);
        List<Criteria> criteriaList = new ArrayList<>();
        fields.forEach(field -> {
            try {
                criteriaList.add(Criteria.where(field).is(getProperty(dto, field)));
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        });
        query.addCriteria(new Criteria().orOperator(criteriaList));
        return mongoTemplate.find(query, Citizen.class);
    }

    private Map<String, String> filterSearchField(CitizenDto dto) {
        Map<String, String> map = dto.getKeyValues();
        return map.entrySet().stream().filter(entry -> !Objects.isNull(entry.getValue()) && !entry.getValue().trim().isEmpty()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public List<String> getNonNullFields(CitizenDto dto) {
        return Arrays.stream(dto.getClass().getDeclaredFields()).map(Field::getName).toList().stream().filter(
                field -> {
                    try {
                        return Objects.nonNull(getProperty(dto, field));
                    } catch (Exception e) {
                        log.error(e.getMessage());
                    }
                    return false;
                }
        ).toList();
    }

    public Citizen mapping(Citizen citizenFromWsMapped) {
        Citizen updated = new Citizen();
        final List<String> fields = Arrays.stream(citizenFromWsMapped.getClass().getDeclaredFields()).map(Field::getName).toList();
        fields.forEach(field -> {
            try {
                setProperty(updated, field, getProperty(citizenFromWsMapped, field));
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        });
        return updated;
    }

    private Object getProperty(Object obj, String property) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String getterMethodName = "get" + property.substring(0,1).toUpperCase() + property.substring(1);
        Method method = obj.getClass().getMethod(getterMethodName);
        return method.invoke(obj);
    }

    private void setProperty(Object obj, String property, Object value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String setterMethodName = "set" + property.substring(0,1).toUpperCase() + property.substring(1);
        Method method = obj.getClass().getMethod(setterMethodName, value.getClass());
        method.invoke(obj, value);
    }

    @Autowired
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}
