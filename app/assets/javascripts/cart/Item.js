define([
    'backbone'
], function (Backbone) {

    'use strict';

    var Item = Backbone.Model.extend({

        defaults: {
            id: null,
            price: null,
            name: null,
            description: null,
            image: null
        },

        urlRoot: '/cart/items'

    });

    return Item;

});