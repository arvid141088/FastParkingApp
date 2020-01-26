package com.gmit.arvids.its.repository;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.gmit.arvids.its.repository.entity.CarParkLocationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class BaseJdbcTemplate {

    @Autowired
    private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private ObjectMapper objectMapper;

    @PostConstruct
    public void onInit() {
        objectMapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    public <T> List<T> queryForList(String sql, Map<String, Object> params, Class<T> elementType) {
        BeanPropertyRowMapper<CarParkLocationEntity> mapper = BeanPropertyRowMapper.newInstance(CarParkLocationEntity.class);
        List<Map<String, Object>> result = namedParameterJdbcTemplate.queryForList(sql, params);
        List<T> parsedResult = result.stream()
                .map(value -> objectMapper.convertValue(value, elementType))
                .collect(Collectors.toList());
        return parsedResult;
    }

    public <T> T queryForObject(String sql, Map<String, Object> params, Class<T> elementType) {
        BeanPropertyRowMapper<CarParkLocationEntity> mapper = BeanPropertyRowMapper.newInstance(CarParkLocationEntity.class);
        Map<String, Object> result = namedParameterJdbcTemplate.queryForMap(sql, params);
        return objectMapper.convertValue(result, elementType);
    }

    public Integer insert(String insertQuery, Map<String, ?> params) {
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource sqlParams = new MapSqlParameterSource(params);
        namedParameterJdbcTemplate.update(insertQuery,sqlParams, keyHolder);
        return generatedKey(keyHolder);
    }

    private Integer generatedKey(final KeyHolder keyHolder) {
        try {
            if (keyHolder.getKey() != null) {
                return keyHolder.getKey().intValue();
            } else {
                return null;
            }
        } catch (InvalidDataAccessApiUsageException e) {
            // Multiple keys returned (for example in the INSERT ... ON DUPLICATE KEY UPDATE statement)
            return null;
        }
    }

    public int update(String updateQuery, Map<String, ?> params) {
        return namedParameterJdbcTemplate.update(updateQuery, params);
    }

}
