define([
    'jquery',
    'underscore',
    'backbone'
], function ($, _, Backbone) {

    'use strict';

    Backbone.View.prototype.close = function () {
        this.remove();
        this.unbind();
        if (this.onClose) {
            this.onClose();
        }
    };

});