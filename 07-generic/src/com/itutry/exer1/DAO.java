package com.itutry.exer1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO<T> {

  private Map<String, T> map = new HashMap<>();

  public void save(String id, T entity) {
    if (!map.containsKey(id)) {
      map.put(id, entity);
    }
  }

  public T get(String id) {
    return map.get(id);
  }

  public void update(String id, T entity) {
    if (map.containsKey(id)) {
      map.put(id, entity);
    }
  }

  public List<T> list() {
    return new ArrayList<>(map.values());
  }

  public void delete(String id) {
    map.remove(id);
  }
}
