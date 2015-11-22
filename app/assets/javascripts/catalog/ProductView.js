define([
    'backbone',
    'catalog/Product'
], function (Backbone, Product) {

    'use strict';

    var ProductView = Backbone.View.extend({

        template: _.template($('#product-template').html()),

        render: function() {
            var self = this;
            this.model.fetch({
                success: function (model) {
                    self.$el.html(self.template({product: model}));
                }
            });
            return this;
        }

    });

    return ProductView;

});