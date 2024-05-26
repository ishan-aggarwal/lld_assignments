package com.assignment.question;

import java.util.HashMap;

class UserPrototypeRegistryImpl implements UserPrototypeRegistry {

    HashMap<UserType, User> typeUserHashMap = new HashMap<>();

    public void addPrototype(User user) {
        typeUserHashMap.put(user.getType(), user);
    }

    public User getPrototype(UserType type) {
        return typeUserHashMap.get(type);
    }

    public User clone(UserType type) {
        return typeUserHashMap.get(type).cloneObject();
    }
}