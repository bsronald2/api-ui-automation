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

    /**
     * This method gets a subset of DSE Entities according to object type passed as Parameter
     * @param objectType e.g. Message, Product, Account
     * @return Map containing objects sub-set of the same type
     */
    public Map<String, Object> filterByObjectType(String objectType) {
        Map<String, Object> result = new LinkedHashMap<>()

        for (Map.Entry<String, Object> entity : entities.entrySet()) {
            if (entity.getKey().contains(objectType)) {
                result.put(entity.getKey(), entity.getValue())
            }
        }

        return result
    }
}
