package com.auto.utils

class MapUtils {

    /**
     * This method parse list of entities into a map using a key word as prefix i.e. Project.
     * The prefix will be appended using the code ascii A.
     * @param keyPrefix
     * @param listObj
     * @return
     */
    public static Map<String, ?> listToMap(String keyPrefix, List<?> listObj) {
        int character = new Integer(Constants.CODE_ASCII_A).intValue()
        def newMap = listObj.collectEntries { it ->
            [(keyPrefix + Character.toChars(character++)): it]
        }
        println(newMap.collect {it})

        return newMap
    }
}
