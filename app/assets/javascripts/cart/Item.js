define([
    'backbone'
], function (Backbone) {

    'use strict';

    var Item = Backbone.Model.extend({

        defaults: {
            id: null,
            product: null
        },

        urlRoot: '/cart/items'

    });

    return Item;

});