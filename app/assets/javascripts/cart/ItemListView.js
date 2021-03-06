define([
    'jquery',
    'underscore',
    'backbone'
], function ($, _, Bootstrap, Backbone) {

    'use strict';

    var ItemListView = Backbone.View.extend({

        template: _.template($('#item-list-template').html()),

        render: function () {
            var self = this;
            this.collection.fetch({
                success: function (collection) {
                    var dom = self.template({items: collection.models});
                    self.$el.html(dom);
                }
            });
            return this;
        }

    });

    return ItemListView;

});