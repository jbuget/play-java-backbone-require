define([
    'jquery',
    'backbone'
], function ($, Backbone) {

    'use strict';

    var Router = Backbone.Router.extend({

        routes: {
            "": 'displayViewItems'
        },

        currentView: null,

        displayViewItems: function () {
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