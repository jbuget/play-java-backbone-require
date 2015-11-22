define([
    'backbone',
    'cart/Item'
], function (Backbone, Item) {

    'use strict';

    var ItemList = Backbone.Collection.extend({

        model: Item,

        url: '/cart/items'

    });

    return ItemList;

});