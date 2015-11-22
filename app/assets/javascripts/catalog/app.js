define([
    'catalog/router'
], function (Router) {

    'use strict';

    var App = {
        init: function () {
            new Router();
            Backbone.history.start();
        }
    };

    return App;
});