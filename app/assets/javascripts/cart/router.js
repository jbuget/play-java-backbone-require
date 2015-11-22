define([
    'jquery',
    'backbone',
    'cart/ItemList',
    'cart/ItemListView'
], function ($, Backbone, ItemList, ItemListView) {

    'use strict';

    var Router = Backbone.Router.extend({

        routes: {
            "": 'displayViewItems'
        },

        currentView: null,

        displayViewItems: function () {
            var items = new ItemList(),
                view = new ItemListView({collection: items});
            this.displayView(view);
        },

        displayView: function (view) {
            if (this.currentView) {
                this.currentView.close();
            }
            this.currentView = view;
            this.currentView.render();
            $("#app").html(this.currentView.el);
        }

    });

    return Router;

});