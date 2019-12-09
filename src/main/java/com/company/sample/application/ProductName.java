package com.company.sample.application;

import com.google.common.base.Enums;

import com.google.common.base.Optional;

public enum ProductName{

    APPLE, ORANGE, PINEAPPLE;

    /**
     * Pick a random value of the ProductName enum.
     * @return a random ProductName.
     */
    public static Optional<ProductName> getProductName(String name) {
        /**
         * Here is attempting to parse a value not found in the enum, resulting in an exception being thrown, comment the below lines
         */
        ProductName productName = ProductName.valueOf(name);
        return Optional.of(productName);

        /**
         * Resolution: uncomment the following line to see how this improves the profile.
         */
//        return Enums.getIfPresent(ProductName.class, name);
    }
}
