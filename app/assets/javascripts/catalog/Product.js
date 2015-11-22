define([
    'backbone'
], function (Backbone) {

    'use strict';

    var Product = Backbone.Model.extend({

        defaults: {
            id: null,
            price: null,
            name: null,
            description: null,
            image: null
        },

        urlRoot: '/catalog/products'

    });

    return Product;

});