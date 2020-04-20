package com.auto.utils

class EntityManager {

    private HashMap<String, Object> entities

    public EntityManager() {
        this.entities = new HashMap()
    }

    public void merge(HashMap otherEntities) {
        entities.putAll(otherEntities)
    }

    public void clear() {
        entities.clear()
    }

    public Object getEntity(String entityName) {
        return entities.get(entityName)
    }

    public void put(String entityName, Object object) {
        entities.put(entityName, object)
    }
}
