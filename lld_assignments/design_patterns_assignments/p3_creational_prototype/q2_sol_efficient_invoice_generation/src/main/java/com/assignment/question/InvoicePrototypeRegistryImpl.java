
package com.assignment.question;

import java.util.*;

public class InvoicePrototypeRegistryImpl implements InvoicePrototypeRegistry {

    private HashMap<InvoiceType, Invoice> typeInvoiceMap = new HashMap<>();

    public void addPrototype(Invoice user) {
        typeInvoiceMap.put(user.getType(), user);
    }

    public Invoice getPrototype(InvoiceType type) {
        return typeInvoiceMap.get(type);
    }

    public Invoice clone(InvoiceType type) {
        return typeInvoiceMap.get(type).cloneObject();
    }

}