define([
    'jquery',
    'backbone',
    'catalog/Product',
    'catalog/ProductList',
    'catalog/ProductView',
    'catalog/ProductListView'
], function ($, Backbone, Product, ProductList, ProductView, ProductListView) {

    'use strict';

    var Router = Backbone.Router.extend({

        routes: {
            "":             'displayProductListView',
            "products":     'displayProductListView',
            "products/:id": 'displayProductView'
        },

        currentView: null,

        displayProductListView: function () {
            var products = new ProductList(),
                view = new ProductListView({collection: products});
            this.displayView(view);
        },

        displayProductView: function (id) {
            var product = new Product({id: id}),
                view = new ProductView({model: product});
            this.displayView(view);
        },
        
        displayView: function (view) {
            if (this.currentView){
                this.currentView.close();
            }
            this.currentView = view;
            this.currentView.render();
            $("#app").html(this.currentView.el);
        }

    });

    return Router;

});