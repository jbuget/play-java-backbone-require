define([
    'backbone',
    'catalog/Product'
], function (Backbone, Product) {

    'use strict';

    var ProductList = Backbone.Collection.extend({

        model: Product,

        url: '/catalog/products'

    });

    return ProductList;

});