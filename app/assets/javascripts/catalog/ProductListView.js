define([
    'jquery',
    'underscore',
    'bootstrap',
    'backbone',
    'CartItemsBadge',
    'catalog/Product'
], function ($, _, Bootstrap, Backbone, CartItemsBadge, Product) {

    'use strict';

    var ProductListView = Backbone.View.extend({

        template: _.template($('#product-list-template').html()),

        events: {
            'click .add-to-cart.btn': 'addProductToCart',
            'click .product img': 'displayProductDetails'
        },

        render: function () {
            var self = this;
            this.collection.fetch({
                success: function (collection) {
                    var dom = self.template({products: collection.models});
                    self.$el.html(dom);
                }
            });
            return this;
        },

        displayProductDetails: function (event) {
            var productId = $(event.currentTarget).data('product-id'),
                product = new Product({id: productId});

            product.fetch({success: function (model) {
                var $modal = $("#product-details-modal"),
                    template = _.template($('#product-template').html());
                $modal.find('.modal-placeholder').html(template({product: model}));
                $modal.modal('toggle');
            }});
        },

        addProductToCart: function (event) {
            var $el = $(event.currentTarget),
                productId = $el.data('product-id');
            $el.blur();
            $.ajax({
                url: '/cart/items',
                type: 'POST',
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                data: JSON.stringify({productId: productId}),
                success: function (data) {
                    if (data.error) {
                        console.error('An error occurred: ' + data.error.text);
                    }
                    CartItemsBadge.update();
                }
            });

            console.log('productId=' + productId);
        }

    });

    return ProductListView;

});